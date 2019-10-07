import { combineReducers } from "redux";
import { createSlice } from "redux-starter-kit";
import { fetchExpensesApi, updateComment } from "../../api/expenses";
import { storeDataOffline, getDataFromnDB } from "../../lib/helpers";
import { es, enGB, fr, ptBR } from "date-fns/locale";

const localeInitialState = {
  selectedLocaleConstant: "eng",
  selectedDateLocale: `${enGB}`
};

export const locale = createSlice({
  slice: "locale",
  initialState: {
    selectedLocaleConstant: "eng",
    selectedDateLocale: `${enGB}`
  },
  reducers: {
    updateLocale: (state, { payload }) => {
      const { selectedLocaleConstant, selectedDateLocale } = payload;

      (state.selectedLocaleConstant = selectedLocaleConstant),
        (state.selectedDateLocale = `${selectedDateLocale}`);
    }
  }
});

export const fromLocale = state => state.expenses.locale;

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

export const fromModal = state => state.expenses.modal;

const modelInitialState = [];

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
    loading: false,
    hasFetched: false
  },
  reducers: {
    toggleLoading: (state, { payload }) => (state.loading = payload)
  }
});

export const fromExpenses = state => state.expenses.model;

export const fetchExpenses = () => async dispatch => {
  utils.actions.toggleLoading(true);
  try {
    const response = await fetchExpensesApi();
    dispatch(model.actions.fetchSuccess(response.data.expenses));
    storeDataOffline(response.data.expenses);
  } catch (err) {
    console.log("ERROR", err);
    //dispatch(fetchFromDatabase());
  } finally {
    dispatch(utils.actions.toggleLoading(false));
  }
};

const fetchFromDatabase = () => async dispatch => {
  const expenseArray = () => getDataFromnDB();
  console.log("expenseArray", expenseArray());
  if (expenseArray !== null) {
    dispatch(model.actions.fetchSuccess(expenseArray()));
  } else {
    dispatch(model.actions.fetchFaliure());
  }
  dispatch(utils.actions.toggleLoading(false));
};

export const addComment = updatedExpense => async dispatch => {
  console.log("add add comment, $updatedExpense");
  try {
    console.log("add add comment, $updatedExpense");
    updateComment(updatedExpense);
    dispatch(model.actions.updateExpense(updatedExpense));
  } catch (err) {
    console.error(err);
  } finally {
  }
};

export const hideCommentModal = () => dispatch => {
  console.log("hide comment modal");
  dispatch(modal.actions.hideModal());
};

export default combineReducers({
  modal: modal.reducer,
  model: model.reducer,
  utils: utils.reducer,
  locale: locale.reducer
});
