import React,{ useState, useEffect } from "react";
import { FiltersWrapper, CardWrapper, Filter, InputWrapper, ButtonWrapper } from "./Catalog.styled"
import CardItem from "../../Components/CardItem"
import ImageModel1 from "../../Icons/Model_Insured-1.png";
import ImageModel2 from "../../Icons/Model_Ferranti-1.png"
import ImageModel3 from "../../Icons/Model_Levin.png"
import 'bootstrap/dist/css/bootstrap.min.css';
import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown'
import DropDownMenu from "../../Components/Dropdown";

let data = [
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
        compensation: 10001,
        image: ImageModel2,
        text: "Better than opponents",
        id: 2
    },
    {
        companyName: "Levin Insurance",
        monthlyPayment: 15,
        compensation: 10001,
        image: ImageModel3,
        text: "Choose us plz",
        id: 3
    },
    {
        companyName: "Insured Agency",
        monthlyPayment: 24,
        compensation: 10001,
        image: ImageModel1,
        text: "The best on market",
        id: 4
    },
    {
        companyName: "Ferranty Graybeal",
        monthlyPayment: 11,
        compensation: 10001,
        image: ImageModel2,
        text: "Better than opponents",
        id: 5
    },
    {
        companyName: "Levin Insurance",
        monthlyPayment: 16,
        compensation: 10001,
        image: ImageModel3,
        text: "Choose us plz",
        id: 6
    }, {
        companyName: "Insured Agency",
        monthlyPayment: 26,
        compensation: 10001,
        image: ImageModel1,
        text: "The best on market",
        id: 7
    },
    {
        companyName: "Ferranty Graybeal",
        monthlyPayment: 10,
        compensation: 10001,
        image: ImageModel2,
        text: "Better than opponents",
        id: 8
    },
    {
        companyName: "Levin Insurance",
        monthlyPayment: 15,
        compensation: 10001,
        image: ImageModel3,
        text: "Choose us plz",
        id: 9
    }
]

// const [value,setValue]=useState('');

// const handleSelect=(e)=>{
//     console.log(e);
//     if (e === "Monthly price ASCENDING") {
//         data = data.slice(2);
//         renderItems(data)
//     }
// }

function renderItems() {
    console.log("rendering")
    console.log(data)
    return(
        data.map(({ companyName, monthlyPayment, compensation, image, text, id }) =>(
        <CardItem
        companyName={companyName}
        monthlyPayment={monthlyPayment}
        imageSrc={image}
        text={text}
        compensation={compensation}
        key={id}
        />
        )))
}

const Catalog = () => {
    const [value, setValue]=useState(false);
    useEffect (()=>{
        setValue(true);
        console.log("success")
    }, [data]);
    return(
        <div>
            <FiltersWrapper value={value}>
                <Filter>
                    <DropDownMenu title="Sort by monthly price" option1 = "Monthly price ASCENDING" option2="Monthly price DESCENDING" />
                </Filter>
                <Filter>
                    <DropDownMenu title="Sort by compensation" option1 = "Compensation ASCENDING" option2="Compensation DESCENDING" />
                </Filter>
                <Filter>
                    <DropDownMenu title="Sort by immunity" option1 = "High" option2="Medium" option3="Low"/>
                </Filter>
                <InputWrapper>
                    <input type="text" placeholder="  Find by Company Name"></input>
                    <ButtonWrapper><button>Find</button></ButtonWrapper>
                </InputWrapper>
            </FiltersWrapper>
            <CardWrapper>
                {renderItems(data)}
            </CardWrapper>
        </div>
    );
}

export default Catalog;