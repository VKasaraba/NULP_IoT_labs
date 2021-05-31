import React, { useState, useEffect } from "react";
import Layout from "./Layout/Layout";
import Navigation from "../Navigation/Navigation";
import Footer from "./Footer/Footer";
import { getAllInsurances, getAllInsurancesByImmunity } from "../../utils/API.js";
import DataContext from "../../dataContext";
import Spinner from "../../Components/Spinner.js"


const App = () => {
  let [data, setData] = useState([]);
  let [isLoading, setLoading] = useState(true);
  useEffect(() => {
    if (data.length === 0){
      getAllInsurances().then((el) => {
        if(el!=undefined){
          setLoading(false);
          setData(el);
        }
      });
    }
  });
  return (
    <div>
      <Layout />
      {isLoading ? (
        <Spinner />
      ) : ( 
      <DataContext.Provider value={data}>
        <Navigation />
      </DataContext.Provider>
      )}
      <Footer />
    </div>
  );
};

export default App;
