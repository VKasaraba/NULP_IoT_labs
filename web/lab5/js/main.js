import {
    clearInputs,
    renderItemsList,
    getInputValues,
    countTotal,
    getEditInputValues,
    showErrors,
    closeErrors,
} from "./dom_util.js";

import {
    getInputErrors,
} from "./form_validation.js"

import {
    postInsurance,
    getAllInsurances,
} from "./api.js";

const submitButton = document.getElementById("submit__button");
const findButton = document.getElementById("find__button");
const cancelButton = document.getElementById("cancel__button");
const findInput = document.getElementById("find__input");
const sortButton = document.getElementById("sort__button");
const countButton = document.getElementById("count__button");
const editButton = document.getElementById("edit__button");
const closeModalButton = document.getElementById("modal");


let insurances = [];
let insurancesAreFound = false;
let foundInsurancesToCount;

const refetchAllInsurances = async() => {
    const allInsurances = await getAllInsurances();
    insurances = allInsurances;
    renderItemsList(insurances);
};

submitButton.addEventListener("click", (event) => {
    event.preventDefault();

    const { companyName, payment, compensation, customerName, duration, immunity } = getInputValues();
    clearInputs();

    let errors = getInputErrors(companyName, payment);
    if (errors.length > 0) {
        console.log('Here');
        showErrors(errors);
        return
    }

    postInsurance({
        id,
        payment,
        compensation,
        companyName,
        customerName,
        duration,
        immunity,
    });
});

editButton.addEventListener("click", (event) => {

    event.preventDefault();

    const { name, payment } = getEditInputValues();

    clearInputs();

    let errors = getInputErrors(name, payment);
    if (errors.length > 0) {
        showErrors(errors);
        return
    }

    for (const insurance of insurances) {
        if (insurance.name == name) {
            insurance.payment = payment
        };
    };

    renderItemsList(insurances);
});


closeModalButton.addEventListener("click", () => {
    closeErrors();
});


sortButton.addEventListener("click", () => {
    let sortedInsurances = null;
    if (insurancesAreFound) {
        sortedInsurances = foundInsurancesToCount.sort(function(obj1, obj2) {
            return obj2.customerMonthlyPaymentInUAH - obj1.customerMonthlyPaymentInUAH;
        });
    } else {
        sortedInsurances = insurances.sort(function(obj1, obj2) {
            return obj2.customerMonthlyPaymentInUAH - obj1.customerMonthlyPaymentInUAH;
        });
    }
    renderItemsList(sortedInsurances);
});

findButton.addEventListener("click", () => {
    let foundInsurances = []
    for (const insurance of insurances) {
        if (insurance.insuranceCompanyName == findInput.value) {
            foundInsurances.push(insurance);
        };
    };
    renderItemsList(foundInsurances);
    foundInsurancesToCount = foundInsurances;
    insurancesAreFound = true;
});

cancelButton.addEventListener("click", () => {
    renderItemsList(insurances);
    findInput.value = "";
    insurancesAreFound = false;
});

countButton.addEventListener("click", () => {
    let totalPrice = 0;

    new Promise((resolve, reject) => {
            let status = refetchAllInsurances();
            resolve(status);
        })
        .then(calculate)
        .catch(err => console.log("Error: " + err));

    function calculate() {
        if (insurancesAreFound) {
            for (const insurance of foundInsurancesToCount) {
                totalPrice = Number(totalPrice) + Number(insurance.customerMonthlyPaymentInUAH);
            }
        } else {
            for (const insurance of insurances) {
                totalPrice = Number(totalPrice) + Number(insurance.customerMonthlyPaymentInUAH);
            }
        }
        countTotal(totalPrice);
    }
});

refetchAllInsurances();