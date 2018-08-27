function userLogged(){
    if(newUser.pos_id == 2){
            managerLogged();
    }else{
        employeeLogged();
    }
}
function clicked() {
    let eventId = event.target.id;
    activeBtn(eventId);
}
function clickedMgr() {
    let eventId = event.target.id;
    mgrActiveBtn(eventId);
}

function reqSent(){
    if(resultSet == 1){
        document.getElementById('alert').style.display = 'block';
        document.getElementById('close').addEventListener('click', closeAlert)
    }else{
        document.getElementById('alert').style.display = 'block';
        document.getElementById('alert').innerText = "FAILED!";
        document.getElementById('close').addEventListener('click', closeAlert)
    }
}
function closeAlert(){
    document.getElementById('alert').style.display = 'none';
}

function rowListener(){
    event.stopPropagation();
    let newRow = event.target.id;
    newRow = parseInt(newRow);
    console.log("ID is " + newRow);
    if(isNaN(newRow)){
        console.log("NAAAN");
    }
    else{
    list.unshift(newRow);
    console.log("List is " + list);
        document.getElementById('transaction').innerHTML += '<p>' + list[0] + '</p>';
    }
    
}

function clearArray(){
    console.log("Clear hit")
    list = [];
    document.getElementById('transaction').innerHTML = '';
    updateTable();
}
function updateHandler(){
    console.log("handling..");
    reqStatus = 3;
    updateReqs();
}
function updateApproved(){
    console.log("handling.. approved");
    reqStatus = 2;
    updateReqs();
}
function updateTable(){
    console.log("table is " + tableOn);
    if(tableOn == 1){
        tableOn = 0;
        searchEmp();
        
    }else{
        mgrTabs(1);
    }
}