import { combineReducers } from "redux";
import { createSlice } from "redux-starter-kit";
import { fetchExpensesApi, updateCommentApi } from "../../api/expenses";
import {
  getDataFromDB,
  storeDataToDb,
  updateCommentToDb
} from "../../lib/helpers";
import { ToastAndroid } from "react-native";
import i18n from "i18n-js";

export const locale = createSlice({
  slice: "locale",
  initialState: {
    selectedLocaleConstant: "eng"
  },
  reducers: {
    updateLocale(state, { payload }) {
      return {
        selectedLocaleConstant: payload
      };
    }
  }
});

const modalInitialState = {
  selectedExpenseId: null
};

export const modal = createSlice({
  slice: "modal",
  initialState: {
    selectedExpenseId: null
  },
  reducers: {
    showModal(state, { payload }) {
      return { selectedExpenseId: payload };
    },
    hideModal(state) {
      return modalInitialState;
    }
  }
});

export const model = createSlice({
  slice: "model",
  initialState: [],
  reducers: {
    fetchSuccess(state, { payload }) {
      return payload;
    },
    fetchFaliure(state, { payload }) {
      return payload;
    },
    updateExpense(state, { payload }) {
      state[payload.index] = payload;
    }
  }
});

const utils = createSlice({
  slice: "utils",
  initialState: {
    loading: false
  },
  reducers: {
    toggleLoading(state, { payload }) {
      return { loading: payload };
    }
  }
});

export const fromModal = state => state.expenses.modal;
export const fromUtils = state => state.expenses.utils.loading;
export const fromExpenses = state => state.expenses.model;
export const fromLocale = state => state.expenses.locale.selectedLocaleConstant;

export const fetchExpensesFromApi = () => async dispatch => {
  console.log("Fetching expenses");
  dispatch(utils.actions.toggleLoading(true));
  try {
    const response = await fetchExpensesApi();
    dispatch(model.actions.fetchSuccess(response.data.expenses));
    storeDataToDb(response.data.expenses);
    ToastAndroid.show(i18n.t("successfulUpdate"), ToastAndroid.SHORT);
  } catch (err) {
    console.log("ERROR", err);
    ToastAndroid.show(i18n.t("unableToFetch"), ToastAndroid.SHORT);
  } finally {
    dispatch(utils.actions.toggleLoading(false));
  }
};

export const initialExpensesFetch = () => async dispatch => {
  try {
    const expenseArray = await getDataFromDB("expense");
    if (expenseArray.length > 0) {
      dispatch(model.actions.fetchSuccess(expenseArray));
    } else {
      dispatch(model.actions.fetchFaliure());
    }
    dispatch(utils.actions.toggleLoading(false));
    dispatch(fetchExpensesFromApi());
  } catch (err) {
    console.log(err);
    dispatch(model.actions.fetchFaliure());
  }
};

export const addComment = updatedExpense => async dispatch => {
  try {
    await updateCommentApi(updatedExpense);
    updateCommentToDb(updatedExpense);
    dispatch(model.actions.updateExpense(updatedExpense));
  } catch (err) {
    ToastAndroid.show(i18n.t("unsuccessfulUpdate"), ToastAndroid.SHORT);
    console.error(err);
  }
};

export const hideCommentModal = () => dispatch => {
  dispatch(modal.actions.hideModal());
};

export default combineReducers({
  modal: modal.reducer,
  model: model.reducer,
  utils: utils.reducer,
  locale: locale.reducer
});
