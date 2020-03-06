getUsers();

function getUsers() {
    let getAJAXJsonOption = {
        url: 'http://localhost:8080/api/users/all',
        method: 'GET',
        success: function (responseText) {
            console.log(responseText);
        },
        fail: function (error) {
            console.log('get data error');
        }
    };
    ajaxJsonHandle(getAJAXJsonOption);
}