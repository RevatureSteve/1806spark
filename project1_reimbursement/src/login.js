var loginUrl = 'http://localhost:8080/reimbursements_project/login';
window.onload = function () {
    document.getElementById('loginBtn').addEventListener('click', login);
}

function login() {
    let email = document.getElementById('email').value;
    let pw = document.getElementById('psw').value;

    let data = {
        "email": email,
        "password": pw
    }

    console.log(data);

    fetch(loginUrl, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(data => data.json()).then(q => {
        console.log('post');

    });
}