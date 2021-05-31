import React from "react";
import { Card, Button } from "antd";
import { CardFooter } from "./CardItem.styled";
import { useHistory } from "react-router-dom";

const { Meta } = Card;

const CardItem = ({
  companyName = "No Company Name.",
  monthlyPayment,
  compensation,
  imageSrc,
  text,
  immunityLevel,
  id,
}) => {
  let history = useHistory();
  function handleClick() {
    history.push(`/item?id=${id}`);
  }
  return (
    <Card
      hoverable
      style={{ width: 350, borderRadius: "20px", margin: "0 0 60px 120px" }}
      cover={
        <img style={{ borderRadius: "20px" }} alt="example" src={imageSrc} />
      }
    >
      <Meta title={companyName} description={text} />{" "}
      <CardFooter>
        <p>
          {" "}
          <strong> $ {monthlyPayment} monthly</strong>{" "}
        </p>{" "}
        <p>
          <strong>$ {compensation} compensation</strong>
        </p>
        <Button onClick={handleClick}> Show info </Button>{" "}
      </CardFooter>{" "}
      <p>Recommended immunity level: {immunityLevel}</p>
    </Card>
  );
};

export default CardItem;
