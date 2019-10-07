import { modal, addComment } from "../../store/modules/expenses";
import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import styled from "styled-components";
import {
  CommentInputContainer,
  CommentInput,
  ButtonContainer,
  AcceptButton,
  AcceptButtonText,
  CancelButton,
  CancelButtonText
} from "./styles";
import i18n from "i18n-js";

export function AddComment() {
  const focus = () => {
    this.input.focus();
  };

  useEffect(() => {
    focus();
  }, [expense]);

  const [value, onChangeText] = React.useState("");

  const dispatch = useDispatch();
  const expenseId = useSelector(
    state => state.expenses.modal.selectedExpenseId
  );
  const expense = useSelector(state =>
    state.expenses.model.find(expense => expense.id === expenseId)
  );
  const hideModal = () => dispatch(modal.actions.hideModal());

  const updateExpense = comment => {
    const updatedExpense = {
      ...expense,
      comment: comment
    };
    dispatch(addComment(updatedExpense));
    hideModal();
  };

  return (
    <CommentInputContainer>
      <CommentInput
        onChangeText={text => onChangeText(text)}
        value={value}
        placeholder={expense.comment}
        ref={ref => (this.input = ref)}
      />
      <ButtonContainer>
        <AcceptButton onPress={() => updateExpense(value)}>
          <AcceptButtonText>{i18n.t("add")}</AcceptButtonText>
        </AcceptButton>
        <CancelButton onPress={() => hideModal()}>
          <CancelButtonText>{i18n.t("cancel")}</CancelButtonText>
        </CancelButton>
      </ButtonContainer>
    </CommentInputContainer>
  );
}
export default AddComment;

export const Wrapper = styled.View`
  border: 1px solid black;
  margin: 30px; // Remove later
`;
