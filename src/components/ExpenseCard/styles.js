import styled from "styled-components";
import { grey } from "ansi-colors";

export const ShadowWrapper = styled.View`
  margin-left: 24px;
  margin-right: 24px;
  margin-top: 12px;
  border-radius: 20;
`;
export const Wrapper = styled.View`
  border: 1px rgba(0, 0, 0, 0.2);
  background: white;
  margin-left: 24px;
  margin-right: 24px;
  margin-top: 12px;
  border-radius: 16;

  box-shadow: 2px 2px 2px black;
  overflow: hidden;
`;

export const Header = styled.View`
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  padding: 8px;
  border-bottom-width: 1;
  border-color: rgba(0, 0, 0, 0.1);
`;

export const Date = styled.View`
  flex-direction: row;
`;

export const PrimaryText = styled.Text`
  font-weight: bold;
  font-size: 28;
  font-family: Helvetica;
`;

export const SecondaryText = styled.Text`
  font-size: 14;
  font-family: "Roboto";
`;

export const Category = styled.Text``;

export const Amount = styled.View`
  flex-direction: row;
`;

export const Body = styled.View`
  padding: 8px;
  flex-direction: row;
`;

export const ExpenseInfo = styled.View`
  flex: 3;
`;
export const InfoRow = styled.View`
  width: 100%;
  flex-direction: row;
  align-items: center;
  justify-content: flex-start;
`;

export const InfoText = styled.Text``;

export const BreakRow = styled.View`
  height: 8;
`;

export const AddCommentButton = styled.TouchableOpacity`
  border-radius: 16;
`;
export const Reciept = styled.View`
  flex: 1;
  align-items: center;
`;

export const AddReceiptButton = styled.TouchableOpacity`
  width: 100%;
  height: 36;
  background-color: #fd3366;
  flex-direction: row;
  align-items: center;
  justify-content: center;
`;

export const AddCommentText = styled.Text`
  color: white;
  margin-left: 9;
  height: 16;
`;

export const shadow = {
  padding: 20,
  backgroundColor: "#d9d9d9",
  shadowColor: "#000000",
  shadowOpacity: 0.8,
  shadowRadius: 10,
  shadowOffset: {
    height: 1,
    width: 1
  }
};
