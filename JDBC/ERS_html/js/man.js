function mMain() {
    newPage('../pages/manNavbar.html');
    document.getElementById("mainButton").onclick = manDialogue;
    document.getElementById("mainButton").hidden = true;
}

//Resolve Requests
function resolveRequests() {
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Ok give me a second to gather the requests";
    newPage('../pages/manPages/resolveRequests.html');
    document.getElementById("page").addEventListener("mousemove", resReq);
}
function resReq() {
    document.getElementById("page").removeEventListener("mousemove", resReq);
    for (var i = 0; i < requestArray.length; i++) {

        if (requestArray[i].status != "pending") {
            continue;
        }

        var sel = document.createElement("select");
        sel.id = "AppDec";
        sel.name = "appDecSelect";
        var op1 = document.createElement("option");
        op1.value = "1";
        op1.innerText = "Neither";
        sel.appendChild(op1);
        var op2 = document.createElement("option");
        op2.value = "2";
        op2.innerText = "Accept";
        sel.appendChild(op2);
        var op3 = document.createElement("option");
        op3.value = "3";
        op3.innerText = "Decline";
        sel.appendChild(op3);
        document.getElementById("resReq").appendChild(sel);

        var rei = document.createElement("h1");
        rei.innerText = "ID: " + requestArray[i].id + "\nManager: " + requestArray[i].mid +
            "\nAmount: $" + requestArray[i].amt + "\nDescription: " + requestArray[i].desc + "\nTime: " +
            requestArray[i].time + "\nType: " + requestArray[i].type + "\nStatus: " + requestArray[i].status;
        document.getElementById("resReq").appendChild(rei);
        var rei = document.createElement("br");
        document.getElementById("resReq").appendChild(rei);
    }
}
function resolve() {
    var selects = document.getElementsByName("appDecSelect");
    for (var i = 0; i < selects.length; i++) {
        switch (selects[i].value) {
            case "2":
                requestArray[i].status = "Accepted";
                break;
            case "3":
                requestArray[i].status = "Declined";
                break;
        }
        requestArray[i].mid = current.fname;
                                                //CALL UPDATE REQUEST SERVLET
    }
    document.getElementById("addDecButton").disabled = true;
    document.getElementById("addDecButton").innerText = "<<<";
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Alright I'll inform the members who made these requests.";
    mMain();
}


//View Pending requests
function manViewPend() {
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Ok give me a second to gather the requests";
    newPage('../pages/manPages/viewPending.html');
    document.getElementById("page").addEventListener("mousemove", manViewPendingRequests);
}
function manViewPendingRequests() {
    document.getElementById("page").removeEventListener("mousemove", manViewPendingRequests);

    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Here is a list of all the pending requests";

    for (var i = 0; i < requestArray.length; i++) {
        if (requestArray[i].status != "pending") {
            continue;
        }
        var rei = document.createElement("li");
        var t = document.createTextNode("ID: " + requestArray[i].id + "Manager: " + requestArray[i].mid +
            "\nAmount: $" + requestArray[i].amt + "\nDescription: " + requestArray[i].desc + "\nTime: " +
            requestArray[i].time + "\nType: " + requestArray[i].type + "\nStatus: " + requestArray[i].status);
        rei.appendChild(t);
        document.getElementById("manPendingRequests").appendChild(rei);
        var rei = document.createElement("br");
        document.getElementById("manPendingRequests").appendChild(rei);
    }

    document.getElementById("mainButton").innerText = "Menu";
    document.getElementById("mainButton").onclick = mMain;
    document.getElementById("mainButton").hidden = false;
}

//View a member's requests
function viewMemReq() {
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Ok, and who's requests would you like to see?";
    newPage('../pages/manPages/viewMemRequests.html');
    document.getElementById("page").addEventListener("mousemove", memList);
}
function memList() {
    document.getElementById("page").removeEventListener("mousemove", memList);
    var sel = document.createElement("select");
    sel.id = "AppDec";
    sel.name = "appDecSelect";
    for (var i = 0; i < users.length; i++) {
        var op = document.createElement("option");
        op.value = i;
        op.innerText = users[i].fname + " " + users[i].lname;
        sel.appendChild(op);
    }
    document.getElementById("viewMemReq").appendChild(sel);
}
function memRequests(){
    document.getElementById("AppDec").hidden = true;
    document.getElementById("memReqBtn").hidden = true;
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Here are the requests from that member";

    for (var i = 0; i < requestArray.length; i++) {
        var rei = document.createElement("li");
        var t = document.createTextNode("ID: " + requestArray[i].id + "Manager: " + requestArray[i].mid +
            "\nAmount: $" + requestArray[i].amt + "\nDescription: " + requestArray[i].desc + "\nTime: " +
            requestArray[i].time + "\nType: " + requestArray[i].type + "\nStatus: " + requestArray[i].status);
        rei.appendChild(t);
        document.getElementById("viewMemReq").appendChild(rei);
        var rei = document.createElement("br");
        document.getElementById("viewMemReq").appendChild(rei);
    }

    document.getElementById("mainButton").innerText = "Menu";
    document.getElementById("mainButton").onclick = mMain;
    document.getElementById("mainButton").hidden = false;
}




//View Resolved requests
function manViewRes() {
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Ok give me a second to gather the resolved requests";
    newPage('../pages/manPages/viewResolved.html');
    document.getElementById("page").addEventListener("mousemove", manViewResolvedRequests);
}
function manViewResolvedRequests() {
    document.getElementById("page").removeEventListener("mousemove", manViewResolvedRequests);

    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Here is a list of all your resolved requests";

    for (var i = 0; i < requestArray.length; i++) {
        if (requestArray[i].status == "pending") {
            continue;
        }
        var rei = document.createElement("li");
        var t = document.createTextNode("ID: " + requestArray[i].id + "\nManager: " + requestArray[i].mid +
            "\nAmount: $" + requestArray[i].amt + "\nDescription: " + requestArray[i].desc + "\nTime: " +
            requestArray[i].time + "\nType: " + requestArray[i].type + "\nStatus: " + requestArray[i].status);
        rei.appendChild(t);
        document.getElementById("manResolvedRequests").appendChild(rei);
        var rei = document.createElement("br");
        document.getElementById("manResolvedRequests").appendChild(rei);
    }

    document.getElementById("mainButton").innerText = "Menu";
    document.getElementById("mainButton").onclick = mMain;
    document.getElementById("mainButton").hidden = false;
}

//View Members
function viewMembers() {
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Ok give me a second to get the list of members";
    newPage('../pages/manPages/viewMembers.html');
    document.getElementById("page").addEventListener("mousemove", viewMem);
}
function viewMem() {
    document.getElementById("page").removeEventListener("mousemove", viewMem);

    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Here is a list of all the members";

    for (var i = 0; i < users.length; i++) {
        var rei = document.createElement("li");
        var t = document.createTextNode("ID: " + users[i].id + "\nName: " + users[i].fname + " " + users[i].lname + "\nEmail: " + users[i].email);
        rei.appendChild(t);
        document.getElementById("viewMembers").appendChild(rei);
        var rei = document.createElement("br");
        document.getElementById("viewMembers").appendChild(rei);
    }
    document.getElementById("mainButton").innerText = "Menu";
    document.getElementById("mainButton").onclick = mMain;
    document.getElementById("mainButton").hidden = false;
}


function manDialogue() {

}