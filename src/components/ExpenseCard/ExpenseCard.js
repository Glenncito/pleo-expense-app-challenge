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
import { NativeModules } from "react-native";

const CameraApplication = NativeModules.NativeCameraModule;
const fetchData = async () => {
  CameraApplication.initReceiptCapture("5b996064dfd5b783915112f5")
    .then(message => {
      console.log(message);
    })
    .catch(error => {
      console.log(error);
    });
};

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
        <Button title="Press me" onPress={() => fetchData()} />
      </Reciept>
    </Body>
  </Wrapper>
);

export default ExpenseCard;
