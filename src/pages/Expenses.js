import React, { useState, useEffect } from "react";
import { FlatList, ScrollView, View, TextInput } from "react-native";
import ExpenseCard from "components/ExpenseCard/ExpenseCard";
import { useDispatch, useSelector } from "react-redux";

import {
  fetchExpenses,
  fromExpenses,
  fromModal,
  modal
} from "../store/modules/expenses";
import { initReceiptMenu } from "../lib/helpers";
import AddCommentModal from "../components/Modals/AddCommentModal";

function Expenses() {
  const [searchTerm, setSearchTerm] = React.useState("");
  const [currentlyDisplayed, setCurrentlyDisplayed] = React.useState([]);

  const dispatch = useDispatch();
  const showModal = expenseId => dispatch(modal.actions.showModal(expenseId));
  const modalState = useSelector(fromModal);
  const expensesState = useSelector(fromExpenses);

  useEffect(() => {
    dispatch(fetchExpenses());
  }, [dispatch]);

  useEffect(() => {
    setCurrentlyDisplayed(expensesState); //make more
  }, [expensesState]);

  const onSearchTermUpdated = term => {
    const userFilter = expense => {
      return Object.values(expense.user)
        .toString()
        .toLowerCase()
        .includes(term.toLowerCase());
    };
    const amountFilter = expense => {
      return Object.values(expense.amount)
        .toString()
        .toLowerCase()
        .includes(term.toLowerCase());
    };
    const merchantFilter = expense => {
      return expense.merchant.toLowerCase().includes(term.toLowerCase());
    };
    const filteredResults = expensesState.filter(
      expense =>
        merchantFilter(expense) || userFilter(expense) || amountFilter(expense)
    );
    setCurrentlyDisplayed(filteredResults);
    setSearchTerm(term);
  };

  return (
    <View>
      <TextInput
        style={{ height: 100, borderColor: "gray", borderWidth: 1 }}
        onChangeText={text => onSearchTermUpdated(text)}
        value={searchTerm}
      />
      <ScrollView>
        <FlatList
          data={currentlyDisplayed}
          extraData={modalState.selectedExpenseId}
          showsVerticalScrollIndicator={false}
          renderItem={({ item }) => (
            <ExpenseCard
              addComment={() => showModal(item.id)}
              comment={item.comment !== "" ? item.comment : "no comment"}
              date={item.date}
              category={item.category}
              amount={item.amount.currency + item.amount.value}
              merchant={item.merchant}
              user={
                item.user.first + " " + item.user.last + "\n" + item.user.email
              }
              receiptMenu={() => initReceiptMenu(item.id)}
              visible={item.id === modalState.selectedExpenseId ? true : false}
            />
          )}
          keyExtractor={item => item.id}
        />
      </ScrollView>
    </View>
  );
}
export default Expenses;
