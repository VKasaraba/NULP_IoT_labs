import React, { useContext, useState, useEffect } from "react";
import { SecionWrapper, InsuranceWrapper, ImgWrapper } from "./Item.styled";
import { getInsuranceById } from "../../utils/API.js"

const getId = () => {
  let url = window.location.href;
  return url.split("?id=")[1];
};

const Item = () => {
  let [item, setItem] = useState('');
  useEffect(() => {
    if (item === ''){
      getInsuranceById(getId()).then((elem) => {
        setItem(elem[0]);
      });
    }
  });
  return (
    <SecionWrapper>
      <InsuranceWrapper>
        <ImgWrapper src={item.imgSrc}></ImgWrapper>
        <h1>{item.insuranceCompanyName}</h1>
        <p>
          <strong>{item.text}</strong>
        </p>
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque animi
          dolore explicabo, recusandae fugit in sequi vel eveniet asperiores
          atque consequatur fugiat cupiditate consectetur excepturi, optio
          beatae hic repellat nesciunt sunt ab ratione illo voluptas reiciendis.
          Laboriosam eveniet, corrupti ipsa ut a earum tempora, sit itaque
          suscipit nesciunt aut nulla?
        </p>
        <p>
        Monthly payment: <strong>${item.customerMonthlyPaymentInUAH}</strong>
        </p>
        <p>
        Compensation: <strong>${item.insuranceCompensationInUAH}</strong>
        </p>
        <p>
          Recommended Immunity Level: <strong>{item.customerImmunityToDiseases}</strong>
        </p>
      </InsuranceWrapper>
    </SecionWrapper>
  );
};

export default Item;
