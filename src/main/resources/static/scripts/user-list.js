let contentEl = document.getElementsByClassName("user-list")[0];
let tableEl = document.getElementsByTagName("tbody")[0];
getUsers();

function getUsers() {
    let getAJAXJsonOption = {
        url: 'http://localhost:8080/api/users/all',
        method: 'GET',
        success: function (responseText) {
            console.log(responseText);
            renderUserList(responseText);
        },
        fail: function (error) {
            console.log('get data error');
        }
    };
    ajaxJsonHandle(getAJAXJsonOption);
}

function renderUserList(data) {
    data.forEach(user => {
        let rowEl = document.createElement('tr');
        rowEl.innerHTML = `            
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.password}</td>`;
        tableEl.appendChild(rowEl);
    });
}