import { combineReducers } from "redux";
import { createSlice } from "redux-starter-kit";
import { fetchExpensesApi } from "../../api/expenses";

const data = createSlice({
  slice: "data",
  initialState: [],
  reducers: {
    fetchSuccess: (state, { payload }) => (state = payload)
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

export const fromExpenses = state => state.expenses.data;

export const fetchExpenses = () => async dispatch => {
  utils.actions.toggleLoading(true);

  try {
    // Fetch list of expenses
    const response = await fetchExpensesApi();

    // Dispatch action to write response to store
    dispatch(data.actions.fetchSuccess(response.data.expenses));
  } catch (err) {
    console.error(err);
  } finally {
    dispatch(utils.actions.toggleLoading(false));
  }
};

export default combineReducers({ data: data.reducer, utils: utils.reducer });
