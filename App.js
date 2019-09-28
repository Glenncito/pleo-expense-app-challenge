import { View, ScrollView, FlatList, Button } from "react-native";
import ExpenseCard from "components/ExpenseCard/ExpenseCard";
import { NativeModules } from "react-native";
import React, { useState, useEffect } from "react";
import axios from "axios";

//import {AmountSchema, UserSchema, ExpenseSchema} from "models"; //make it target the alias

export default function App() {
  const [data, setData] = useState([]);
  const Realm = require("realm");
  useEffect(() => {
    controller = new AbortController();
    const fetchData = async () => {
      const result = await axios(
        // "https://67f94dae.ngrok.io/expenses?limit=10&offset=0"
        //'http://d909d1a9.ngrok.io/expenses?limit=10&offset=0',
        "http://192.168.0.183:3000/expenses?limit=5&offset=0"
      );
      writeData(result.data.expenses);
    };
    fetchData();
    return () => {
      this.controller.abort();
    };
  }, []);

  const writeData = response => {
    Realm.open({
      schema: [ExpenseSchema, UserSchema, AmountSchema],
      inMemory: true
    }).then(realm => {
      realm.write(() => {
        response.map(expense => {
          const existingExpense = realm.objectForPrimaryKey(
            "expense",
            expense.id
          );
          if (existingExpense != null) {
            realm.delete(existingExpense);
          }
          realm.create("expense", expense);
        });
        const objects = realm.objects("expense");
        const values = Object.values(objects);
        values.map(obj => {
          setData(data => [...data, obj]);
        });
      });
    });
  };

  const showImage = () => {
    Realm.open({
      schema: [ExpenseSchema, UserSchema, AmountSchema]
    }).then(realm => {
      let expense = realm.objects("expense")[0];
      // console.log (expense.merchant);
      var arrayBufferView = new Uint8Array(expense.receipt);
      const blob = new Blob([arrayBufferView], { type: "image/jpeg" });

      console.log(blob);
      var imageBase64 = "data:" + "image/jpeg" + ";base64," + blob;
      console.log("Second: " + imageBase64);
      // return imageBase64;
    });
  };

  const addRealmDummyData = () => {
    Realm.open({
      schema: [ExpenseSchema, UserSchema, AmountSchema]
    }).then(realm => {
      realm.write(() => {
        realm.create("Expense", {
          id: "5b996064dfd5b783915112f5",
          amount: { value: "113.5", currency: "ZAR" },
          date: "2018-01-01T02:11:29.184Z",
          merchant: "KAGE",
          user: { first: "Glenn", last: "Steing", email: "Glenn@pleo.com" }
        });
        realm.create("Expense", {
          id: "5b99606474ab17b7820b3922",
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
      <ScrollView>
        <FlatList
          data={data}
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

const AmountSchema = {
  name: "amount",
  properties: {
    value: "string",
    currency: "string"
  }
};

const UserSchema = {
  name: "user",
  properties: {
    first: "string",
    last: "string",
    email: "string"
  }
};
const ExpenseSchema = {
  name: "expense",
  primaryKey: "id",
  properties: {
    id: "string",
    amount: "amount?",
    category: "string",
    comment: "string",
    user: "user?",
    date: "string",
    merchant: "string",
    receipt: "data?",
    index: "int"
  }
};
