import { combineReducers } from "redux";
import { createSlice } from "redux-starter-kit";
import { fetchExpensesApi, updateComment } from "../../api/expenses";
import { storeDataOffline } from "../../lib/helpers";
import { es, en, fr, ptBR } from "date-fns/locale";

const localeInitialState = {
  selectedLocaleConstant: "esp",
  selectedDateLocale: `${es}`
};

export const locale = createSlice({
  slice: "locale",
  initialState: {
    selectedLocaleConstant: "esp",
    selectedDateLocale: `${es}`
  },
  reducers: {
    updateLocal(state, { payload }) {
      return {
        selectedLocaleConstant: payload.selectedLocaleConstant,
        selectedDateLocale: `${payload.selectedDateLocale}`
      };
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
      // state.selectedExpenseId = payload;
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
    updateExpense(state, { payload }) {
      state[payload.index] = payload;
    }
  }
});

/*
[
      ...state.slice(0, payload.index),
      payload,
      ...state.slice(payload.index + 1)
    ]
*/
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
    // Fetch list of expenses
    const response = await fetchExpensesApi();

    // Dispatch action to write response to store
    dispatch(model.actions.fetchSuccess(response.data.expenses));
    console.log("BIG LIST", response.data.expenses);
    storeDataOffline(response.data.expenses);
  } catch (err) {
    console.error(err);
  } finally {
    dispatch(utils.actions.toggleLoading(false));
  }
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
