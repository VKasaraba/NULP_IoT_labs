import styled from "styled-components";

export const ListWrapper = styled.div`
  a {
    display: flex;
    align-items: center;
    justify-content: center;
    font-weight: 350;
    color: black;
    background-color: white;
    height: 7vh;
    width: 10vw;
    border: 1px solid #fcba03;
    border-radius: 30px;
    :hover {
      background-color: lightgrey;
    }
  }

  ul {
    display: flex;
    align-items: center;
    justify-content: center;
    padding-top: 3vh;
    padding-bottom: 2vh;
  }

  li {
    > .selected {
      background-color: #f5ae3d;
      height: 7vh;
      width: 10vw;
      border: 1px solid orange;
      border-radius: 30px;
      color: white;
    }
    display: inline-block;
    position: relative;
    font-weight: bold;
    margin: 10px 30px;
    font-size: 22px;
    background-color: white;
  }
`;

export const LogoWrapper = styled.div`
  position: absolute;
  margin-left: 20vw;
  > img {
    height: 12vh;
    margin-top: 2vh;
  }
`;
