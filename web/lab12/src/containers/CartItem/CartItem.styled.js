import styled from "styled-components";

export const ItemWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #8cecff;
  border-radius: 40px;
  height: 450px;
  width: 300px;
  margin: 20px 20px;
  >img{
    margin-top: 16px;
    height: 40%;
    width: 70%;
  }
  >h1{
    font-size:25px;
  }
  >p{
    font-size: 15px;
  }
`;

export const ButtonsWrapper = styled.div`
  display: flex;
  justify-content: center;
  >button{
    margin-right: 10px;
    color: white;
    font-weight: 500;
    background-color: red;
    width: 5vw;
    height: 4vh;
    border: none;
    :last-child {
      background-color: orange;
    }
  }
`;