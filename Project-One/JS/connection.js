let email;
let password;

window.onload = function connect(){
    email = document.getElementById('loginBox').addEventListener('change');
    password = document.getElementById('passwordBox').addEventListener('change');
    document.getElementById('login').addEventListener('login', login);
}

function login(){
    var data = [{"email": email}, 
    {"password": password}];
  
 fetch('http://localhost:8080/my-app/login', {
     method: 'POST',
     body: JSON.stringify(data),
     headers: {'Content-Type': 'application/json'}
 }).then(response => { 
   return response.json(); 
 }).then(data => { 
   alert(JSON.stringify(data));
 }).catch(err => {
     alert(err);
 });
}
