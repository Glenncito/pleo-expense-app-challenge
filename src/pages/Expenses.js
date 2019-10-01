import React, { useState, useEffect } from "react";
import { FlatList, ScrollView, View } from "react-native";
import ExpenseCard from "components/ExpenseCard/ExpenseCard";
import { useDispatch, useSelector } from "react-redux";
import {
  fetchExpenses,
  fromExpenses,
  fromModal,
  showCommentModal,
  hideCommentModal,
  modal
} from "../store/modules/expenses";
import { initReceiptMenu } from "../lib/helpers";
import AddCommentModal from "../components/Modals/AddCommentModal";

function Expenses() {
  const dispatch = useDispatch();
  const showModal = expenseId => dispatch(modal.actions.showModal(expenseId));

  useEffect(() => {
    dispatch(fetchExpenses());
  }, [dispatch]);

  const modalState = useSelector(fromModal);
  const expensesState = useSelector(fromExpenses);

  return (
    <View>
      <ScrollView>
        <FlatList
          data={expensesState}
          extraData={modalState.selectedExpenseId}
          showsVerticalScrollIndicator={false}
          renderItem={({ item }) => (
            <ExpenseCard
              addComment={() => showModal(item.id)}
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
