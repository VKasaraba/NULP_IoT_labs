import styled from "styled-components";
import Icon from '@ant-design/icons';

export const FooterWrapper = styled.div`
    display: flex;
    justify-content: space-around;
    flex-direction: column;
    background-color: lightgrey;
`

export const TopFooterWrapper = styled.div`
    display: flex;
    justify-content: space-around;
    align-items:center;
    min-height: 20vh;
    border-top: 1px solid black;
`


export const TextWrapper = styled.div`
    direction: flex;
    flex-direction: column;
    justify-content: center;
`
export const LogoWrapper = styled.div`
    >img {
        height: 11vh;
    }
`
export const IconsWrapper = styled.div`
    direction: flex;
`
export const IconBase = styled(Icon)`
    font-size: 24px;
    color: ${({color}) => color};
    margin-left: 1vw;
`

export const CopyrightsWrapper =styled.div`
    min-width: 75vw;
    >p {
        display:flex;
        justify-content: center;
        margin-top: 1vh;
    }
`