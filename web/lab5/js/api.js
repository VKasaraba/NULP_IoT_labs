const BASE_URL = "http://localhost:8080";
const RESOURSE_URL = `${BASE_URL}/healthinsurance`;


const baseRequest = async({ urlPath = "", method = "GET", body = null }) => {
    try {
        const reqParams = {
            method,
            headers: {
                "Content-Type": "application/json",
            },
        };
        if (body) {
            reqParams.body = JSON.stringify(body);
        }

        return await fetch(`${RESOURSE_URL}${urlPath}`, reqParams);
    } catch (error) {
        console.error("HTTP ERROR: ", error);
    }
};

export const getAllInsurances = async () => {
    const rawResponse = await baseRequest({ method: "GET" });

    return await rawResponse.json();
};

export const postInsurance = (body) => baseRequest({ method: "POST", body });

export const deleteInsurance = (id) => baseRequest({urlPath:`/${id}`, method: "DELETE"});

export const editInsurance = (id, body) => baseRequest({urlPath:`/${id}`, method: "PUT", body});