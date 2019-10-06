import { uploadReceipt } from "../api/expenses";
import { NativeModules } from "react-native";
import { eng, esp, fra, por } from "./constants";
import { fromLocale } from "../store/modules/expenses";
import { useSelector } from "react-redux";
import { ExpenseSchema, UserSchema, AmountSchema } from "./schema.js";
import i18n from "i18n-js";
import { values } from "ramda";

const CameraApplication = NativeModules.NativeCameraModule;
export const initReceiptMenu = async expenseId => {
  try {
    const message = await CameraApplication.initReceiptCapture(expenseId);
    console.log(message);
    uploadReceipt(expenseId, message);
  } catch (error) {
    console.error(error);
  }
};

export const storeDataOffline = expenses => {
  console.log("biggie", expenses);

  expenses.map(expense => {
    Realm.open({
      schema: [ExpenseSchema, AmountSchema, UserSchema]
    }).then(realm => {
      realm.write(() => {
        const existingExpense = realm.objectForPrimaryKey(
          "expense",
          expense.id
        );
        if (existingExpense === null) {
          const expenseItem = realm.create("expense", expense);
          console.log("itemmm", expenseItem);
        }
      });
    });
  });
};

const normaliseData = () => {};

export const getDataFromnDB = async mnodel => {
  try {
    const realm = await Realm.open({
      schema: [ExpenseSchema, UserSchema, AmountSchema]
    });
    const data = realm.objects(model);

    if (data) {
      return values(data);
    }
  } catch (err) {
    console.log(err);
  }
};

// const [array, setArray] = useDataFromDB()

export function getArrayFromDb() {
  const [data, setData] = useState([]);
  const Realm = require("realm");
  console.log("trying fetchdb");
  Realm.open({ schema: [ExpenseSchema, UserSchema, AmountSchema] }).then(
    realm => {
      const expenses = realm.objects("expense");
      const values = Object.values(expenses);
      if (expenses !== null) {
        values.map(obj => {
          setData(data => [...data, obj]);
        });
        return data;
      }
    }
  );
  return data;
}

export function initLocalization() {
  const currentLocale = useSelector(fromLocale);
  i18n.fallbacks = true;
  i18n.translations = { eng, esp, fra, por };
  i18n.locale = currentLocale;
}

export const onSearchTermUpdated = (term, expensesState) => {
  const userFilter = expense => {
    return Object.values(expense.user)
      .toString()
      .toLowerCase()
      .includes(term.toLowerCase());
  };
  const amountFilter = expense => {
    return Object.values(expense.amount)
      .toString()
      .toLowerCase()
      .includes(term.toLowerCase());
  };
  const merchantFilter = expense => {
    return expense.merchant.toLowerCase().includes(term.toLowerCase());
  };
  const filteredResults = expensesState.filter(
    expense =>
      merchantFilter(expense) || userFilter(expense) || amountFilter(expense)
  );
  return filteredResults;
  setSearchTerm(term);
};
