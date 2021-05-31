import React from "react";
import { TitleWrapper } from "../Forms/Success.styled"
import congrats from "../Forms/resources/v410.jpg"

const Success = () => {
  return (
    <div>
      <TitleWrapper>Success!</TitleWrapper>
      <TitleWrapper><img src={congrats} alt="Congratulations" /></TitleWrapper>
    </div>
  );
};

export default Success;