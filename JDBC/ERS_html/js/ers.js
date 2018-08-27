// Global variables 
var mainButtonNum = 0;
var trollCheck = 0;
var troub = false;
var isManager;
var current = {};
var cReArray = {};
var resolving = [];
var users = {};
// music
var title = new Audio('../audio/town.wav');
title.volume = 0.8;
title.loop = true;

//home page music
window.onload = function music() {
    document.getElementById("page").src = "../pages/blank.html";
    title.play();
}

// isManager determines the navbar that will be used after logging in
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

//the given email and password passed to a servlet as login credentials.
//isManager is passed to the servlet to determine what reimbursement requests should be returned.
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
    }).then(data => {   //If servlet connection works....
        current = data  //assign user with the reimbursement requests to the global variable
        logged();
    }).catch((err) => {   //If servlet connection fails....
        document.getElementById("face").src = "../images/uh.png";
        document.getElementById("text").innerText = "Something went wrong with the system. I couldnt check our records.";
        document.getElementById("loginButton").hidden = false;
        console.error(err)
    });
}

// after a successful connection
function logged() {
    if (current != null) {  //if no matches were found in the DB, servlet returned null. if this is NOT the case....
        cReArray = current.userRes;  //put reimbursements into a seperate variable for easier usage later
        console.log(current);
        console.log(cReArray);
        newPage('../pages/blank.html');
        document.getElementById("face").src = "../images/smile.png";
        document.getElementById("text").innerText = "Ah there you are. How may I help you?";
        if (isManager == 1) {   //If the user is a manager...
            mMain();  //load manager navbar (man.js)
        } else {       //if not....
            uMain();    //load employee navbar (emp.js)
        }
        return;
    }
    //If servlet did return null.... (failed login)
    document.getElementById("face").src = "../images/confused.png";
    document.getElementById("text").innerText = "I cant seem to find you in our records. Try again, probably just a typo";
    document.getElementById("loginButton").hidden = false;
}

//logout
function logout() {
    current = {};   //clear user data
    cReArray = {};
    newPage('../pages/blank.html');
    document.getElementById("face").src = "../images/smile.png";
    document.getElementById("text").innerText = "All good? pleasure to be of service to you";
    mainButtonNum = 4;
    document.getElementById("mainButton").onclick = dia;
    document.getElementById("mainButton").innerText = "Continue";
    document.getElementById("mainButton").hidden = false;
}

//function called to change the contents of the interaction box
function newPage(pageString) {
    let newPage = document.getElementById('page');
    fetch(pageString).then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        newPage.innerHTML = text;
    })
}

//dialogue function
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