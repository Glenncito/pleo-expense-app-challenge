import axios from "axios";

export const fetchExpensesApi = async () => {
  const response = await axios(
    "http://192.168.0.102:3000/expenses?limit=10&offset=0"
  );

  return response;
};
