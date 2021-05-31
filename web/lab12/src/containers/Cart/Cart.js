import React from "react";
import CartItem from "../CartItem/CartItem";
import {
  CartContainer,
  TextContainer,
} from "./Cart.styled";
import { useSelector } from "react-redux";
import LogIn from "../../Forms/LogIn"

const Cart = () => {
  let myStorage = window.localStorage;
  const select = useSelector((state) => state);
  if (myStorage.getItem('isAuthorized') === 'true') {
  return (
    <div>
      <TextContainer>
      <h3>Shopping Cart</h3>
      <p>Total Monthly Price: ${select.totalPrice}</p>
      </TextContainer>
      <CartContainer>
      {select.orders.map((value) => {
        return <CartItem value={value} />;
      })}
    </CartContainer>
    </div>
  );}
  return (<LogIn />);
};

export default Cart;