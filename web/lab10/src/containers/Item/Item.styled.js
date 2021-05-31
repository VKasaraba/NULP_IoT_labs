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
  height: 80%;
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
