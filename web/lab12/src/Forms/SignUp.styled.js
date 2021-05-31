import styled from "styled-components";

export const FormWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

export const TitleWrapper = styled.div`
  display: flex;
  justify-content: center;
  background-color: #fff1db;
  width: 100vw;
  height: 15vh;
  margin-bottom: 45px;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  >h1{
    display: flex;
    justify-content: center;
    margin-top: 25px;
  }
  >span{
    margin: 40px 10px 0;
    >*{
      font-size: 20px;
      color: darkblue;
    }
  }
`;

export const ErrorWrapper = styled.div`
  color: red;
`;

export const InputWrapper = styled.div`
  >input, select {
    border-radius: 10px;
    border: 2px solid #2d9fd9;
    height: 5.5vh;
    width: 20vw;
    margin-bottom: 20px;
  }
`;

export const LabelWrapper = styled.div`
  color: darkblue;
  font-size: 20px;
  font-weight: 600;
`;

export const ButtonWrapper = styled.div`
  >button {
    border-radius: 10px;
    color: white;
    font-weight: 500;
    margin: 1.5rem 0;
    padding: 0.5rem 1rem;
    min-width: 8rem;
    background-color: #6989fa;
    border: 0.1rem solid #0f59d1;
    width: 12vw;
}
`;