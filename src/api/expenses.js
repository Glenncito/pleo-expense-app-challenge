import axios from "axios";
import { BASE_URL } from "../lib/constants";

export const fetchExpensesApi = async () => {
  const response = await axios(
    `http://${BASE_URL}:3000/expenses?limit=200&offset=0`
  );

  return response;
};

export const fetchSingleExpense = async expenseId => {
  const response = await axios(`http://${BASE_URL}:3000/expenses/${expenseId}`);
  return response;
};

export const uploadReceipt = async (expenseId, imageData) => {
  let formData = new FormData();
  formData.append("receipt", {
    uri: "file://" + imageData,
    name: expenseId,
    type: "image/jpg"
  });

  axios.post(
    `http://${BASE_URL}:3000/expenses/${expenseId}/receipts`,
    formData,
    {
      headers: {
        "Content-Type": "multipart/form-data"
      }
    }
  );
};

export const updateCommentApi = async updatedExpense => {
  axios
    .post(`http://${BASE_URL}:3000/expenses/${updatedExpense.id}`, {
      comment: updatedExpense.comment
    })
    .then(
      response => {
        console.log(response);
      },
      error => {
        console.log(error);
      }
    );
};
