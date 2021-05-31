import React from "react";
import { ListWrapper, LogoWrapper } from "./Navigation.styled"
import Home from '../Home/Home';
import LogoPicture from "../../Icons/logo.png";

const Navigation = () => {
    return(
        <div>
            <LogoWrapper><img src={LogoPicture} alt="Logo" /></LogoWrapper>
            <ListWrapper>
                    <ul>
                        <li><button>Home</button></li>
                        <li><button>Catalog</button></li>
                        <li><button>Cart</button></li>
                    </ul>
            </ListWrapper>
            <Home />
        </div>
    );
}

export default Navigation;