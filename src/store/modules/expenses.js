import { combineReducers } from "redux";
import { createSlice } from "redux-starter-kit";
import { fetchExpensesApi } from "../../api/expenses";
import { useDispatch, useSelector } from "react-redux";
/*
export const modal = createSlice({
  slice: "modal",
  initialState: {
      selectedExpenseId: null
  },
  reducers:{
    showModal: (state, { payload }) => (
      state = payload
    ), 
    hideModal: (state, {payload}) => (state = {...state.initialState})     
  }
});*/

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

export const model = createSlice({
  slice: "model",
  initialState: [],
  reducers: {
    fetchSuccess: (state, { payload }) => (state = payload),
    updateExpense: (state, { payload }) => [
      ...state.slice(0, payload.index),
      payload,
      ...state.slice(payload.index + 1)
    ]
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
    // Fetch list of expenses
    const response = await fetchExpensesApi();

    // Dispatch action to write response to store
    dispatch(model.actions.fetchSuccess(response.data.expenses));
  } catch (err) {
    console.error(err);
  } finally {
    dispatch(utils.actions.toggleLoading(false));
  }
};

export const hideCommentModal = () => dispatch => {
  console.log("hide comment modal");
  dispatch(modal.actions.hideModal());
};

export default combineReducers({
  modal: modal.reducer,
  model: model.reducer,
  utils: utils.reducer
});
