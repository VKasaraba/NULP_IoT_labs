import React from "react";
import Layout from "./Layout/Layout";
import Navigation from "../Navigation/Navigation";
import Footer from "./Footer/Footer";
import DataContext from "../../dataContext"
import ImageModel1 from "../../Icons/Model_Insured-1.png";
import ImageModel2 from "../../Icons/Model_Ferranti-1.png"
import ImageModel3 from "../../Icons/Model_Levin.png"

const data = [
  {
      companyName: "Insured Agency",
      monthlyPayment: 23,
      compensation: 21000,
      immunityLevel: "MIDDLE",
      image: ImageModel1,
      text: "The best on market",
      id: 1
  },
  {
      companyName: "Ferranty Graybeal",
      monthlyPayment: 17,
      compensation: 10001,
      immunityLevel: "HIGH",
      image: ImageModel2,
      text: "Better than opponents",
      id: 2
  },
  {
      companyName: "Levin Insurance",
      monthlyPayment: 15,
      compensation: 30201,
      immunityLevel: "MIDDLE",
      image: ImageModel3,
      text: "Choose us plz",
      id: 3
  },
  {
      companyName: "Insured Agency",
      monthlyPayment: 24,
      compensation: 28000,
      immunityLevel: "LOW",
      image: ImageModel1,
      text: "The best on market",
      id: 4
  },
  {
      companyName: "Ferranty Graybeal",
      monthlyPayment: 11,
      compensation: 38000,
      immunityLevel: "MIDDLE",
      image: ImageModel2,
      text: "Better than opponents",
      id: 5
  },
  {
      companyName: "Levin Insurance",
      monthlyPayment: 16,
      compensation: 40000,
      immunityLevel: "LOW",
      image: ImageModel3,
      text: "Choose us plz",
      id: 6
  }, {
      companyName: "Insured Agency",
      monthlyPayment: 26,
      compensation: 19901,
      immunityLevel: "HIGH",
      image: ImageModel1,
      text: "The best on market",
      id: 7
  },
  {
      companyName: "Ferranty Graybeal",
      monthlyPayment: 10,
      compensation: 22222,
      immunityLevel: "HIGH",
      image: ImageModel2,
      text: "Better than opponents",
      id: 8
  },
  {
      companyName: "Levin Insurance",
      monthlyPayment: 15,
      compensation: 33333,
      immunityLevel: "LOW",
      image: ImageModel3,
      text: "Choose us plz",
      id: 9
  }
]

const App = () => {
  return (
    <div>
      <Layout />
      <DataContext.Provider value={data}>
        <Navigation />
      </DataContext.Provider>
      <Footer />
    </div>
  );
}

export default App;