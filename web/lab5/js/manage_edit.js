import {
    clearInputs,
    getEditInputValues,
    showErrors,
    closeErrors,
    renderItemsList,
} from "./dom_util.js";

import {
    getInputErrors,
} from "./form_validation.js";

import {
    editInsurance, 
    getAllInsurances,
} from "./api.js";

const editButton = document.getElementById("edit__button");
const closeModalButton = document.getElementById("modal");
const editPageUrl = "http://127.0.0.1:5500/edit_page.html?id=";
const mainPageUrl = "http://127.0.0.1:5500/index.html";

editButton.addEventListener("click", (event) => {
    event.preventDefault();

    const { companyName, payment, compensation, customerName, duration, immunity } = getEditInputValues();
    clearInputs();

    let errors = getInputErrors(companyName, payment);
    if (errors.length > 0) {
        showErrors(errors);
        return
    };

    let id = window.location.href.replace(editPageUrl, "");
    editInsurance(id, {
        customerMonthlyPaymentInUAH: payment,
        insuranceCompensationInUAH: compensation,
        insuranceCompanyName: companyName,
        customerName: customerName,
        insuranceDurationInYears: duration,
        customerImmunityToDiseases: immunity,
        });
    
    window.open(mainPageUrl, "_self");
    renderItemsList();
});

closeModalButton.addEventListener("click", () => {
    closeErrors();
});