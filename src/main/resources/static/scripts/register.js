function onRegisterClick() {
    let usernameInput = document.getElementsByClassName("username-input")[0].value;
    let passwordInput = document.getElementsByClassName("password-input")[0].value;
    registerWithCredential(usernameInput, passwordInput);
}

function registerWithCredential(username, password) {

    let getAJAXJsonOption = {
        url: 'http://localhost:8080/api/users',
        method: 'POST',
        data: {
            "name": username,
            "password": password
        },
        success: function (responseText) {
            console.log(responseText);
            alert("注册成功");
        },
        fail: function (error) {
            console.log('get data error');
        }
    };
    ajaxJsonHandle(getAJAXJsonOption);
}