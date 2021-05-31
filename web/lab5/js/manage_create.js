import {
    clearInputs,
    getInputValues,
    showErrors,
    closeErrors,
} from "./dom_util.js";

import {
    getInputErrors,
} from "./form_validation.js";

import {
    postInsurance,
} from "./api.js";


const submitButton = document.getElementById("submit__button");
const closeModalButton = document.getElementById("modal");
const mainPageUrl = "http://127.0.0.1:5500/index.html";

submitButton.addEventListener("click", (event) => {
    event.preventDefault();

    const { companyName, payment, compensation, customerName, duration, immunity } = getInputValues();
    clearInputs();

    let errors = getInputErrors(companyName, payment);
    if (errors.length > 0) {
        showErrors(errors);
        return
    };

    postInsurance({
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