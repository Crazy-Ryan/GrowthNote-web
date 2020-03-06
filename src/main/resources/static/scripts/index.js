let usernameEl = document.getElementsByClassName("username-input")[0];
let passwordEl = document.getElementsByClassName("password-input")[0];
let usernameInput;
let passwordInput;
let inputCorrect = false;

function onSubmitClick() {
    usernameInput = usernameEl.value;
    passwordInput = passwordEl.value;
    validateUserCredential(usernameInput,passwordInput);
}

function validateUserCredential(username, password) {

    retrieveCredentialInfo(username, password);
    function retrieveCredentialInfo(username, password) {
        let getAJAXJsonOption = {
            url: 'http://localhost:8080/api/users?name=' + username + '&password=' + password,
            method: 'GET',
            success: function (responseText) {
                console.log(responseText);
                inputCorrect = isCorrect(responseText);
            },
            fail: function (error) {
                console.log('get data error');
            }
        };
        ajaxJsonHandle(getAJAXJsonOption);
    }

}

function isCorrect(userInfo) {
    return null != userInfo.id;
}