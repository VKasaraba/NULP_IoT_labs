import React from "react";
import { ListWrapper, LogoWrapper } from "./Navigation.styled"
import Home from '../Home/Home';
import Catalog from '../Catalog/Catalog';
import { BrowserRouter as Router, Switch, Route, NavLink } from "react-router-dom";
import LogoPicture from "../../Icons/logo.png";

const Navigation = () => {
    return(
        <Router>
            <LogoWrapper><img src={LogoPicture} alt="Logo" /></LogoWrapper>
            <ListWrapper>
                    <ul>
                        <li>
                            <NavLink  exact to="/" activeClassName="selected">Home</NavLink>
                        </li>
                        <li>
                            <NavLink  exact to="/catalog" activeClassName="selected">Catalog</NavLink>
                        </li>
                        <li>
                            <NavLink  exact to="/cart" activeClassName="selected">Cart</NavLink>
                        </li>
                    </ul>
            </ListWrapper>
            <Switch>
                <Route path="/catalog">
                    <Catalog />
                </Route>
                <Route path="/cart">
                    <div>Hello it is cart</div>
                </Route>
                <Route path="/">
                    <Home />
                </Route>
            </Switch>
        </Router>
    );
}

export default Navigation;