import React from "react";
import { StyledHeader, IconWrapper, GreetingWrapper } from "./Layout.styled.js";
import { BookOutlined } from "@ant-design/icons";

const Layout = () => {
  let myStorage = window.localStorage;
  return (
    <>
      <StyledHeader title="Best Insurances">
        <IconWrapper>
          <BookOutlined />
        </IconWrapper>
        <p>Best Insurances</p>
      </StyledHeader>
      <StyledHeader style={{ backgroundColor: "#f0d78b" }}>
        <GreetingWrapper>
          {window.localStorage.getItem("isAuthorized") === "true" ? (
            <>
              {window.localStorage.getItem("First Name") != null ? (
                <>
                  <h3>Hello, {myStorage.getItem("First Name")}!</h3>
                  <p>
                    {myStorage.getItem("Email")} | <a href="#" onClick={() => {window.localStorage.clear(); window.location.reload();}}>LogOut</a>
                  </p>
                </>
              ) : (
                <>
                  <h3>Hello!</h3>
                  <p>
                    {myStorage.getItem("Email")} | <a href="#" onClick={() => {window.localStorage.clear(); window.location.reload();}}>LogOut</a>
                  </p>
                </>
              )}
            </>
          ) : null}
        </GreetingWrapper>
      </StyledHeader>
    </>
  );
};

export default Layout;
