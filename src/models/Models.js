


export const AmountSchema = {
  name: 'Amount',
  properties:{
    value: 'String',
    currency: 'String',
  }
};

export const UserSchema = {
  name: 'User',
  properties: {
    first: 'String',
    last: 'String',
    email: 'String',
  }
};
export const EpxenseSchema = {
  name: 'Expense',
  primaryKey: 'id',
  properties: {
    id: 'int'
    amount: 'Amount',
    date: 'date',
    merchant: 'String',
    user: 'User',
  }
};