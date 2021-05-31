import styled from "styled-components";

export const SectionWrapper = styled.div`
    >img {
        height: 40vh;
    }
    display: flex;
    justify-content: space-around;
    background-color: #fff1db;
`;

export const TextWrapper = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    max-width: 40vw;
    padding-right: 10vw;
`  

export const ButtonWrapper = styled.div`
    >button{
    width: 15vw;
    height: 6vh;
    border-radius: 30px;
    background-color: #fffaf2;
    color: #b85800;
    border: 1px solid #944700;
    margin: auto;
    :hover{
        background-color: orange;
        color: white;
    }
    }
`  

export const CardWrapper = styled.div`
    display: flex;
    justify-content: space-around;
    margin-top: 30px;
`