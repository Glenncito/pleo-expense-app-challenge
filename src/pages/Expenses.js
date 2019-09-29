import React, { useState, useEffect } from "react";
import { FlatList, ScrollView, View } from "react-native";
import ExpenseCard from "components/ExpenseCard/ExpenseCard";
import { useDispatch, useSelector } from "react-redux";
import { fetchExpenses, fromExpenses } from "store/modules/expenses";

function Expenses() {
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(fetchExpenses());
  }, [dispatch]);

  const expensesState = useSelector(fromExpenses);

  return (
    <View>
      <ScrollView>
        <FlatList
          data={expensesState}
          showsVerticalScrollIndicator={false}
          renderItem={({ item }) => (
            <ExpenseCard
              date={item.date}
              category={item.category}
              amount={item.amount.currency + item.amount.value}
              merchant={item.merchant}
              user={
                item.user.first + " " + item.user.last + "\n" + item.user.email
              }
            />
          )}
          keyExtractor={item => item.id}
        />
      </ScrollView>
    </View>
  );
}

export default Expenses;
