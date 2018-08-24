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
    if (document.getElementById("amount").value == 0) {
        document.getElementById("face").src = "../images/confused.png";
        document.getElementById("text").innerText = "Uhhh...I can't submit a request without an amount. That kinda defeats the purpose of a reimbursement";
        return;
    } else if (document.getElementById("amount").value >= 10000) {
        document.getElementById("newRequestSubmit").disabled = true;
        document.getElementById("newRequestSubmit").innerText = "<<<";
        document.getElementById("face").src = "../images/initial_shock.png";
        document.getElementById("text").innerText = "Huh!?! thats so much money!";
        mainButtonNum = 0;
        document.getElementById("mainButton").hidden = false;
        return;
    }

    requestArray.push({id:requestArray.length+1, mid:"none", amt:document.getElementById("amount").value, 
    desc:document.getElementById("description").value, time:"8/21/2018", type:document.getElementById("type").value,
    status:"pending"});

    if (document.getElementById("description").value == "") {
        document.getElementById("face").src = "../images/confused.png";
        document.getElementById("text").innerText = "for...no reason? Well if you say so but I wouldnt get your hopes up";
        uMain();
        return;
    }
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Ok your request has been added. Once it's handled you should get an email";
    uMain();
}



//View Pending Requests
function viewPend() {
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Ok give me a second to gather your requests";
    newPage('../pages/empPages/viewPending.html');
    document.getElementById("page").addEventListener("mousemove", viewPendingRequests);
}
function viewPendingRequests() {
    document.getElementById("page").removeEventListener("mousemove", viewPendingRequests);

    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Here is a list of all your pending requests";

    for (var i = 0; i < requestArray.length; i++) {
        if(requestArray[i].status != "pending"){
            continue;
        }
        var rei = document.createElement("li");
        var t = document.createTextNode("ID: " + requestArray[i].id + "Manager: " + requestArray[i].mid +
            "\nAmount: $" + requestArray[i].amt + "\nDescription: " + requestArray[i].desc + "\nTime: " +
            requestArray[i].time + "\nType: " + requestArray[i].type + "\nStatus: " + requestArray[i].status);
        rei.appendChild(t);
        document.getElementById("pendingRequests").appendChild(rei);
        var rei = document.createElement("br");
        document.getElementById("pendingRequests").appendChild(rei);
    }

    document.getElementById("mainButton").innerText = "Menu";
    document.getElementById("mainButton").onclick = uMain;
    document.getElementById("mainButton").hidden = false;
}


//View resolved
function viewRes() {
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Ok give me a second to gather your resolved requests";
    newPage('../pages/empPages/viewResolved.html');
    document.getElementById("page").addEventListener("mousemove", viewResolvedRequests);
}
function viewResolvedRequests() {
    document.getElementById("page").removeEventListener("mousemove", viewResolvedRequests);

    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Here is a list of all your resolved requests";

    for (var i = 0; i < requestArray.length; i++) {
        if(requestArray[i].status == "pending"){
            continue;
        }
        var rei = document.createElement("li");
        var t = document.createTextNode("ID: " + requestArray[i].id + "\nManager: " + requestArray[i].mid +
            "\nAmount: $" + requestArray[i].amt + "\nDescription: " + requestArray[i].desc + "\nTime: " +
            requestArray[i].time + "\nType: " + requestArray[i].type + "\nStatus: " + requestArray[i].status);
        rei.appendChild(t);
        document.getElementById("resolvedRequests").appendChild(rei);
        var rei = document.createElement("br");
        document.getElementById("resolvedRequests").appendChild(rei);
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
    document.getElementById("page").addEventListener("mousemove", viewProf);
}
function viewProf() {
    document.getElementById("page").removeEventListener("mousemove", viewProf);
    document.getElementById("uid").innerText = "ID: " + current.id;
    document.getElementById("name").innerText = "Name: " + current.fname + " " + current.lname;
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
}
function submitProfile() {
    current.fname = document.getElementById("first").value;
    current.lname = document.getElementById("last").value;
    current.email = document.getElementById("mail").value;
    document.getElementById("face").src = "../images/relief.png";
    document.getElementById("text").innerText = "Glad thats up to date. Sorry about that false information";
    uMain();
}

// Side Dialogue
function empDialogue() {
    switch (mainButtonNum) {
        case 0:
            document.getElementById("face").src = "../images/uh.png";
            document.getElementById("text").innerText = "Yeah theres no way thats going to get accepted, sorry.";
            break;
        case 1:
            document.getElementById("mainButton").hidden = true;
            document.getElementById("text").innerText = "At least try to keep it bellow $10,000";
            document.getElementById("newRequestSubmit").disabled = false;
            document.getElementById("newRequestSubmit").innerText = "Submit";
            break;
        case 2:
            viewPendingRequests();
            break;
    }
    mainButtonNum++;
}