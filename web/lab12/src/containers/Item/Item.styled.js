import styled from "styled-components";
import ModelPicture from "../../Icons/insurance_word.png";

export const SecionWrapper = styled.div`
  background-image: url(${ModelPicture});
  height: 100vh;
  background-size: 100% 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  > * {
    margin: auto;
  }
`;
export const InsuranceWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px 50px;
  background-color: lightblue;
  opacity: 0.9;
  width: 50%;
  height: 85%;
  border-radius: 100px;
  > h1 {
    border-top: 1px solid black;
    border-bottom: 1px solid black;
  }
`;
export const ImgWrapper = styled.img`
  width: 40%;
  border-radius: 40px;
  margin: 10px auto;
`;

export const ButtonsWrapper = styled.div`
  display: flex;
  justify-content: center;
  >button{
    margin-right: 10px;
    color: white;
    font-weight: 500;
    min-width: 8rem;
    background-color: #44c767;
    border: 0.1rem solid #33ac54;
    width: 10vw;
    height: 4vh;
    :last-child {
      background-color: orange;
      border: 0.1rem solid darkorange;
    }
  }
`;