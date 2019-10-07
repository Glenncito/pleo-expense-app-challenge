import { uploadReceipt } from "../api/expenses";
import { NativeModules } from "react-native";
import { eng, esp, fra, por } from "./constants";
import { fromLocale } from "../store/modules/expenses";
import { useSelector } from "react-redux";
import i18n from "i18n-js";

const CameraApplication = NativeModules.NativeCameraModule;
export const initReceiptMenu = async expenseId => {
  try {
    const message = await CameraApplication.initReceiptCapture(expenseId);
    uploadReceipt(expenseId, message);
  } catch (error) {
    console.error(error);
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
