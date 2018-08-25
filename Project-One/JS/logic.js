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