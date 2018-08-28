//------------------------------------------------------------------------------------------------------
//LOGIN FUNCTIONALITY
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

//------------------------------------------------------------------------------------------------------
//EMPLOYEE CREATE REIMBURSEMENT
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

//----------------------------------------------------------------------------------------------------
//MANAGER VIEW ALL APPROVED
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

//------------------------------------------------------------------------------------------------------
//MANAGER VIEW ALL PENDING
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

//------------------------------------------------------------------------------------------------------
//MANAGER VIEW ALL DENIED 
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

//----------------------------------------------------------------------------------------------------
//MANAGER GET ALL REIMBURSEMENTS
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

//MANAGER CAN UPDATE REQUEST
function changeReim () {
    console.log("update" + newUser.u_Id);
    for (let i = list.length - 1; i > -1; i--){
        console.log([i]);
    fetch ('http://localhost:8080/RickAndMorty/reim/update?r_Id='+ list[i] + '&rq_Status_Id=' + rqStat + '&mgr_U_Id=' + newUser.u_Id ,{
        method: 'GET',
        headers: {'Content-Type' : 'application/json'}
    }).then (resp => {
        return resp.json();
    }).then(data => {
        resultSet = data;
        console.log(resultSet);
    }).catch (err => {
        console.log(['[LOG]-----------' + err]);
    });
}
clearArray();
}

//------------------------------------------------------------------------------------------------------
//MANAGER VIEW ALL EMPLOYEES
var emp = {};
function getAllEmp2 () {
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

//------------------------------------------------------------------------------------------------------
//EMPLOYEE CAN VIEW ALL REIMBURSEMENTS
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
//--------------------------------------------------------------------------------------------------------
//EMPLOYEE VIEW PROFILE
function getEmpInfo () {
    newEmail = document.getElementById('email').value;
    fname = document.getElementById('fname').value;
    lname = document.getElementById('lname').value;

    let data = {"email": newEmail, "fname": fname, "lname": lname, "u_Id": newUser.u_Id};

    fetch ('http://localhost:8080/RickAndMorty/empInfo/update', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {'Content-Type': 'application/json'}
    }).then(resp => {
        return resp.json();
    }).then(data => {
        resultSet = data;
        console.log(resultSet);
    }).catch(err => {
        console.log("[LOG]---------------" + err);
    });

    
}




