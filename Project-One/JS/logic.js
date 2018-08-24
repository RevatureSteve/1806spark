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
