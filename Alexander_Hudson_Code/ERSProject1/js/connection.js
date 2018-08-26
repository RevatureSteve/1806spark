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

var approve = {};
function viewApprove (){
    fetch ('http://localhost:8080/RickAndMorty/reim/approved?rq_Status_Id=1', {
        method: 'GET',
        headers: {'Content-Type' : 'application/json'}
    }).then (resp => {
        return resp.json();
    }).then(data => {
        approve = data;
        console.log(approve[0]);
        createApproved();
    }).catch(err => {
        console.log("[LOG]----------" + err);
    });
}

var pending = {};
function viewPending (){
    fetch ('http://localhost:8080/RickAndMorty/reim/pending?rq_Status_Id=2', {
        method: 'GET',
        headers: {'Content-Type' : 'application/json'}
    }).then (resp => {
        return resp.json();
    }).then(data => {
        pending = data;
        console.log(pending[0]);
        createPending();
    }).catch(err => {
        console.log("[LOG]----------" + err);
    });
}

var denied = {};
function viewDenied (){
    fetch ('http://localhost:8080/RickAndMorty/reim/denied?rq_Status_Id=3', {
        method: 'GET',
        headers: {'Content-Type' : 'application/json'}
    }).then (resp => {
        return resp.json();
    }).then(data => {
        denied = data;
        console.log(denied[0]);
        createDenied();
    }).catch(err => {
        console.log("[LOG]----------" + err);
    });
}

var reim = {};
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
        console.log(['[LOG]-----------' + err]);
    });
}


var emp = {};
function getAllEmp () {
    fetch ('http://localhost:8080/RickAndMorty/employees?pos_id=2',{
        method: 'GET',
        headers: {'Content-Type' : 'application/json'}
    }).then (resp => {
        return resp.json();
    }).then(data => {
        emp = data;
        console.log(emp[0]);
        createEmp();
    }).catch (err => {
        console.log(['[LOG]-----------' + err]);
    });
}

var empAll = {};
function getAllEmp () {
    console.log('user id ' + newUser.u_Id);
    fetch ('http://localhost:8080/RickAndMorty/reim/empId?emp_U_Id=' + newUser.u_Id,{
        method: 'GET',
        headers: {'Content-Type' : 'application/json'}
    }).then (resp => {
        return resp.json();
    }).then(data => {
        empAll = data;
        console.log(empAll[0]);
        EmpAllReim();
    }).catch (err => {
        console.log(['[LOG]-----------' + err]);
    });
}

