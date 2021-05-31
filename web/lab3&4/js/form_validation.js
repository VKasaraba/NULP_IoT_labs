export function getInputErrors (name, payment) {
    let messages = []

    if (name === '' || name == null) {
        messages.push(' Insurance company name is required')
    } 
    else if (name.match('^[A-Za-z]') == null) {
        messages.push(' Insurance company name must start with a letter')
    }

    else if (name.length < 3) {
        messages.push(' Insurance company name must be longer than 2 characters')
    };

    if (payment === '' || payment == null) {
        messages.push(' Monthly payment is required')
    };
    
    console.log(messages)
    return messages;
};