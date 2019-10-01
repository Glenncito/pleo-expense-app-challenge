import axios from "axios";
import { BASE_URL } from "../lib/constants";

export const fetchExpensesApi = async () => {
  const response = await axios(
    `http://${BASE_URL}:3000/expenses?limit=10&offset=0`
  );

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
