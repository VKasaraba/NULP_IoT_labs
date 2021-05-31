import styled from 'styled-components';

export const FiltersWrapper = styled.div`
    display: flex;
    justify-content: flex-start;
    align-items: center;
    background-color: #fff1db;
    width: 100%;
    height: 12vh;
` 

export const Filter = styled.div`
    margin-left: 120px;
    margin-right: -50px;
    .btn-primary {
        background-color:orange;
        border-width: 0px;
        height: 6vh;
    }
` 

export const CardWrapper = styled.div`
    display: flex;
    flex-wrap:wrap;
    flex-grow: 2;
    justify-content: flex-start;
    margin-top: 30px;
`

export const InputWrapper = styled.div`
    margin-left:auto;
    margin-right: 7vw;
    display:flex;
    align-items: center;
    >input{
        border-radius: 30px;
        height: 5vh;
        border: 1px solid #944700;
        width: 15vw;
    }
`

export const ButtonWrapper = styled.div`
    >button{
    width: 8vw;
    height: 5vh;
    margin-left: 2vw;
    border-radius: 30px;
    background-color: #fffaf2;
    color: #b85800;
    border: 1px solid #944700;
        :hover{
            background-color: orange;
            color: white;
        }
    }
`  