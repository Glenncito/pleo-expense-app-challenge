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
  background: rgba(0, 0, 0, 0.2);
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  padding: 8px;
`;

export const Date = styled.Text``;

export const Category = styled.Text``;

export const Amount = styled.Text``;

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

export const Reciept = styled.View`
  flex: 1;
`;

export const BreakRow = styled.View`
  height: 8;
`;

export const AddCommentButton = styled.TouchableOpacity`
  border-radius: 16;
`;

export const AddReceiptButton = styled.TouchableOpacity`
  border-radius: 10;
  height: 48;
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
