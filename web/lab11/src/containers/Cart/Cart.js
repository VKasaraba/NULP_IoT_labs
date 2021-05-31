import React, { useState } from "react";
import CartItem from "../CartItem/CartItem";
import {
  CartContainer,
  TitleStyled,
  TotalPriceSyled,
  ButtonOnCart,
  Footer,
} from "./Cart.styled";
import { useSelector } from "react-redux";

const Cart = () => {
  const select = useSelector((state) => state);

  return (
    <CartContainer>
      <TitleStyled>Shopping Cart</TitleStyled>
      <TotalPriceSyled>Total Monthly Price: ${select.totalPrice}</TotalPriceSyled>
      {select.orders.map((value) => {
        return <CartItem value={value} />;
      })}
    </CartContainer>
  );
};

export default Cart;