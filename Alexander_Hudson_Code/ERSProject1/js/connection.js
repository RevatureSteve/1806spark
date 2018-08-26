function getLogin(){

    let email;
    let password;
    email = document.getElementById('Email').value;
    password = document.getElementById('Password').value;
    

    let data = {"email" : email, "password" : password};
fetch ('http://localhost:8080/RickAndMorty/login', {
    
    method: 'POST',
    body: JSON.stringify(data),
    headers: {'Content-Type' : 'application/json'}
}).then (resp => {
    return resp.json();
}).then(data => {
    newUser = data; 
    console.log(newUser);
    if(newUser != null){
    return userLogged();
    }else{ 
        alert("Y..Y..Youu don't match anyone here Rick");
        console.log('[LOG]-------------' + err);
}
       
});

}

function createReim (){
    console.log("Connecting to DB");
    empUId = parseInt(document.getElementById('empUId').value);
    amount = parseInt(document.getElementById('amt').value);
    description = document.getElementById('description').value;
    rqType = parseInt(document.getElementById('rq_Type').value);

    let data = { "emp_U_Id" : empUId,
        "amt" : amount,
        "description" : description,
        "rq_Type" : rqType
    };

    console.log(data);
fetch ('http://localhost:8080/RickAndMorty/reim/create', {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {'Content-Type': 'application/json'}
}).then(resp => {
    return resp.json();
}).then(data => {
    resultSet = data;
    console.log('Reimbursement Submitted!' + resultSet);
}).catch(err => {
    console.log("[LOG]----------" + err);
    
});
}

// CURRENTLY DOES NOT WORK!!!!!!!!!!!!!!
function viewPending (){
    fetch ('http://localhost:8080/RickAndMorty/reim/pending?emp_U_Id=&rq_Status_Id=2' + newUser.pos_Id, {
        method: 'GET',
        headers: {'Content-Type' : 'application/json'}
    }).then (resp => {
        return resp.json();
    }).then(data => {
        pendingReq = data;
        console.log(pendingReq[0]);
    }).catch(err => {
        console.log("[LOG]----------" + err);
    });
}

function getAllReim () {
    fetch ('http://localhost:8080/RickAndMorty/reim',{
        method: 'GET',
        headers: {'Content-Type' : 'application/json'}
    }).then (resp => {
        return resp.json();
    }).then(data => {
        reim = data;
        console.log(reim[0]);
        createTable();
    }).catch (err => {
        console.log(['LOG-----------' + err]);
    });
}


