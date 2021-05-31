import styled from "styled-components";

export const CardFooter = styled.div`
  display: flex;
  margin-top: 20px;
  justify-content: space-between;
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