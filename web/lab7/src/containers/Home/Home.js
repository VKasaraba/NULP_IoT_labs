import React from "react";
import ModelPicture from "../../Icons/insurance.png";
import { SectionWrapper, TextWrapper, ButtonWrapper, CardWrapper } from "./Home.styled";
import CardItem from "../../Components/CardItem"
import ImageModel1 from "../../Icons/Model_Insured-1.png";
import ImageModel2 from "../../Icons/Model_Ferranti-1.png"
import ImageModel3 from "../../Icons/Model_Levin.png"

const data = [
    {
        companyName: "Insured Agency",
        monthlyPayment: 23,
        compensation: 10001,
        image: ImageModel1,
        text: "The best on market",
        id: 1
    },
    {
        companyName: "Ferranty Graybeal",
        monthlyPayment: 17,
        compensation: 10002,
        image: ImageModel2,
        text: "Better than opponents",
        id: 2
    },
    {
        companyName: "Levin Insurance",
        monthlyPayment: 15,
        compensation: 10003,
        image: ImageModel3,
        text: "Choose us plz",
        id: 3
    }
]

const Home = () => {
    return(
        <div>
            <SectionWrapper>
                <img src={ModelPicture} alt="Insurance"/>
                <TextWrapper>
                    <h2>Find the best insurance</h2>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Modi, architecto fugit 
                    inventore dolorum totam nostrum reprehenderit doloremque quisquam eligendi non magnam 
                    ut quae minima voluptates. Molestias obcaecati inventore deserunt a.</p>
                    <ButtonWrapper><button>View More</button></ButtonWrapper>
                </TextWrapper>
            </SectionWrapper>
            <CardWrapper>
                {data.map(({ companyName, monthlyPayment, compensation, image, text, id }) =>(
                    <CardItem
                    companyName={companyName}
                    monthlyPayment={monthlyPayment}
                    compensation={compensation}
                    imageSrc={image}
                    text={text}
                    key={id}
                    />
                ))}
            </CardWrapper>
            <ButtonWrapper><button style={{margin:"7vh 42vw"}}>Show More</button></ButtonWrapper>
        </div>
    );
}

export default Home;