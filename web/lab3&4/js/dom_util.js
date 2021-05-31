const companyNameInput = document.getElementById("company__input");
const monthlyPaymentInput = document.getElementById("payment__input");
const editCompanyNameInput = document.getElementById("edit__company__input");
const editMonthlyPaymentInput = document.getElementById("edit__payment__input");
const itemsContainer = document.getElementById("items__container");
const countContainer = document.getElementById("count__total");
const modalContainer = document.getElementById("modal")


const getItemId = (id) => `item-${id}`;

const itemTemplate = ({ id, name, payment }) => `
<ul id="items_container" class="items_container">
<li id="${getItemId(id)}" class="item">
    <img class="insurance__img"
        src="https://storage.dtkt.ua/files/%D0%90%D0%BD%D0%B3%D0%BB%D1%96%D0%B9%D1%81%D1%8C%D0%BA%D0%B055.jpg"
        class="item-container__image card-img-top" alt="card">
    <div class="card-body">
        <h5 class="card-title">${name}</h5>
        <p class="card-text">${payment}</p>
    </div>
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
    companyNameInput.value = "";

    monthlyPaymentInput.value = "";
};

export const addItemToPage = ({ id, name, payment }) => {
    itemsContainer.insertAdjacentHTML(
    "afterbegin",
    itemTemplate({ id, name, payment })
);
};

export const countTotal = (total) => {
    countContainer.textContent =""
    countContainer.insertAdjacentHTML(
    "afterbegin",
    countTemplate(total)
);
};


export const showErrors = (errors) => {
    modalContainer.textContent =""
    modalContainer.insertAdjacentHTML(
    "afterbegin",
    errorsTemplate(errors)
);
};

export const closeErrors = () => {
    modalContainer.textContent =""
};


export const renderItemsList = (items) => {
    itemsContainer.innerHTML = "";

        for (const item of items) {
        addItemToPage(item);
    }
};

export const getInputValues = () => {
    return {
        name: companyNameInput.value,
        payment: monthlyPaymentInput.value,
    };
};

export const getEditInputValues = () => {
    return {
        name: editCompanyNameInput.value,
        payment: editMonthlyPaymentInput.value,
    };
};

export function showForm (form) {
    if (form.style.display === 'none') {
        form.style.display = 'block'
    } else {
        form.style.display = 'none'
    }
};
