import React from "react";
import { View } from "react-native";
import ExpenseCard from "components/ExpenseCard/ExpenseCard";

export default function App() {
  return (
    <View>
      <ExpenseCard />
      <ExpenseCard />
      <ExpenseCard />
    </View>
  );
}
