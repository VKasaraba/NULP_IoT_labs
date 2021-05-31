import {
    clearInputs,
    getInputValues,
    showErrors,
    closeErrors,
} from "./dom_util.js";

import {
    getInputErrors,
} from "./form_validation.js";


const submitButton = document.getElementById("submit__button");
const closeModalButton = document.getElementById("modal");

submitButton.addEventListener("click", (event) => {

    // Prevents default page reload on submit
    event.preventDefault();

    const { name, payment } = getInputValues();

    clearInputs();

    let errors = getInputErrors(name, payment);
    if (errors.length > 0) {
        showErrors(errors);
        return
    };
});

closeModalButton.addEventListener("click", () => {
    closeErrors();
});