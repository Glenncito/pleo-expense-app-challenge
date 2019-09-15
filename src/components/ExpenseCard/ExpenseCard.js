import React from "react";
import { TextInput, Button } from "react-native";
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
        <TextInput
          style={{ height: 40 }}
          multiline={true}
          placeholder="add a comment?"
          placeholderTextColor="#abbabb"
          onChangeText={value => console.log(value)}
        />
      </ExpenseInfo>
      <Reciept>
        <Button title="Press me" onPress={() => console.log("pressed")} />
      </Reciept>
    </Body>
  </Wrapper>
);

export default ExpenseCard;
