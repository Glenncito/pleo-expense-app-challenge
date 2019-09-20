import { View, ScrollView, FlatList, Button } from "react-native";
import ExpenseCard from "components/ExpenseCard/ExpenseCard";
import React from "react";
import { NativeModules } from "react-native";
//import {AmountSchema, UserSchema, ExpenseSchema} from "models"; //make it target the alias

export default function App() {
  const CameraApplication = NativeModules.KotlinCameraModule;

  const Realm = require("realm");

  const AmountSchema = {
    name: "Amount",
    properties: {
      value: "string",
      currency: "string"
    }
  };

  const UserSchema = {
    name: "User",
    properties: {
      first: "string",
      last: "string",
      email: "string"
    }
  };
  const ExpenseSchema = {
    name: "Expense",
    properties: {
      amount: "Amount?",
      user: "User?",
      date: "date",
      merchant: "string",
      receipt: "data?"
    }
  };

  const addRealmDummyData = () => {
    Realm.open({
      schema: [ExpenseSchema, UserSchema, AmountSchema]
    }).then(realm => {
      realm.write(() => {
        realm.create("Expense", {
          id: 3,
          amount: { value: "113.5", currency: "ZAR" },
          date: "2018-01-01T02:11:29.184Z",
          merchant: "KAGE",
          user: { first: "Glenn", last: "Steing", email: "Glenn@pleo.com" }
        });
        realm.create("Expense", {
          id: 4,
          amount: { value: "513.5", currency: "USD" },
          date: "2018-05-05T02:11:29.184Z",
          merchant: "McD",
          user: { first: "Peter", last: "Scott", email: "Peter@pleo.com" }
        });
        // expense[0].user.push({first: 'Peter', last: 'Scott', email:'Peter@pleo.com'});
        //expense[0].amount.push({first: 'Peter', last: 'Scott', email:'Peter@pleo.com'});

        //const example = realm.objects('Expense')
        //console.log(example)
        //example.name = "Zoe"
        // console.log(example)
      });
    });
  };

  return (
    <View>
      <Button title="Press me" onPress={() => addRealmDummyData()} />
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
