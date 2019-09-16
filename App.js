import { View, ScrollView, FlatList } from "react-native";
import ExpenseCard from "components/ExpenseCard/ExpenseCard";
import React from "react";
import { NativeModules } from "react-native";

export default function App() {
  const CameraApplication = NativeModules.KotlinCameraModule;

  return (
    <View>
      <ScrollView>
        <FlatList
          data={expenseItems}
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
          keyExtractor={item => item.user.email}
        />
      </ScrollView>
    </View>
  );
}

const expenseItems = [
  {
    amount: {
      value: "111.11",
      currency: "ZAR"
    },
    date: "2018-09-10T02:11:29.184Z",
    merchant: "KAGE",
    user: {
      first: "Vickie",
      last: "Lee",
      email: "vickie.lee@pleo.io"
    }
  },
  {
    amount: {
      value: "222.11",
      currency: "EUR"
    },
    date: "2015-03-10T02:11:29.184Z",
    merchant: "BURGER KING",
    user: {
      first: "Glenn",
      last: "Stein",
      email: "Glenn@pleo.io"
    }
  },
  {
    amount: {
      value: "11.11",
      currency: "USD"
    },
    date: "2018-01-01T02:11:29.184Z",
    merchant: "British Airways",
    user: {
      first: "Peter",
      last: "Scott",
      email: "Peter@pleo.io"
    }
  },
  {
    amount: {
      value: "11.11",
      currency: "USD"
    },
    date: "2018-01-01T02:11:29.184Z",
    merchant: "British Airways",
    user: {
      first: "Peter",
      last: "Scott",
      email: "Ptteter@pleo.io"
    }
  },
  {
    amount: {
      value: "11.11",
      currency: "USD"
    },
    date: "2018-01-01T02:11:29.184Z",
    merchant: "British Airways",
    user: {
      first: "Peter",
      last: "Scott",
      email: "Petter@pleo.io"
    }
  }
];
