let url = "http://localhost:3000/register";
let relink = "http://localhost:3000/home";
document.getElementById("signup").addEventListener('click', newUser);

// var express = require("express");
// var router = express.router();
// var UserRegistration = require("../server-code/models").UserRegistration;

function newUser() {
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById('lastName').value;
    let username = document.getElementById('username').value;
    let email = document.getElementById('emailInput').value;
    let password = document.getElementById('password').value;

    let data = {
        "firstName": firstName,
        "lastName": lastName,
        "username": username,
        "emailAddress": email,
        "password": password
    }

    fetch(url, {
        method: 'POST',  // to post data to the db
        body: JSON.stringify(data),
        headers:{
            'Content-Type': 'application/json'
        }
    }).then(data => data.json()).then(u => {
        console.log(u);
        window.location.href = "/home"
    })

    
}