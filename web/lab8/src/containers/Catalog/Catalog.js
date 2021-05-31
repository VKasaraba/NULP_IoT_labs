import React, { useState, useContext } from "react";
import {
  FiltersWrapper,
  CardWrapper,
  Filter,
  InputWrapper,
  ButtonWrapper,
} from "./Catalog.styled";
import CardItem from "../../Components/CardItem";
import "bootstrap/dist/css/bootstrap.min.css";
import DropDownMenu from "../../Components/Dropdown";
import DataContext from "../../dataContext";

const options = [
  ["price ASCENDING", "price DESCENDING"],
  ["compensation ASCENDING", "compensation DESCENDING"],
  ["HIGH", "MIDDLE", "LOW"],
];

function renderItems(data) {
  return data.map(
    ({
      companyName,
      monthlyPayment,
      compensation,
      immunityLevel,
      image,
      text,
      id,
    }) => (
      <CardItem
        companyName={companyName}
        monthlyPayment={monthlyPayment}
        imageSrc={image}
        text={text}
        compensation={compensation}
        immunityLevel={immunityLevel}
        id={id}
        key={id}
      />
    )
  );
}

const Catalog = () => {
  const context = useContext(DataContext);
  let [data, setData] = useState(context);

  function sortInsurancesPriceAscending(type) {
    return [...context].sort(function (obj1, obj2) {
      if (type === "ASCENDING") {
        return obj1.monthlyPayment - obj2.monthlyPayment;
      } else {
        return obj2.monthlyPayment - obj1.monthlyPayment;
      }
    });
  }

  function sortInsurancesCompensationAscending(type) {
    return [...context].sort(function (obj1, obj2) {
      if (type === "ASCENDING") {
        return obj1.compensation - obj2.compensation;
      } else {
        return obj2.compensation - obj1.compensation;
      }
    });
  }

  function filterInsurances(level) {
    return [...context].filter((obj) => obj.immunityLevel.search(level) !== -1);
  }

  const handleClick = (e) => {
    if (e.slice(0, 27) === "Sort by monthly price-price") {
      setData(sortInsurancesPriceAscending(e.slice(28)));
    }

    if (e.slice(0, 33) === "Sort by compensation-compensation") {
      console.log("here");
      setData(sortInsurancesCompensationAscending(e.slice(34)));
    }

    if (e.slice(0, 19) === "Filter by immunity-") {
      setData(filterInsurances(e.slice(19)));
    }
  };

  return (
    <div>
      <FiltersWrapper>
        <Filter>
          <DropDownMenu
            title="Sort by monthly price"
            options={options[0]}
            handleClick={handleClick}
          />
        </Filter>
        <Filter>
          <DropDownMenu
            title="Sort by compensation"
            options={options[1]}
            handleClick={handleClick}
          />
        </Filter>
        <Filter>
          <DropDownMenu
            title="Filter by immunity"
            options={options[2]}
            handleClick={handleClick}
          />
        </Filter>
        <Filter>
          <button onClick={()=>{setData(context)}}>Reset</button>
        </Filter>
        <InputWrapper>
          <input type="text" placeholder="  Find by Company Name" onInput={(e) => setData(context.filter(obj => obj.companyName.search(e.target.value) !== -1))}></input>
        </InputWrapper>
      </FiltersWrapper>
      <CardWrapper>{renderItems(data)}</CardWrapper>
    </div>
  );
};

export default Catalog;
