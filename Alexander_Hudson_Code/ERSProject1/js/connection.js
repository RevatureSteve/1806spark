function getLogin(){

    let email;
    let password;
    email = document.getElementById('Email').value;
    password = document.getElementById('Password').value;

    let data = {"email" : email, "password" : password};
fetch ('http://localhost:8080/RickAndMorty/login?email='+ email +'&password='+ password, {
    method: 'GET',
    headers: {'Content-Type' : 'application/json'}
}).then (resp => {
    return resp.json();
}).then(data => {
    newUser = data;
    console.log(newUser);
}).catch(err => {
        alert('Invalid login');
        console.log('[LOG]-------------' + err);
});

}