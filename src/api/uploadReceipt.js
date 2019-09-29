import axios from "axios";

export const uploadReceipt = async (expenseId, imageData) => {
  let formData = new FormData();
  formData.append("files", imageData);

  axios.post(`/expenses/${expenseId}/receipts`, formData, {
    headers: {
      "Content-Type": "multipart/form-data"
    }
  });
};
