import { combineReducers } from "redux";
import { createSlice } from "redux-starter-kit";
import { fetchExpensesApi } from "../../api/expenses";
import { useDispatch, useSelector } from "react-redux";

export const modal = createSlice({
  slice: "modal",
  initialState: {
    visible: false,
    selectedExpenseId: null
  },
  reducers: {
    showModal: (state, { payload }) =>
      (state = {
        visible: true,
        selectedExpenseId: payload
      }),
    hideModal: (state, { payload }) => (state = { ...state.initialState })
  }
});

export const fromModal = state => state.expenses.modal.visible;

export const model = createSlice({
  slice: "model",
  initialState: [],
  reducers: {
    fetchSuccess: (state, { payload }) => (state = payload),
    updateExpense: (state, { payload }) => (
      console.log("payload", payload),
      [
        ...state.slice(0, payload.index),
        payload,
        ...state.slice(payload.index + 1)
      ]
    )
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
