window.onload = function music() {  //home page music
    document.getElementById("page").src = "../pages/blank.html";
    var title = new Audio('../audio/town.wav');
    title.volume = 0.8;
    title.loop = true;
    title.play();
}

var mainButtonNum = 0;
var isManager;
var current = {};

var users = [{ id: 1, rid: 2, fname: "Touvan", lname: "Louihao", email: "t@gmail.com", pass: "pas" },
{ id: 2, rid: 2, fname: "Deson", lname: "Louihao", email: "d@gmail.com", pass: "pass" },
{ id: 3, rid: 1, fname: "Ichiyou", lname: "Mochizuki", email: "i@gmail.com", pass: "passs" }];

var requestArray = [{ id: 1, mid: "none", amt: 100, desc: "oran berries", time: "8/18/2018", type: "2", status: "pending" },
{ id: 2, mid: "none", amt: 50, desc: "apple for azuril", time: "8/14/2018", type: "2", status: "pending" },
{ id: 3, mid: "none", amt: 675, desc: "overnight stay at Medicahm's guild", time: "8/11/2018", type: "3", status: "pending" },
{ id: 4, mid: "none", amt: 3000, desc: "bag stollen by outlaw", time: "8/16/2018", type: "5", status: "pending" },
{ id: 5, mid: "none", amt: 1300, desc: "Lapras ride accross the ocean", time: "8/10/2018", type: "1", status: "pending" }];

function isLeader() {
    document.getElementById("mainButton").hidden = true;
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "First things first. Are you a guild leader?";
    newPage('../pages/yesNo.html');
}

function yes() {
    /* window.history.pushState("object or string", "Title", "/manager");*/
    isManager = 1;
    document.getElementById("face").src = "../images/aw.png";
    document.getElementById("text").innerText = "Oh my! Well it truly is a pleasure to meet you! lets get you logged in";
    newPage('../pages/login.html');
}

function no() {
    /* window.history.pushState("object or string", "Title", "/employee");*/
    isManager = 2;
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Alright then lets get you logged in";
    newPage('../pages/login.html');
}

function login() {
    var e = document.getElementById("ebox").value;
    var p = document.getElementById("pbox").value;
    for (var i = 0; i < users.length; i++) {
        if (e == users[i].email && p == users[i].pass && users[i].rid == isManager) {
            current = users[i];
            newPage('../pages/blank.html');
            document.getElementById("face").src = "../images/smile.png";
            document.getElementById("text").innerText = "Ah there you are. How may I help you?";
            if (isManager) {
                mMain();
            } else {
                uMain();
            }
            return;
        }
    }
    document.getElementById("face").src = "../images/confused.png";
    document.getElementById("text").innerText = "I cant seem to find you in our records. Try again, probably just a typo";
}

//logout
function logout() {
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
        //console.log(resp);
        nav = resp;
        return resp.text(); // getting html not json!
    }).then((text) => {
        //console.log(text);
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
            console.log("test1");



            

            fetch('http://localhost:8080/ERS/login?email=t@gmail.com&password=pass&pos_id=2')
            .then((response) => {
                console.log("test2");
                console.log(response.json()); // getting html not json!
                return response.json();
            }).then(data => {
                    re = data
                    console.log("test3");
                    console.log(re);
                })
                .catch((err) => console.error(err));





            console.log("test4");
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