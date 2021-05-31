import React from "react";
import { deleteItem } from "../App/redux-helpers/Action"
import { useDispatch } from 'react-redux';
import { ImgWrapper } from '../Item/Item.styled';
import { useHistory } from "react-router-dom";

const CartItem = ({ value }) => {
  const dispatch = useDispatch();
  let history = useHistory();
  function handleClick() {
    history.push(`/item?id=${value.id}`);
  }
  return (
    <div>
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
    Recommended Immunity Level: <strong>{value.customerImmunityToDiseases}</strong>
    </p>
    <button onClick={() => dispatch(deleteItem(value))}>Remove</button>
    <button onClick={handleClick}> Show all info </button>{" "}
    </div>
  );
};

export default CartItem;
