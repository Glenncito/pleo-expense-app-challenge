import React, { useState, useEffect } from "react";
import { FlatList, ScrollView, View, TextInput, Text } from "react-native";
import ExpenseCard from "components/ExpenseCard/ExpenseCard";
import { useDispatch, useSelector } from "react-redux";
import { format } from "date-fns";
import { SearchInputContainer, SearchInput } from "./styles";
import Icon from "react-native-vector-icons/Feather";

import {
  fetchExpenses,
  fromExpenses,
  fromModal,
  modal,
  fromLocale
} from "../store/modules/expenses";
import {
  initReceiptMenu,
  getLocalizedDateString,
  getLocalizedString,
  initLocalization
} from "../lib/helpers";
import AddCommentModal from "../components/Modals/AddCommentModal";
import * as Localization from "expo-localization";
import { eng, esp, fra, por, localeMap } from "lib/constants";
import { es, en, fr, ptBR } from "date-fns/locale";
import i18n from "i18n-js";

function Expenses() {
  initLocalization();
  const [searchTerm, setSearchTerm] = React.useState("");
  const [currentlyDisplayed, setCurrentlyDisplayed] = React.useState([]);
  const [localeConstant, setLocaleConstant] = React.useState();

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

  const currentLocale = useSelector(fromLocale);
  i18n.fallbacks = true;
  i18n.translations = { eng, esp, fra, por };
  i18n.locale = localeConstant;
  useEffect(() => {
    setLocaleConstant(currentLocale.selectedLocaleConstant);
    i18n.locale = localeConstant;
  }, [currentLocale]);

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
      <SearchInputContainer>
        <Icon name="search" size={24} color="red" style={{ marginLeft: 15 }} />
        <SearchInput
          multiline={false}
          placeholder="Search"
          placeholderTextColor="#abbabb"
          value={searchTerm}
          onChangeText={text => onSearchTermUpdated(text)}
        />
      </SearchInputContainer>
      <ScrollView>
        <FlatList
          data={currentlyDisplayed}
          extraData={modalState.selectedExpenseId}
          showsVerticalScrollIndicator={false}
          renderItem={({ item }) => (
            <ExpenseCard
              addComment={() => showModal(item.id)}
              comment={
                item.comment !== "" ? (
                  item.comment
                ) : (
                  <Text style={{ color: "#dbd9d9" }}>
                    {i18n.t("noCommentAdded")}
                  </Text>
                )
              }
              commentExists={item.comment !== "" ? true : false}
              dateDay={format(new Date(item.date), "do", {
                locale: localeMap[`${localeConstant}`]
              })}
              dateMonthYear={format(new Date(item.date), `MMM yy`, {
                locale: localeMap[`${localeConstant}`]
              })}
              dateWeekday={format(new Date(item.date), "iii", {
                locale: localeMap[`${localeConstant}`]
              })}
              category={item.category}
              currency={item.amount.currency}
              amount={item.amount.value}
              merchant={item.merchant}
              userName={`${item.user.first} ${item.user.last}`}
              userMail={item.user.email}
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
