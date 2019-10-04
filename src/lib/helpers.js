import { uploadReceipt } from "../api/expenses";
import { NativeModules } from "react-native";
import React, { useState, useEffect } from "react";
import { eng, esp, fra, por } from "./constants";
import { fromLocale, fromExpenses } from "../store/modules/expenses";
import { useSelector, useDispatch } from "react-redux";
import { ExpenseSchema, UserSchema, AmountSchema } from "./schema";
import i18n from "i18n-js";

const CameraApplication = NativeModules.NativeCameraModule;
const Realm = require("realm");
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
        if (
          realm.objects("expense").filtered(`id ="${expense.id}"`)[0] === null
        ) {
          const expenseItem = realm.create("expense", expense);
          console.log("itemmm", expenseItem);
        }
      });
    });
  });
};
/*
export function getLocalizedString(value) {
  const currentLocale = useSelector(fromLocale);
  useEffect(() => {
    i18n.locale = currentLocale;
  }, [currentLocale]);
  return i18n.t(value);
}

export function changeLocalization(locale) {
  i18n.locale = locale;
  const dispatch = useDispatch();
  dispatch(locale.actions.updateLocal(locale));
}

export function getLocalizedDateString() {
  const currentLocale = useSelector(fromLocale);
  const [dateLocale, setDateLocale] = React.useState(en);
  useEffect(() => {
    if (currentLocale === "eng") {
      setDateLocale(en);
    } else if (currentLocale === "esp") {
      setDateLocale(es);
    } else if (currentLocale === "fra") {
      setDateLocale(fr);
    } else if (currentLocale === "por") {
      setDateLocale(ptBR);
    }
  }, [currentLocale]);

  return dateLocale;
}*/

export function initLocalization() {
  const currentLocale = useSelector(fromLocale);
  i18n.fallbacks = true;
  i18n.translations = { eng, esp, fra, por };
  i18n.locale = currentLocale;
}
