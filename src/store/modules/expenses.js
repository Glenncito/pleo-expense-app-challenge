import { combineReducers } from "redux";
import { createSlice } from "redux-starter-kit";
import { fetchExpensesApi, updateComment } from "../../api/expenses";
import { enGB } from "date-fns/locale";

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
    loading: false
  },
  reducers: {
    toggleLoading(state, { payload }) {
      return { loading: payload };
    }
  }
});
export const fromUtils = state => state.expenses.utils.loading;
export const fromExpenses = state => state.expenses.model;

export const fetchExpenses = () => async dispatch => {
  dispatch(utils.actions.toggleLoading(true));
  try {
    const response = await fetchExpensesApi();
    dispatch(model.actions.fetchSuccess(response.data.expenses));
  } catch (err) {
    console.log("ERROR", err);
  } finally {
    dispatch(utils.actions.toggleLoading(false));
  }
};

export const addComment = updatedExpense => async dispatch => {
  try {
    updateComment(updatedExpense);
    dispatch(model.actions.updateExpense(updatedExpense));
  } catch (err) {
    console.error(err);
  } finally {
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
