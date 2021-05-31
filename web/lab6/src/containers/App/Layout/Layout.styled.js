import styled from 'styled-components';

export const StyledHeader = styled.div`
    padding: 16px 20px 4px;
    display: flex;
    justify-content: center;
    width: 100%;
    background-color: lightgrey;
    border-bottom: 1.5px solid black;
    > div {
        display: flex;
    }
    p {
        font-size: 20px;
    }
    span {
        font-size: 24px;
    }
`

export const IconWrapper = styled.div`
    display: flex;
`