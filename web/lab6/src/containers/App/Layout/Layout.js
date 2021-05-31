import React from "react";
import { StyledHeader, IconWrapper } from "./Layout.styled.js";
import { HomeOutlined } from "@ant-design/icons";

const Layout = () => {
    return(
        <StyledHeader title="Best Insurances">
            <IconWrapper>
                <HomeOutlined />
            </IconWrapper>
            <p>Home Page</p>
        </StyledHeader>
    )
};

export default Layout;