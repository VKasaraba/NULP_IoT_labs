import React, { useState, useContext } from "react";
import {
  FiltersWrapper,
  CardWrapper,
  Filter,
  InputWrapper,
} from "./Catalog.styled";
import CardItem from "../../Components/CardItem";
import "bootstrap/dist/css/bootstrap.min.css";
import DropDownMenu from "../../Components/Dropdown";
import DataContext from "../../dataContext";
import { filterAllInsurancesByName, getAllInsurancesByImmunity } from "../../utils/API.js";

const options = [
  ["price ASCENDING", "price DESCENDING"],
  ["compensation ASCENDING", "compensation DESCENDING"],
  ["HIGH", "MIDDLE", "LOW"],
];

function renderItems(data) {
  return data.map(
    ({
      insuranceCompanyName,
      customerMonthlyPaymentInUAH,
      insuranceCompensationInUAH,
      customerImmunityToDiseases,
      imgSrc,
      text="we're the best",
      id,
    }) => (
      <CardItem
        companyName={insuranceCompanyName}
        monthlyPayment={customerMonthlyPaymentInUAH}
        imageSrc={imgSrc}
        text={text}
        compensation={insuranceCompensationInUAH}
        immunityLevel={customerImmunityToDiseases}
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
        return obj1.customerMonthlyPaymentInUAH - obj2.customerMonthlyPaymentInUAH;
      } else {
        return obj2.customerMonthlyPaymentInUAH - obj1.customerMonthlyPaymentInUAH;
      }
    });
  }

  function sortInsurancesCompensationAscending(type) {
    return [...context].sort(function (obj1, obj2) {
      if (type === "ASCENDING") {
        return obj1.insuranceCompensationInUAH - obj2.insuranceCompensationInUAH;
      } else {
        return obj2.insuranceCompensationInUAH - obj1.insuranceCompensationInUAH;
      }
    });
  }

  function filterInsurances(level) {
    getAllInsurancesByImmunity(level).then((el) => {
      setData(el);
    });
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
      filterInsurances(e.slice(19));
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
          <button
            onClick={() => {
              setData(context);
            }}
          >
            Reset
          </button>
        </Filter>
        <InputWrapper>
          <input
            type="text"
            placeholder="  Find by Company Name"
            onInput={(e) =>
                filterAllInsurancesByName(e.target.value).then((el) => {
                  setData(el);
                }
              )
            }
          ></input>
        </InputWrapper>
      </FiltersWrapper>
      <CardWrapper>{renderItems(data)}</CardWrapper>
    </div>
  );
};

export default Catalog;
