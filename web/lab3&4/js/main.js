import {
    addItemToPage,
    clearInputs,
    renderItemsList,
    getInputValues,
    countTotal,
    getEditInputValues,
    showForm,
    showErrors,
    closeErrors,
} from "./dom_util.js";

import{
    getInputErrors,
} from "./form_validation.js"

const submitButton = document.getElementById("submit__button");
const findButton = document.getElementById("find__button");
const cancelButton = document.getElementById("cancel__button");
const findInput = document.getElementById("find__input");
const sortButton = document.getElementById("sort__button");
const countButton = document.getElementById("count__button");
const openCreateButton = document.getElementById("open__create__button");
const openEditButton = document.getElementById("open__edit__button");
const createForm = document.getElementById("create__form");
const editForm = document.getElementById("edit__form");
const editButton = document.getElementById("edit__button");
const closeModalButton = document.getElementById("modal");


let insurances = [];
let insurancesAreFound = false;
let foundInsurancesToCount;

openCreateButton.addEventListener("click", () => {
    showForm(createForm);
});

openEditButton.addEventListener("click", () => {
    showForm(editForm);
});

const addItem = ({ payment, name }) => {
    const generatedId = uuid.v1();

    const newItem = {
        id: generatedId,
        name,
        payment,
    };
    insurances.push(newItem);

    addItemToPage(newItem);
};

submitButton.addEventListener("click", (event) => {

    // Prevents default page reload on submit
    event.preventDefault();

    const { name, payment } = getInputValues();

    clearInputs();

    let errors = getInputErrors(name, payment);
    if (errors.length > 0) {
        showErrors(errors);
        return
    }

    addItem({
        name,
        payment,
    });
});

editButton.addEventListener("click", (event) => {
    // Prevents default page reload on submit
    event.preventDefault();

    const { name, payment } = getEditInputValues();

    clearInputs();

    let errors = getInputErrors(name, payment);
    if (errors.length > 0) {
        showErrors(errors);
        return
    }

    for (const insurance of insurances) {
        if (insurance.name == name){
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
    if (insurancesAreFound){
        sortedInsurances = foundInsurancesToCount.sort(function(obj1, obj2) {
            return obj2.payment - obj1.payment;
        });
    }
    else {
        sortedInsurances = insurances.sort(function(obj1, obj2) {
            return obj2.payment - obj1.payment;
        });
    }
    renderItemsList(sortedInsurances);
});

findButton.addEventListener("click", () => {
    const foundInsurances = insurances.filter(insurance => insurance.name.search(findInput.value) !== -1);
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
    if (insurancesAreFound){
        for (const insurance of foundInsurancesToCount) {
            totalPrice = Number(totalPrice) + Number(insurance.payment);
        }
    } else {
        for (const insurance of insurances) {
            totalPrice = Number(totalPrice) + Number(insurance.payment);
        }
    }
    countTotal(totalPrice);
});

renderItemsList(insurances);