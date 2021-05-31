import React from "react";
import { Card, Button } from "antd";
import { CardFooter } from "./CardItem.styled"

const { Meta } = Card;

const CardItem = ({ companyName = "No Company Name.", monthlyPayment, imageSrc, text }) => (
<Card
    hoverable
    style={{ width: 350, borderRadius: "20px" }}
    cover={
    <img style={{ borderRadius: "20px" }} alt="example" src={imageSrc} />
    }
>
    <Meta title={companyName} description={text} />{" "}
    <CardFooter>
    <p> $ {monthlyPayment} </p> <Button> Show More </Button>{" "}
    </CardFooter>{" "}
</Card>
);

export default CardItem;
