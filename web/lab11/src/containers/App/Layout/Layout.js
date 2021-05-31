import React from "react";
import { StyledHeader, IconWrapper } from "./Layout.styled.js";
import { BookOutlined } from "@ant-design/icons";

const Layout = () => {
  return (
    <StyledHeader title="Best Insurances">
      <IconWrapper>
        <BookOutlined />
      </IconWrapper>
      <p>Best Insurances</p>
    </StyledHeader>
  );
};

export default Layout;
