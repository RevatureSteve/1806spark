function userLogged (){
    if(newUser.pos_Id == 2){
        empPage();
    }else{
        mgrPage();
    }
}

function rowListener(){
    event.stopPropagation();
    let newRow = event.target.id;
    newRow = parseInt(newRow);
    console.log("Id is" + newRow);
    if (isNaN(newRow)) {
        console.log("not a number...")
    }else{
        list.unshift(newRow);
        console.log("List is" + list);
        document.getElementById('denyBox').innerHTML += '<p>' + list[0] + '</p>';
    }
}


function clearArray(){
    list = [];
    document.getElementById('denyBox').innerHTML = '';
}

function updateApprove(){
    console.log('handling...approved');
    rqStat = 1;
    changeReim();
}


function updateDenied(){
    console.log('handling...approved');
    rqStat = 3;
    changeReim();
}


// function clicked (){
//     let eventId = event.target.id;
//     activeBtn(eventId);
// }
// function clickedMgr(){
//     let eventId = event.target.id;
//     mgrActiveBtn(eventId);
// }

