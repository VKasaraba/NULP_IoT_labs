import { setImages } from "./ImageManager.js"
import axios from "axios";
const  baseURL = "http://localhost:8080/healthinsurance";

export const getAllInsurances = async () => {
  let resultArray = await axios.get(baseURL)
  .then(function (response) {
    return response.data;
  })
  .catch(function (error) {
    console.log(error);
  })
  setImages(resultArray);
  return resultArray
};

export const getInsuranceById = async (id) => {
  let resultArray = new Array();
  let result = await axios.get(`${baseURL}/${id}`)
  .then(function (response) {
    return response.data;
  })
  .catch(function (error) {
    console.log(error);
  })
  resultArray.push(result);
  setImages(resultArray);
  return resultArray
};

export const getAllInsurancesByImmunity = async (immunityLevel) => {
  let resultArray = await axios.get(`${baseURL}/immunityLevel=${immunityLevel}`)
  .then(function (response) {
    return response.data;
  })
  .catch(function (error) {
    console.log(error);
  })
  setImages(resultArray);
  return resultArray
};

export const filterAllInsurancesByName = async (name) => {
  let resultArray = await axios.get(`${baseURL}/companyName=${name}`)
  .then(function (response) {
    return response.data;
  })
  .catch(function (error) {
    console.log(error);
  })
  setImages(resultArray);
  return resultArray
};