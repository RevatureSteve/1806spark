//load employee navbar
function uMain() {
    document.getElementById("mainButton").onclick = empDialogue;
    document.getElementById("mainButton").hidden = true;
    newPage('../pages/empNavbar.html');
}

//Make a new Request
function makeRequest() {
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Ok, just fill out this form and I'll put it in our system";
    newPage('../pages/empPages/makeRequest.html');
}

function NewReqSubmit() {
    var a = parseInt(document.getElementById("amount").value);
    var t = parseInt(document.getElementById("type").value);
    var d = document.getElementById("description").value;

    if (trollCheck >= 3) {  //check if the user is causing too much trouble
        title.pause();    //stop the music
        title.currentTime = 0;
        if (troub){     //If this isnt the first time...
            mainButtonNum = 7;
            empDialogue();
            return;
        }
        newPage('../pages/blank.html');
        document.getElementById("face").src = "../images/mad.png";
        document.getElementById("text").innerText = "Ok, thats enough.";
        mainButtonNum = 4;
        troub = true;
        document.getElementById("mainButton").hidden = false;
        return;
    }

    //check if the amount given is valid 1-9999
    if (a == 0) {
        console.log("0");
        document.getElementById("face").src = "../images/confused.png";
        document.getElementById("text").innerText = "Uhhh...I can't submit a request without an amount. That kinda defeats the purpose of a reimbursement";
        trollCheck += 1;
        return;
    } else if (a >= 10000) {
        console.log("1000000");
        document.getElementById("newRequestSubmit").disabled = true;
        document.getElementById("newRequestSubmit").innerText = "<<<";
        document.getElementById("face").src = "../images/initial_shock.png";
        document.getElementById("text").innerText = "Ehh!?! thats so much money!";
        mainButtonNum = 0;
        document.getElementById("mainButton").hidden = false;
        trollCheck += 1;
        return;
    } else if (isNaN(a)) {
        console.log("nan");
        document.getElementById("face").src = "../images/confused.png";
        document.getElementById("text").innerText = "I uh, dont understand that. The amount needs to be a number";
        trollCheck += 1;
        return;
    } else if (a < 0) {
        console.log("negative");
        document.getElementById("newRequestSubmit").disabled = true;
        document.getElementById("newRequestSubmit").innerText = "<<<";
        document.getElementById("face").src = "../images/initial_shock.png";
        document.getElementById("text").innerText = "A request to...give us money?";
        mainButtonNum = 3;
        document.getElementById("mainButton").hidden = false;
        trollCheck += 1;
        return;
    }

    //If the amount given is valid, create the request in the DB
    request = {
        "userId": current.uId,
        "amount": a,
        "description": d,
        "type": t
    }
    fetch('http://localhost:8080/ERS/makeRe', {
        method: 'POST',
        body: JSON.stringify(request),
        headers: { 'Content-Type': 'application/json' }
    }).then(response => {
        rjson = response.json();
        return rjson;
    }).then(data => {
        console.log(data);
        if (document.getElementById("description").value == "") {   //If no description is given :/
            document.getElementById("face").src = "../images/confused.png";
            document.getElementById("text").innerText = "for...no reason? Well if you say so but I wouldn't get your hopes up";
            troub = false;
            updateRequests();
            return;
        }
        document.getElementById("face").src = "../images/neutral_smile.png";
        document.getElementById("text").innerText = "Ok your request has been added. Ill go file it quick";
        newPage('../pages/blank.html');
        updateRequests();
    }).catch((err) => {
        document.getElementById("face").src = "../images/uh.png";
        document.getElementById("text").innerText = "Something went wrong with the system. I couldnt check our records.";
        document.getElementById("loginButton").hidden = false;
        console.error(err)
    });
}

//Update the array of requests
function updateRequests() {
    fetch('http://localhost:8080/ERS/getReById?userId=' + current.uId, {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
    }).then(response => {
        rjson = response.json();
        return rjson;
    }).then(data => {
        cReArray = data;
        uMain();
    }).catch((err) => {
        document.getElementById("face").src = "../images/uh.png";
        document.getElementById("text").innerText = "Something went wrong with the system. I couldnt check our records.";
        document.getElementById("loginButton").hidden = false;
        console.error(err)
    });
}


//View Pending Requests
function viewPend() {
    newPage('../pages/list.html');
    document.getElementById("page").addEventListener("mouseover", viewPendingRequests);
}
function viewPendingRequests() {
    document.getElementById("page").removeEventListener("mouseover", viewPendingRequests);
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Here is a list of all your pending requests";

    //populate the list
    for (var i = 0; i < cReArray.length; i++) {
        if (cReArray[i].status != "Pending") {
            continue;
        }
        var rei = document.createElement("li");
        var t = document.createTextNode("Amount: $" + cReArray[i].amt);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Description: " + cReArray[i].desc);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Time: " + cReArray[i].time);  //looots of population
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Type: " + cReArray[i].type);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Status: " + cReArray[i].status);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);

        var rei = document.createElement("br");
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("br");
        document.getElementById("list").appendChild(rei);
    }

    document.getElementById("mainButton").innerText = "Menu";
    document.getElementById("mainButton").onclick = uMain;
    document.getElementById("mainButton").hidden = false;
}


//View resolved
function viewRes() {
    newPage('../pages/list.html');
    document.getElementById("page").addEventListener("mouseover", viewResolvedRequests);
}
function viewResolvedRequests() {
    document.getElementById("page").removeEventListener("mouseover", viewResolvedRequests);

    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Here is a list of all your resolved requests";

    //more population
    for (var i = 0; i < cReArray.length; i++) {
        if (cReArray[i].status == "Pending") {
            continue;
        }
        var rei = document.createElement("li");
        var t = document.createTextNode("Amount: $" + cReArray[i].amt);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Description: " + cReArray[i].desc);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Time: " + cReArray[i].time);   //For some reason /n doesnt work when
        rei.appendChild(t);                                             //making one big li element so I do this
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Type: " + cReArray[i].type);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Status: " + cReArray[i].status);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);

        var rei = document.createElement("br");
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("br");
        document.getElementById("list").appendChild(rei);
    }

    document.getElementById("mainButton").innerText = "Menu";
    document.getElementById("mainButton").onclick = uMain;
    document.getElementById("mainButton").hidden = false;
}


//view profile
function viewProfile() {
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Here you are. Your profile";
    newPage('../pages/empPages/viewProfile.html');
    document.getElementById("page").addEventListener("mouseover", viewProf);
}
function viewProf() {
    document.getElementById("page").removeEventListener("mouseover", viewProf);
    document.getElementById("uid").innerText = "ID: " + current.uId;
    document.getElementById("name").innerText = current.fname + " " + current.lname;
    document.getElementById("email").innerText = "Email: " + current.email;
    document.getElementById("mainButton").innerText = "Menu";
    document.getElementById("mainButton").onclick = uMain;
    document.getElementById("mainButton").hidden = false;
}


//Edit Profile
function editProfile() {
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Are our records out of date? please fix what you need";
    newPage('../pages/empPages/editProfile.html');
    document.getElementById("page").addEventListener("mouseover", populate);
}
function populate() {
    document.getElementById("page").removeEventListener("mouseover", populate);
    document.getElementById("first").value = current.fname; //set the default values to the current user information
    document.getElementById("last").value = current.lname;
    document.getElementById("mail").value = current.email;
}
function submitProfile() {

    current.fname = document.getElementById("first").value;
    current.lname = document.getElementById("last").value;
    current.email = document.getElementById("mail").value;

    request = {
        "userId": current.uId,
        "email": current.email,
        "firstName": current.fname,
        "lastName": current.lname
    }

    fetch('http://localhost:8080/ERS/editProfile', {
        method: 'POST',
        body: JSON.stringify(request),
        headers: { 'Content-Type': 'application/json' }
    }).catch((err) => {
        document.getElementById("face").src = "../images/uh.png";
        document.getElementById("text").innerText = "Something went wrong with the system. I couldnt check our records.";
        document.getElementById("loginButton").hidden = false;
        console.error(err)
    });

    document.getElementById("face").src = "../images/relief.png";
    document.getElementById("text").innerText = "Glad thats up to date. Sorry about that false information";
    uMain();
}

// Employee side Dialogue
function empDialogue() {
    switch (mainButtonNum) {
        case 0:     //when you try to make a request with $10,000+  part 1
            document.getElementById("face").src = "../images/uh.png";
            document.getElementById("text").innerText = "Yeah theres no way thats going to get accepted, sorry.";
            break;
        case 1:     //part 2
            document.getElementById("mainButton").hidden = true;
            document.getElementById("text").innerText = "At least try to keep it bellow $10,000";
            document.getElementById("newRequestSubmit").disabled = false;
            document.getElementById("newRequestSubmit").innerText = "Submit";
            break;
        case 2:     //this isn't used now but I kept it for testing purposes 
            viewPendingRequests();
            break;
        case 3:     //request with a negative amount
            document.getElementById("mainButton").hidden = true;
            document.getElementById("face").src = "../images/uh.png";
            document.getElementById("text").innerText = "Yeah uhhhh, thats not quite how this works. Possitve numbers please.";
            document.getElementById("newRequestSubmit").disabled = false;
            document.getElementById("newRequestSubmit").innerText = "Submit";
            break;
        case 4:     //part 2 of the user causing too much trouble (part 1 being line 30)
            document.getElementById("text").innerText = "What exactly are you trying to accomplish here?";
            break;
        case 5:     //part 3
            document.getElementById("face").src = "../images/confused.png";
            document.getElementById("text").innerText = "Not to question your intelligence or anything, but I'd like to think this is a rather simple system here";
            break;
        case 6:     //part 4 (asks if you will stop)
            document.getElementById("mainButton").hidden = true;
            document.getElementById("face").src = "../images/mad.png";
            document.getElementById("text").innerText = "But really though, there are other pokemon that are waiting so are you gonna stop causing trouble?";
            newPage('../pages/isTrouble.html');
            break;
        case 7:     //part 5 (if you continue to cause trouble)
            document.getElementById("mainButton").hidden = false;
            newPage('../pages/blank.html');
            document.getElementById("face").src = "../images/grudge.png";
            document.getElementById("text").innerText = "Oh really, Well then....";
            trollCheck = 0;
            break;
        case 8:     //part 6
            document.getElementById("face").src = "../images/lucario.png";
            document.getElementById("text").innerText = "Thats enough Riolu. I'll take it from here";
            break;
        case 9:     //part 7
            document.getElementById("face").src = "../images/mad.png";
            document.getElementById("text").innerText = "hmph";
            break;
        case 10:    //part 8
            document.getElementById("face").src = "../images/lucario.png";
            document.getElementById("text").innerText = current.lname + " You've done enough damage. Lets go";
            break;
        case 11:    //part 9
            document.getElementById("face").src = "../images/mad.png";
            document.getElementById("text").innerText = "...";
            break;
        case 12:    //part 10
            document.getElementById("face").src = "../images/relief.png";
            break;
        case 13:    //part 11 (loging out of previous user)
            document.getElementById("face").src = "../images/neutral_smile.png";
            document.getElementById("text").innerText = "Next in line, sorry you had to see that";
            title.play();
            mainButtonNum = 5;
            current = {};
            cReArray = {};
            document.getElementById("mainButton").onclick = dia;
            break;
    }
    mainButtonNum++;
}

//If you chose to stop causing trouble
function noTrouble() {
    title.play();
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Ok good. Please give a possitive number between 1 and 9999 this time.";
    mainButtonNum = 7;
    newPage('../pages/empPages/makeRequest.html');
}