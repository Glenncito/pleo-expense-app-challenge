import React, { useEffect } from "react";
import {
  FlatList,
  ScrollView,
  View,
  Text,
  Picker,
  ActivityIndicator
} from "react-native";
import ExpenseCard from "../components/expenseCard/ExpenseCard";
import { useDispatch, useSelector } from "react-redux";
import { format } from "date-fns";
import { SearchInputContainer, SearchInput, NavBar } from "./styles";
import Icon from "react-native-vector-icons/Feather";

import {
  initialExpensesFetch,
  fromExpenses,
  fromModal,
  modal,
  fromLocale,
  fromUtils,
  locale
} from "../store/modules/expenses";
import {
  initReceiptMenu,
  initLocalization,
  onSearchTermUpdated
} from "../lib/helpers";
import { eng, esp, fra, por, localeMap } from "lib/constants";
import i18n from "i18n-js";

function Expenses() {
  const [searchTerm, setSearchTerm] = React.useState("");
  const [currentlyDisplayed, setCurrentlyDisplayed] = React.useState([]);
  const [localeConstant, setLocaleConstant] = React.useState("eng");

  const dispatch = useDispatch();
  const showModal = expenseId => dispatch(modal.actions.showModal(expenseId));
  const modalState = useSelector(fromModal);
  const expensesState = useSelector(fromExpenses);
  const loadingState = useSelector(fromUtils);

  useEffect(() => {
    dispatch(initialExpensesFetch());
  }, [dispatch]);

  useEffect(() => {
    setCurrentlyDisplayed(expensesState);
  }, [expensesState]);

  const currentLocale = useSelector(fromLocale);
  i18n.fallbacks = true;
  i18n.translations = { eng, esp, fra, por };
  i18n.locale = localeConstant;
  useEffect(() => {
    setLocaleConstant(currentLocale.selectedLocaleConstant);
    i18n.locale = localeConstant;
  }, [currentLocale]);

  const searchTermUpdated = term => {
    const searchResult = onSearchTermUpdated(term, expensesState);
    setCurrentlyDisplayed(searchResult);
    setSearchTerm(term);
  };

  const changeLocale = localeValue =>
    dispatch(
      locale.actions.updateLocale({
        selectedLocaleConstant: localeValue,
        selectedDateLocale: `${localeMap[localeValue]}`
      })
    );

  return (
    <View>
      <NavBar>
        <Picker
          selectedValue={currentLocale.selectedLocaleConstant}
          style={{ height: 150, width: 150, marginTop: 20 }}
          onValueChange={(itemValue, itemIndex) => changeLocale(itemValue)}
        >
          <Picker.Item label="English" value="eng" />
          <Picker.Item label="Español" value="esp" />
          <Picker.Item label="Français" value="fra" />
          <Picker.Item label="Portugués" value="por" />
        </Picker>
      </NavBar>
      <SearchInputContainer>
        <Icon name="search" size={24} color="red" style={{ marginLeft: 15 }} />
        <SearchInput
          multiline={false}
          placeholder="Search"
          placeholderTextColor="#abbabb"
          value={searchTerm}
          onChangeText={text => searchTermUpdated(text)}
        />
      </SearchInputContainer>
      <ScrollView>
        {loadingState ? (
          <ActivityIndicator size="large" color="#0000ff" />
        ) : (
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
                visible={
                  item.id === modalState.selectedExpenseId ? true : false
                }
              />
            )}
            keyExtractor={item => item.id}
          />
        )}
      </ScrollView>
    </View>
  );
}
export default Expenses;
