import React from "react";
import { deleteItem } from "../App/redux-helpers/Action"
import { useDispatch } from 'react-redux';
import { ImgWrapper } from '../Item/Item.styled';
import { useHistory } from "react-router-dom";
import { ButtonsWrapper, ItemWrapper } from "../CartItem/CartItem.styled"

const CartItem = ({ value }) => {
  const dispatch = useDispatch();
  let history = useHistory();
  function handleClick() {
    history.push(`/item?id=${value.id}`);
  }
  return (
      <ItemWrapper>
        <ImgWrapper src={value.imgSrc}></ImgWrapper>
        <h1>{value.insuranceCompanyName}</h1>
        <p>
          <strong>{value.text}</strong>
        </p>
        <p>
        Monthly payment: <strong>${value.customerMonthlyPaymentInUAH}</strong>
        </p>
        <p>
        Compensation: <strong>${value.insuranceCompensationInUAH}</strong>
        </p>
        <p>
        RImmunity Level: <strong>{value.customerImmunityToDiseases}</strong>
        </p>
        <ButtonsWrapper>
        <button onClick={() => dispatch(deleteItem(value))}>Remove</button>
        <button onClick={handleClick}> Show info </button>{" "}
        </ButtonsWrapper>
      </ItemWrapper>
  );
};

export default CartItem;
