import styled from "styled-components";

export const ListWrapper = styled.div`
    display: flex;
    justify-content: center;
    padding: 5vh 0;
    ul{
        list-style: none;
        display:flex;
        justify-content: center;
    }

    li{
        padding: 1vh 1.5vw 0;
    }

    button{
        :hover{
            background-color: #fff1db;
        }
        height: 6vh;
        width: 12vw;
        border-radius: 30px;
        border: 1px solid darkblue;
        background-color: white;
    }
`

export const LogoWrapper = styled.div`
    position: absolute;
    margin-left: 20vw;
    >img {
        height: 12vh;
        margin-top: 2vh;
    }
`