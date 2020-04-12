let inputCorrect = false;

function onSubmitClick() {
    let usernameInput = document.getElementsByClassName("username-input")[0].value;
    let passwordInput = document.getElementsByClassName("password-input")[0].value;
    validateUserCredential(usernameInput, passwordInput);
}

function validateUserCredential(username, password) {
    let getAJAXJsonOption = {
        url: 'http://localhost:8080/api/users?userName=' + username + '&password=' + password,
        method: 'GET',
        success: function (responseText) {
            if(isCorrect(responseText)){
                alert("登录成功");
                window.location.href="user-list.html";
            }
            else {
                alert("登录失败");            }
        },
        fail: function (error) {
            console.log('get data error');
        }
    };
    ajaxJsonHandle(getAJAXJsonOption);
}

function isCorrect(userInfo) {
    return null != userInfo.id;
}