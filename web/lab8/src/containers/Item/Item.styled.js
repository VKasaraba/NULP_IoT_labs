import styled from "styled-components";
import ModelPicture from "../../Icons/insurance_word.png";

export const SecionWrapper = styled.div`
    background-image: url(${ModelPicture});
    height: 100vh;
    background-size: 100%  100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    >*{
        margin: auto;
    }
`
export const InsuranceWrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 100px 50px;
    background-color: lightblue;
    opacity: 0.9;
    width: 50%;
    height: 70%;
    border-radius: 100px;
    >h1{
        border-bottom: 1px solid black;
    }
`