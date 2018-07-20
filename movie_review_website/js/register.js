var registerUrl = 'http://localhost:3000/register';
window.addEventListener("load", () => {
    document.getElementById('submitIn').onclick = registerRequest;
})

function registerRequest(){
    let username = document.getElementById("username").value;
    let password = document.getElementById("pwd1").value;
    let email = document.getElementById("email").value;

    let data = {
        "username": username,
        "password": password,
        "email": email
    }

    console.log(data);

    fetch(registerUrl, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(data => data.json()).then(q => {
        console.log('post');

    });
}