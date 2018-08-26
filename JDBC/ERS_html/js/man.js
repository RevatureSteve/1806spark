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
    document.getElementById("page").addEventListener("mouseover", resReq);
}
function resReq() {
    document.getElementById("page").removeEventListener("mouseover", resReq);
    for (var i = 0; i < cReArray.length; i++) {

        if (cReArray[i].status != "Pending") {
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
        rei.innerText = "\nAmount: $" + cReArray[i].amt + "\nDescription: " + cReArray[i].desc + "\nTime: " +
            cReArray[i].time + "\nType: " + cReArray[i].type + "\nStatus: " + cReArray[i].status;
        document.getElementById("resReq").appendChild(rei);
        var rei = document.createElement("br");
        document.getElementById("resReq").appendChild(rei);
    }
}
function resolve() {
    var selects = document.getElementsByName("appDecSelect");
    for (var i = 0; i < selects.length; i++) {
        switch (parseInt(selects[i].value)) {
            case 1:
                continue;
            case 2:
                cReArray[i].status = "Accepted";
                break;
            case 3:
                cReArray[i].status = "Declined";
                break;

        }
        cReArray[i].mid = current.fname + " " + current.lanem;
        console.log(cReArray[i].rid);
        console.log(parseInt(selects[i].value));
        console.log(current.uId);

        fetch("http://localhost:8080/ERS/resolveRequests?requestId=" + cReArray[i].rid + "&statusId=" + parseInt(selects[i].value) + "&managerId=" + current.uId, {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' }
        }).catch((err) => {
            document.getElementById("face").src = "../images/uh.png";
            document.getElementById("text").innerText = "Something went wrong with the system. I couldnt check our records.";
            document.getElementById("loginButton").hidden = false;
            console.error(err)
        });
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
    newPage('../pages/list.html');
    document.getElementById("page").addEventListener("mouseover", manViewPendingRequests);
}
function manViewPendingRequests() {
    document.getElementById("page").removeEventListener("mouseover", manViewPendingRequests);

    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Here is a list of all the pending requests";

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
        var t = document.createTextNode("Time: " + cReArray[i].time);
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
    document.getElementById("mainButton").onclick = mMain;
    document.getElementById("mainButton").hidden = false;
}

//View a member's requests
function viewMemReq() {
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Give me a second to get the names of the users...";
    newPage('../pages/blank.html');
    fetch("http://localhost:8080/ERS/getUsers", {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
    }).then(response => {
        rjson = response.json();
        return rjson;
    }).then(data => {
        users = data;
        document.getElementById("text").innerText = "Ok, and who's requests would you like to see?";
        newPage('../pages/manPages/viewMemRequests.html');
        document.getElementById("page").addEventListener("mouseover", memList);
    }).catch((err) => {
        document.getElementById("face").src = "../images/uh.png";
        document.getElementById("text").innerText = "Something went wrong with the system. I couldnt check our records.";
        document.getElementById("loginButton").hidden = false;
        console.error(err)
    });

}
function memList() {
    document.getElementById("page").removeEventListener("mouseover", memList);
    var sel = document.createElement("select");
    sel.id = "AppDec";
    sel.name = "appDecSelect";
    for (var i = 0; i < users.length; i++) {
        var op = document.createElement("option");
        op.value = users[i].uId;
        op.innerText = users[i].fname + " " + users[i].lname;
        sel.appendChild(op);
    }
    document.getElementById("viewMemReq").appendChild(sel);
    document.getElementById("AppDec").hidden = false;
}
function memRequests() {
    var id = document.getElementById("AppDec").value;
    document.getElementById("AppDec").hidden = true;
    document.getElementById("memReqBtn").hidden = true;
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Here are the requests from that member";

    for (var i = 0; i < cReArray.length; i++) {
        if (cReArray[i].uId != id) { 
            continue;
        }
        var rei = document.createElement("li");
        var t = document.createTextNode("ID: " + cReArray[i].id);
        rei.appendChild(t);
        document.getElementById("viewMemReq").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Amount: $" + cReArray[i].amt);
        rei.appendChild(t);
        document.getElementById("viewMemReq").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Description: " + cReArray[i].desc);
        rei.appendChild(t);
        document.getElementById("viewMemReq").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Time: " + cReArray[i].time);
        rei.appendChild(t);
        document.getElementById("viewMemReq").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Type: " + cReArray[i].type);
        rei.appendChild(t);
        document.getElementById("viewMemReq").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Status: " + cReArray[i].status);
        rei.appendChild(t);
        document.getElementById("viewMemReq").appendChild(rei);

        var rei = document.createElement("br");
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
    newPage('../pages/list.html');
    document.getElementById("page").addEventListener("mouseover", manViewResolvedRequests);
}
function manViewResolvedRequests() {
    document.getElementById("page").removeEventListener("mouseover", manViewResolvedRequests);

    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Here is a list of all your resolved requests";

    for (var i = 0; i < cReArray.length; i++) {
        if (cReArray[i].status == "Pending") {
            continue;
        }
        var rei = document.createElement("li");
        var t = document.createTextNode("Resolved by " + cReArray[i].mId);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Amount: $" + cReArray[i].amt);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Description: " + cReArray[i].desc);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Time: " + cReArray[i].time);
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
    document.getElementById("mainButton").onclick = mMain;
    document.getElementById("mainButton").hidden = false;
}

//View Members
function viewMembers() {
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Ok give me a second to get the list of members";

    fetch("http://localhost:8080/ERS/getUsers", {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
    }).then(response => {
        rjson = response.json();
        return rjson;
    }).then(data => {
        users = data;
        newPage('../pages/list.html');
        document.getElementById("page").addEventListener("mouseover", viewMem);
    }).catch((err) => {
        document.getElementById("face").src = "../images/uh.png";
        document.getElementById("text").innerText = "Something went wrong with the system. I couldnt check our records.";
        document.getElementById("loginButton").hidden = false;
        console.error(err)
    });
}
function viewMem() {
    console.log(users);
    document.getElementById("page").removeEventListener("mouseover", viewMem);
    document.getElementById("face").src = "../images/neutral_smile.png";
    document.getElementById("text").innerText = "Here is a list of all the members";

    for (var i = 0; i < users.length; i++) {
        var rei = document.createElement("li");
        var t = document.createTextNode("ID: " + users[i].uId);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Name: " + users[i].fname + " " + users[i].lname);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("li");
        var t = document.createTextNode("Email: " + users[i].email);
        rei.appendChild(t);
        document.getElementById("list").appendChild(rei);

        var rei = document.createElement("br");
        document.getElementById("list").appendChild(rei);
        var rei = document.createElement("br");
        document.getElementById("list").appendChild(rei);
    }
    document.getElementById("mainButton").innerText = "Menu";
    document.getElementById("mainButton").onclick = mMain;
    document.getElementById("mainButton").hidden = false;
}


function manDialogue() {

}