import React from "react";
import { TextInput, Button, View } from "react-native";
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
  Reciept
} from "./styles";
import AddCommentModal from "../Modals/AddCommentModal";
import { en, es } from "../../lib/constants";
import i18n from "i18n-js";

const ExpenseCard = props => (
  <Wrapper>
    <Header>
      <Date>{props.date}</Date>
      <Category>{props.category}</Category>
      <Amount>{props.amount}</Amount>
    </Header>
    <Body>
      <ExpenseInfo>
        <InfoRow>
          <InfoText>{props.merchant}</InfoText>
        </InfoRow>
        <InfoRow>
          <InfoText>{props.user}</InfoText>
        </InfoRow>
        <InfoRow>
          <InfoText>{props.comment}</InfoText>
        </InfoRow>
        <Button title={i18n.t("addComment")} onPress={props.addComment} />
      </ExpenseInfo>
      <Reciept>
        <Button title="Press me" onPress={props.receiptMenu} />
      </Reciept>
    </Body>
    <View>{props.visible ? <AddCommentModal /> : null}</View>
  </Wrapper>
);

export default ExpenseCard;
