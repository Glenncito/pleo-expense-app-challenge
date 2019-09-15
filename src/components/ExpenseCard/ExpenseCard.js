import React from "react";
import {
  Wrapper,
  Header,
  Body,
  Date,
  Price,
  InfoRow,
  InfoText
} from "./styles";

const ExpenseCard = props => (
  <Wrapper>
    <Header>
      <Date>12 Feb</Date>
      <Price>ZAR 19.99</Price>
    </Header>
    <Body>
      <InfoRow>
        <InfoText>Burger King</InfoText>
      </InfoRow>
      <InfoRow>
        <InfoText>Burger King</InfoText>
      </InfoRow>
    </Body>
  </Wrapper>
);

export default ExpenseCard;
