window.onload = function foo() {
    console.log('Loading login');

    login();

}

function login (){

    let navbar = document.getElementById('content');
    fetch('Pages/login.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
        document.getElementById('submit').addEventListener('click', getLogin);
    });
}

function empPage () {
console.log('loading empPage');
    let navbar = document.getElementById('content');
    fetch('Pages/empPage.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
        topBar();
    });
}

function topBar (){
    let navbar = document.getElementById('topBar');
    fetch('Pages/navBar.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
        document.getElementById('profile').addEventListener('click', profile);
        document.getElementById('viewReim').addEventListener('click', viewReim);
        document.getElementById('createReim').addEventListener('click', empPage);
        document.getElementById('logout').addEventListener('click', logout);
    });
}

function profile (){
    console.log('profile loaded');
    let navbar = document.getElementById('content');
    fetch('Pages/empProfile.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
    });
}

function viewReim (){
    console.log('View Reimbursement');
    let navbar = document.getElementById('content');
    fetch('Pages/empReim.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
    });
    
}

function logout (){
    console.log('logging out');
    let navbar = document.getElementById('content');
    fetch('Pages/login.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text; 
        logout2();
    });
    
}

function logout2 (){
    console.log('logging out');
    let navbar = document.getElementById('topBar');
    fetch('Pages/logout.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text; 
    });
    
}

