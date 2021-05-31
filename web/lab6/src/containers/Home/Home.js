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
        image: ImageModel1,
        text: "The best on market"
    },
    {
        companyName: "Ferranty Graybeal",
        monthlyPayment: 17,
        image: ImageModel2,
        text: "Better than opponents"
    },
    {
        companyName: "Levin Insurance",
        monthlyPayment: 15,
        image: ImageModel3,
        text: "Choose us plz"
    }
]

const Home = () => {
    return(
        <div>
            <SectionWrapper>
                <img src={ModelPicture} alt="Insurance"/>
                <TextWrapper>
                    <h3>Find the best insurance</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Modi, architecto fugit 
                    inventore dolorum totam nostrum reprehenderit doloremque quisquam eligendi non magnam 
                    ut quae minima voluptates. Molestias obcaecati inventore deserunt a.</p>
                    <ButtonWrapper><button>View More</button></ButtonWrapper>
                </TextWrapper>
            </SectionWrapper>
            <CardWrapper>
                {data.map(({ companyName, monthlyPayment, image, text }, idx) =>(
                    <CardItem
                    companyName={companyName}
                    monthlyPayment={monthlyPayment}
                    imageSrc={image}
                    text={text}
                    id={idx}
                    />
                ))}
            </CardWrapper>
            <ButtonWrapper><button style={{margin:"7vh 42vw"}}>Show More</button></ButtonWrapper>
        </div>
    );
}

export default Home;