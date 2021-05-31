import React from "react";
import { FacebookOutlined, TwitterOutlined, LinkedinFilled, GooglePlusOutlined } from "@ant-design/icons";
import { FooterWrapper, TextWrapper, LogoWrapper, IconsWrapper, IconBase, CopyrightsWrapper, TopFooterWrapper } from "./Footer.styled";
import LogoPicture from "../../../Icons/logo.png"


const Footer = () => {
    return(
        <div>
            <FooterWrapper>
                <TopFooterWrapper>
                    <TextWrapper>
                        <h3>Branding stuff</h3>
                        <p>Lorem ipsum dolor sit amet. <br />
                            Animi doloribus cumque <br />
                            odit iste consequuntur.
                        </p>
                    </TextWrapper>
                <LogoWrapper><img src={LogoPicture} alt="Logo" /></LogoWrapper>
                <IconsWrapper>
                    <IconBase component={FacebookOutlined} color="#0f4396" />
                    <IconBase component={TwitterOutlined} color="#00c4eb"/>
                    <IconBase component={LinkedinFilled} color="#007AB9"/>
                    <IconBase component={GooglePlusOutlined} color="red"/>
                </IconsWrapper>
                </TopFooterWrapper>
                <CopyrightsWrapper>
                <p>2020 IoT | All rights reserved</p>
                </CopyrightsWrapper>
            </FooterWrapper>
        </div>
    );
}

export default Footer;