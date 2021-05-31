export function getInputErrors(companyName, payment) {
    let messages = []

    if (companyName === '' || companyName == null) {
        messages.push(' Insurance company name is required')
    } else if (companyName.match('^[A-Za-z]') == null) {
        messages.push(' Insurance company name must start with a letter')
    } else if (companyName.length < 3) {
        messages.push(' Insurance company name must be longer than 2 characters')
    };

    if (payment === '' || payment == null) {
        messages.push(' Monthly payment is required')
    };

    console.log(messages)
    return messages;
};