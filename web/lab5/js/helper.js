import {
    getAllInsurances,
} from "./api.js";

import {
    renderItemsList,
} from "./dom_util.js";

export const refetchAllInsurances = async() => {
    const allInsurances = await getAllInsurances();
    renderItemsList(allInsurances);
};