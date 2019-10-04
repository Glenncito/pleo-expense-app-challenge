import React from "react";
import { TextInput, Button, View, Fragment, Text } from "react-native";
import {
  Wrapper,
  Header,
  Body,
  Date,
  Amount,
  InfoRow,
  InfoText,
  Category,
  ExpenseInfo,
  Reciept,
  BreakRow,
  AddCommentButton,
  AddReceiptButton,
  PrimaryText,
  SecondaryText
} from "./styles";
import AddCommentModal from "../Modals/AddCommentModal";
import Icon from "react-native-vector-icons/Feather";
import { getLocalizedString } from "../../lib/helpers";
import i18n from "i18n-js";

function ExpenseCard(props) {
  const infoIconSize = 20;
  const infoIconMarginRight = 6;

  return (
    <Wrapper>
      <Header>
        <Date>
          <View style={{ paddingRight: 4 }}>
            <PrimaryText>{props.dateDay}</PrimaryText>
          </View>
          <View style={{ flexDirection: "column" }}>
            <SecondaryText>{props.dateMonthYear}</SecondaryText>
            <SecondaryText>{props.dateWeekday}</SecondaryText>
          </View>
        </Date>
        <Category>{props.category}</Category>
        <Amount>
          <View style={{ paddingRight: 2, justifyContent: "flex-end" }}>
            <SecondaryText>{props.currency}</SecondaryText>
          </View>
          <View style={{ flexDirection: "column" }}>
            <PrimaryText>{props.amount}</PrimaryText>
          </View>
        </Amount>
      </Header>
      <Body>
        <ExpenseInfo>
          <InfoRow>
            <Icon
              name="shopping-cart"
              size={infoIconSize}
              color="grey"
              style={{ marginRight: infoIconMarginRight }}
            />
            <InfoText>{props.merchant}</InfoText>
          </InfoRow>
          <BreakRow />
          <InfoRow>
            <Icon
              name="user"
              size={infoIconSize}
              color="grey"
              style={{ marginRight: infoIconMarginRight }}
            />
            <InfoText>{props.userName}</InfoText>
          </InfoRow>
          <InfoRow>
            <Icon
              name="mail"
              size={infoIconSize}
              color="grey"
              style={{ marginRight: infoIconMarginRight }}
            />
            <InfoText>{props.userMail}</InfoText>
          </InfoRow>
          <BreakRow />
          <View>
            {props.visible ? null : (
              <InfoRow>
                <Icon
                  name="message-square"
                  size={infoIconSize}
                  color="grey"
                  style={{ marginRight: infoIconMarginRight }}
                />
                <InfoText style={{ fontStyle: "italic" }}>
                  {props.comment}
                </InfoText>
                <AddCommentButton onPress={props.addComment}>
                  <Icon
                    name={props.commentExists ? "edit-2" : "plus-circle"}
                    size={infoIconSize + 2}
                    color="#438EE4"
                    style={{ margin: 8 }}
                  />
                </AddCommentButton>
              </InfoRow>
            )}
          </View>
        </ExpenseInfo>
      </Body>
      <View>{props.visible ? <AddCommentModal /> : null}</View>

      <AddReceiptButton onPress={props.receiptMenu}>
        <Icon
          name={"plus"}
          size={22}
          color="white"
          style={{ margin: 1, paddingRight: 2 }}
        />
        <View
          style={{
            alignContent: "center",
            justifyContent: "center",
            marginRight: 4
          }}
        >
          <Text style={{ color: "white", fontSize: 14 }}>
            {i18n.t("addReceipt")}
          </Text>
        </View>
      </AddReceiptButton>
    </Wrapper>
  );
}

export default ExpenseCard;
