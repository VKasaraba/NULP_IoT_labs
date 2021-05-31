import React, { useState, useEffect } from "react";
import { ListWrapper, LogoWrapper } from "./Navigation.styled";
import Home from "../Home/Home";
import Catalog from "../Catalog/Catalog";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  NavLink,
} from "react-router-dom";
import LogoPicture from "../../Icons/logo.png";
import Item from "../Item/Item";
import { getAllInsurances } from "../../utils/API.js";
import DataContext from "../../dataContext";
import Spinner from "../../Components/Spinner.js"
const { promisify } = require('util')
const sleep = promisify(setTimeout)

const Navigation = () => {
  let [data, setData] = useState([]);
  let isLoading = true;
  if (data.length > 0){
      isLoading = false;
  };
  
  useEffect(() => {
    if (data.length === 0){
      getAllInsurances().then((el) => {
        if(el!=undefined){
          setData(el);
        }
      });
    }
  });
  
  return (
    <Router>
      <LogoWrapper>
        <img src={LogoPicture} alt="Logo" />
      </LogoWrapper>
      <ListWrapper>
        <ul>
          <li>
            <NavLink exact to="/" activeClassName="selected">
              Home
            </NavLink>
          </li>
          <li>
            <NavLink exact to="/catalog" activeClassName="selected">
              Catalog
            </NavLink>
          </li>
          <li>
            <NavLink exact to="/cart" activeClassName="selected">
              Cart
            </NavLink>
          </li>
        </ul>
      </ListWrapper>
      <DataContext.Provider value={data}>
      <Switch>
        <Route path="/item">
          {isLoading ? (
            <Spinner />
          ):(
            <Item />
          )}
        </Route>
        <Route path="/catalog">
          {isLoading ? (
            <Spinner />
          ):(
            <Catalog />
          )}
        </Route>
        <Route path="/cart">
          <div>Hello it is cart</div>
        </Route>
        <Route path="/">
          {isLoading ? (
            <Spinner />
          ):(
            <Home />
          )}
        </Route>
      </Switch>
      </DataContext.Provider>
    </Router>
  );
};

export default Navigation;
