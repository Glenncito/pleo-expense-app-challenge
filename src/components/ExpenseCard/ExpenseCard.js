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
  ShadowWrapper,
  shadow,
  BreakRow,
  PrimaryButtonText,
  AddCommentButton,
  AddReceiptButton
} from "./styles";
import AddCommentModal from "../Modals/AddCommentModal";
import { eng, esp } from "../../lib/constants";
import { useSelector } from "react-redux";
import { fromLocale } from "../../store/modules/expenses";
import i18n from "i18n-js";
import Icon from "react-native-vector-icons/Feather";

function ExpenseCard(props) {
  const infoIconSize = 20;
  const infoIconMarginRight = 6;
  const currentLocale = useSelector(fromLocale);
  i18n.fallbacks = true;
  i18n.translations = { eng, esp };
  i18n.locale = currentLocale;

  return (
    <Wrapper>
      <Header>
        <Date>{props.date}</Date>
        <Category>{props.category}</Category>
        <Amount>{props.amount}</Amount>
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
        <Reciept>
          <AddReceiptButton onPress={props.receiptMenu}>
            <Icon name={"plus"} size={16} color="white" style={{ margin: 1 }} />
            <Text style={{ color: "white", fontSize: 10 }}>ADD</Text>
            <Text style={{ color: "white", fontSize: 10 }}>RECEIPT</Text>
          </AddReceiptButton>
        </Reciept>
      </Body>
      <View>{props.visible ? <AddCommentModal /> : null}</View>
    </Wrapper>
  );
}

export default ExpenseCard;
