import styled from "styled-components";

export const CommentInputContainer = styled.View`
  flex-direction: column;
  align-items: stretch;
  margin-right: 32;
  margin-left: 8;
  margin-bottom: 8;
`;

export const ButtonContainer = styled.View`
  flex-direction: row;
  justify-content: center;
`;

export const AcceptButton = styled.TouchableOpacity`
  border-radius: 16;
  justify-content: center;
  align-items: center;
  background-color: #52e588;
  margin-right: 8;
  height: 32;
  width: 35%;
`;

export const CancelButton = styled.TouchableOpacity`
  border-radius: 16;
  justify-content: center;
  align-items: center;
  background-color: white;
  border-color: grey;
  border-width: 1;
  height: 32;
  width: 35%;
`;

export const AcceptButtonText = styled.Text`
  color: white;
  font-size: 14;
`;

export const CancelButtonText = styled.Text`
  color: grey;
  font-size: 14;
`;

export const CommentInput = styled.TextInput`
  flex: 1;
  height: 30;
  width: 100%;
  font-size: 14;
  color: rgba(0, 0, 0, 1);
  padding-left: 10;
  min-height: 3%;
  border-color: grey;
  border-radius: 24;
  border-width: 1;
  margin-bottom: 8;
`;
