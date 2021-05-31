import React from "react";
import Layout from "./Layout/Layout";
import Navigation from "../Navigation/Navigation";
import Footer from "./Footer/Footer";
import store from "../App/redux-helpers/store"
import { Provider } from 'react-redux'


const App = () => {
  return (
    <div>
      <Provider store={store}>
        <Layout />
        <Navigation />
        <Footer />
      </Provider>
    </div>
  );
};

export default App;
