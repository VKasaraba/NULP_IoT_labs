import React, { useContext } from "react";
import DataContext from "../../dataContext";
import { SecionWrapper, InsuranceWrapper } from "./Item.styled"

const Item = () => {
    const context = useContext(DataContext);
    
    const getId = () => {
        let url = window.location.href;
        return url.split("?id=")[1];
    }

    function getItem() {
        let result;
        const itemId = getId();
        [...context].forEach((obj) => {
            if (obj.id == itemId){
                result = obj;
            }
        });
        return result;
    }
    const item = getItem();
    return(
        <SecionWrapper>
            <InsuranceWrapper>
            <h1>{item.companyName}</h1>
            <p><strong>{item.text}</strong></p>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                Cumque animi dolore explicabo, recusandae fugit in sequi 
                vel eveniet asperiores atque consequatur fugiat cupiditate 
                consectetur excepturi, optio beatae hic repellat nesciunt 
                sunt ab ratione illo voluptas reiciendis. Laboriosam eveniet, 
                corrupti ipsa ut a earum tempora, sit itaque suscipit nesciunt 
                aut nulla?
            </p>
            <p>Number of clients: 400000</p>
            <p>Popularity in Ukraine: {item.immunityLevel}</p>
            </InsuranceWrapper>
        </SecionWrapper>
    )
}

export default Item;