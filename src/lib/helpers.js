import { uploadReceipt } from "../api/expenses";
import { NativeModules } from "react-native";
import { ExpenseSchema, UserSchema, AmountSchema } from "./schema";
import { values } from "ramda";

const CameraApplication = NativeModules.NativeCameraModule;
const Realm = require("realm");
export const initReceiptMenu = async expenseId => {
  try {
    const message = await CameraApplication.initReceiptCapture(expenseId);
    uploadReceipt(expenseId, message);
  } catch (error) {
    console.error(error);
  }
};

export const storeDataToDb = async expenses => {
  expenses.map(async expense => {
    const realm = await Realm.open({
      schema: [ExpenseSchema, AmountSchema, UserSchema]
    });
    realm.write(() => {
      realm.create("expense", expense, true);
    });
  });
};

export const getDataFromDB = async model => {
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

export const updateCommentToDb = async expense => {
  try {
    const realm = await Realm.open({
      schema: [ExpenseSchema, UserSchema, AmountSchema]
    });
    realm.write(() => {
      realm.create("expense", expense, true);
    });
  } catch (err) {
    console.log(err);
  }
};

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
