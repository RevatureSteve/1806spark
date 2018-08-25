function userLogged (){
    if(newUser.pos_Id == 2){
            employeeLogged();
    }else{
        managerLogged();
    }
}
function clicked (){
    let eventId = event.target.id;
    activeBtn(eventId);
}
function clickedMgr(){
    let eventId = event.target.id;
    mgrActiveBtn(eventId);
}