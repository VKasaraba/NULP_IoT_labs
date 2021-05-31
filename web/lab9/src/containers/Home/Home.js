import React, { useContext, useState } from "react";
import ModelPicture from "../../Icons/insurance.png";
import {
  SectionWrapper,
  TextWrapper,
  ButtonWrapper,
  CardWrapper,
} from "./Home.styled";
import CardItem from "../../Components/CardItem";
import DataContext from "../../dataContext";
import ImageModel1 from "../../Icons/Model_Insured-1.png";
import Spinner from "../../Components/Spinner.js"

function renderItems(data) {
  return data.map(
    ({
      insuranceCompanyName,
      customerMonthlyPaymentInUAH,
      insuranceCompensationInUAH,
      customerImmunityToDiseases,
      imgSrc,
      text="we're the best",
      id,
    }) => (
      <CardItem
        companyName={insuranceCompanyName}
        monthlyPayment={customerMonthlyPaymentInUAH}
        imageSrc={imgSrc}
        text={text}
        compensation={insuranceCompensationInUAH}
        immunityLevel={customerImmunityToDiseases}
        id={id}
        key={id}
      />
    )
  );
}

const Home = () => {
  const data = useContext(DataContext);
  const [count, setCount] = useState(3);
  return (
    <div>
      <SectionWrapper>
        <img src={ModelPicture} alt="Insurance" />
        <TextWrapper>
          <h2>Find the best insurance</h2>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Modi,
            architecto fugit inventore dolorum totam nostrum reprehenderit
            doloremque quisquam eligendi non magnam ut quae minima voluptates.
            Molestias obcaecati inventore deserunt a.
          </p>
        </TextWrapper>
      </SectionWrapper>
      <CardWrapper>{renderItems(data.slice(0, count))}</CardWrapper>
      <ButtonWrapper>
        <button onClick={() => setCount(count + 3)}>Show More</button>
      </ButtonWrapper>

    </div>
  );
};

export default Home;
