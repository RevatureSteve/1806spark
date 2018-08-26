var mainButtonNum = 0;
var trollCheck = 0;
var isManager;
var current = {};
var cReArray = {};
var resolving = [];
var users = {};


window.onload = function music() {  //home page music
    document.getElementById("page").src = "../pages/blank.html";
    var title = new Audio('../audio/town.wav');
    title.volume = 0.8;
    title.loop = true;
    title.play();
}

function isLeader() {
    document.getElementById("mainButton").hidden = true;
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "First things first. Are you a guild leader?";
    newPage('../pages/yesNo.html');
}

function yes() {
    isManager = 1;
    document.getElementById("face").src = "../images/aw.png";
    document.getElementById("text").innerText = "Oh my! Well it truly is a pleasure to meet you! lets get you logged in";
    newPage('../pages/login.html');
}

function no() {
    isManager = 2;
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Alright then lets get you logged in";
    newPage('../pages/login.html');
}

function login() {
    document.getElementById("loginButton").hidden = true;
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "One moment please...";
    data = {"email": document.getElementById("ebox").value, 
            "password": document.getElementById("pbox").value,
            "pos_id":isManager
    }

    fetch('http://localhost:8080/ERS/login', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: { 'Content-Type': 'application/json' }
    }).then(response => {
        rjson = response.json();
        return rjson;
    }).then(data => {
        current = data
        logged();
    }).catch((err) => {
        document.getElementById("face").src = "../images/uh.png";
        document.getElementById("text").innerText = "Something went wrong with the system. I couldnt check our records.";
        document.getElementById("loginButton").hidden = false;
        console.error(err)
    });
}

function logged() {
    if (current != null) {
        cReArray = current.userRes;
        console.log(current);
        console.log(cReArray);
        newPage('../pages/blank.html');
        document.getElementById("face").src = "../images/smile.png";
        document.getElementById("text").innerText = "Ah there you are. How may I help you?";
        if (isManager == 1) {
            mMain();
        } else {
            uMain();
        }
        return;
    }
    document.getElementById("face").src = "../images/confused.png";
    document.getElementById("text").innerText = "I cant seem to find you in our records. Try again, probably just a typo";
    document.getElementById("loginButton").hidden = false;
}

//logout
function logout() {
    current = {};
    cReArray = {};
    newPage('../pages/blank.html');
    document.getElementById("face").src = "../images/smile.png";
    document.getElementById("text").innerText = "All good? pleasure to be of service to you";
    mainButtonNum = 4;
    document.getElementById("mainButton").onclick = dia;
    document.getElementById("mainButton").innerText = "Continue";
    document.getElementById("mainButton").hidden = false;
}

function newPage(pageString) {
    let newPage = document.getElementById('page');
    fetch(pageString).then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        newPage.innerHTML = text;
    })
}
function newNav(pageString) {
    let newPage = document.getElementById('nav');
    fetch(pageString).then((resp) => {
        //console.log(resp);
        nav = resp;
        return resp.text(); // getting html not json!
    }).then((text) => {
        //console.log(text);
        newPage.innerHTML = text;
    })
}

function addElement(pageString) {
    let newPage = document.getElementById('nav');
    fetch(pageString).then((resp) => {
        //console.log(resp);
        nav = resp;
        return resp.text(); // getting html not json!
    }).then((text) => {
        //console.log(text);
        newPage.appendChild = text;
    })
}

function dia() {
    switch (mainButtonNum) {
        case 0:
            document.getElementById("mainButton").innerText = "Continue";
            document.getElementById("face").src = "../images/happy_smile.png";
            document.getElementById("text").innerText = "Welcome to Riolu's Reimbursements!";
            break;
        case 1:
            document.getElementById("face").src = "../images/neutral_smile.png";
            document.getElementById("text").innerText = "After a long adventure I'm sure you had to make some unwanted purchases.";
            break;
        case 2:
            document.getElementById("face").src = "../images/smile.png";
            document.getElementById("text").innerText = "We of the Lucario guild are happy to reimburse you on some of those purcahses.";
            break;
        case 3:
            document.getElementById("face").src = "../images/neutral_smile.png";
            document.getElementById("text").innerText = "Although a guild leader must accept the requests before you can get paid back.";
            document.getElementById("mainButton").onclick = isLeader;
            break;
        case 4:
            document.getElementById("face").src = "../images/happy_smile.png";
            document.getElementById("text").innerText = "Have a nice day!";
            break;
        case 5:
            document.getElementById("face").src = "../images/neutral_smile.png";
            document.getElementById("text").innerText = "Next in line please";
            break;
        case 6:
            document.getElementById("face").src = "../images/smile.png";
            document.getElementById("text").innerText = "Welcome to Riolu's Reimbursements!";
            document.getElementById("mainButton").onclick = isLeader;
    }
    ++mainButtonNum;
}