export const AmountSchema = {
  name: "amount",
  properties: {
    value: "string",
    currency: "string"
  }
};

export const UserSchema = {
  name: "user",
  primaryKey: "email",
  properties: {
    first: "string",
    last: "string",
    email: "string"
  }
};
export const ExpenseSchema = {
  name: "expense",
  primaryKey: "id",
  properties: {
    id: "string",
    amount: "amount?",
    date: "string",
    merchant: "string",
    user: "user?",
    receipt: "data?",
    index: "int",
    category: "string",
    comment: "string"
  }
};
