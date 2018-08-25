// READ TODO RAW JS to learn more on this method!
let newUser;
let newPendingReqs;
let newResolvedReqs;
window.onload = function foo() {

    if (document.getElementById('content')) {
    }
    else if (document.getElementById('talos')) {
        document.getElementById('talos').addEventListener('click', loadPage);
    } else {
        loadPage();
    }
}

function loadPage() {
    let navbar = document.getElementById('loaded-content');
    fetch('pages/start.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
        document.getElementById('talos').addEventListener('click', loginPage);

    });
}

function loginPage() {
    
    
    let navbar = document.getElementById('loaded-content');
    fetch('pages/login.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
        document.getElementById('return').addEventListener('click', loadPage);
        document.getElementById('login').addEventListener('click', login);

    });

    
}


