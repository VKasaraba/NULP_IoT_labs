import {
    deleteInsurance,
    getAllInsurances,
} from "./api.js";

const companyNameInput = document.getElementById("company__input");
const monthlyPaymentInput = document.getElementById("payment__input");
const compensationInput = document.getElementById("compensation__input");
const customerNameInput = document.getElementById("customer__input");
const durationInput = document.getElementById("duration__input");
const immunityInput = document.getElementById("immunity__input");
const itemsContainer = document.getElementById("items__container");
const countContainer = document.getElementById("count__total");
const modalContainer = document.getElementById("modal");


const getItemId = (id) => `item-${id}`;

const itemTemplate = ({ id, customerMonthlyPaymentInUAH, insuranceCompensationInUAH, insuranceCompanyName, customerName, insuranceDurationInYears, customerImmunityToDiseases}) => `
<ul id="items_container" class="items_container">
<li id="${getItemId(id)}" class="item">
    <img class="insurance__img"
        src="https://storage.dtkt.ua/files/%D0%90%D0%BD%D0%B3%D0%BB%D1%96%D0%B9%D1%81%D1%8C%D0%BA%D0%B055.jpg"
        class="item-container__image card-img-top" alt="card">
    <div class="card-body">
        <h5 class="card-title">Company name: ${insuranceCompanyName}</h5>
        <p class="card-text">Monthly payment is UAH: ${customerMonthlyPaymentInUAH} <br>Compensation is UAH: ${insuranceCompensationInUAH} <br>Customer's Name: 
        ${customerName} <br>Insurance duration in years:  ${insuranceDurationInYears}<br> Customer's immunity level: ${customerImmunityToDiseases}</p>
    </div>
    <div>
        <button class="delete__item__button" id="delete__button__${id}">Delete</button>
        <button class="edit__item__button" id="edit__button__${id}">Edit</button>
    <div>
</li>
</ul>`;

const countTemplate = (total) => `
Total expences: ${total}
`;


const errorsTemplate = (errors) => `
<div class="modal-bg">
    <div class="modal-message">
        <span id="modal_close" class="modal-close">X</span>
        <h2>Oh no!</h2> 
        <p>${errors}<p>
    </div>
</div>
`;


export const clearInputs = () => {
    companyNameInput.value= "";
    monthlyPaymentInput.value= "";
    compensationInput.value= "";
    customerNameInput.value= "";
    durationInput.value= "";
    immunityInput.value= "";
};

export const addItemToPage = ({ id, customerMonthlyPaymentInUAH, insuranceCompensationInUAH, insuranceCompanyName, customerName, insuranceDurationInYears, customerImmunityToDiseases, type }) => {
    itemsContainer.insertAdjacentHTML(
        "afterbegin",
        itemTemplate({ id, customerMonthlyPaymentInUAH, insuranceCompensationInUAH, insuranceCompanyName, customerName, insuranceDurationInYears, customerImmunityToDiseases, type })
    );
    const deleteButton = document.getElementById("delete__button__" + id);
    const editButton = document.getElementById("edit__button__" + id);
    editButton.addEventListener("click", () => {
        window.open("./edit_page.html?id=" + id, "_self")
    });
    deleteButton.addEventListener("click", () => {
        // deleteInsurance(id);
        // setTimeout(() => { refetchAllInsurances(); }, 500);
        new Promise((resolve, reject) => {
            let status = deleteInsurance(id);
            resolve(status);
        })
        .then(refetchAllInsurances)
        .catch(err => console.log("Error: " + err));
    });
};

export const countTotal = (total) => {
    countContainer.textContent = ""
    countContainer.insertAdjacentHTML(
        "afterbegin",
        countTemplate(total)
    );
};


export const showErrors = (errors) => {
    modalContainer.textContent = ""
    modalContainer.insertAdjacentHTML(
        "afterbegin",
        errorsTemplate(errors)
    );
};

export const closeErrors = () => {
    modalContainer.textContent = ""
};


export const renderItemsList = (items) => {
    itemsContainer.innerHTML = "";
    for (const item of items) {
        addItemToPage(item);
    }
};

export const getInputValues = () => {
    return {
        companyName: companyNameInput.value,
        payment: monthlyPaymentInput.value,
        compensation: compensationInput.value,
        customerName: customerNameInput.value,
        duration: durationInput.value,
        immunity: immunityInput.value,
    };
};

export const getEditInputValues = () => {
    return {
        companyName: companyNameInput.value,
        payment: monthlyPaymentInput.value,
        compensation: compensationInput.value,
        customerName: customerNameInput.value,
        duration: durationInput.value,
        immunity: immunityInput.value,
    };
};

export function showForm(form) {
    if (form.style.display === 'none') {
        form.style.display = 'block'
    } else {
        form.style.display = 'none'
    }
};

export const refetchAllInsurances = async() => {
    const allInsurances = await getAllInsurances();
    renderItemsList(allInsurances);
};