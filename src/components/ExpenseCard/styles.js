import styled from "styled-components";

export const Wrapper = styled.View`
  border: 1px solid black;
  margin: 30px; // Remove later
`;

export const Header = styled.View`
  background: rgba(0, 0, 0, 0.2);
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  padding: 8px;
`;

export const Date = styled.Text``;

export const Price = styled.Text``;

export const Body = styled.View`
  padding: 8px;
`;

export const InfoRow = styled.View`
  width: 100%;
  flex-direction: row;
  align-items: center;
  justify-content: flex-start;
`;

export const InfoText = styled.Text``;
