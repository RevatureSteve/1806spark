function createTable(){
    table = document.getElementById('table');
    let x = 1;
    for (let i = 0; i < reim.length; i++) {
        console.log(reim [i]);
        var row = table.insertRow(x);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);
        var cell8 = row.insertCell(7);

        cell1.innerText = reim[i].amt;
        cell2.innerText = reim[i].description;
        cell3.innerText = reim[i].emp_U_Id;
        cell4.innerText = reim[i].mgr_U_Id;
        cell5.innerText = reim[i].rq_Status_Id;
        cell6.innerText = reim[i].rq_Type;
        cell7.innerText = reim[i].time_Submission;
        cell8.innerText = reim[i].r_Id;
        x++;

    }
}


function createPending(){
    table = document.getElementById('table2');
    let x = 1;
    for (let i = 0; i < pending.length; i++) {
        if(pending.rq_Status_Id == 2){
            continue;
        }
        console.log(pending [i].rq_Status_Id);
        var row = table.insertRow(x);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);
        var cell8 = row.insertCell(7);

        cell1.innerText = pending[i].amt;
        cell2.innerText = pending[i].description;
        cell3.innerText = pending[i].emp_U_Id;
        cell4.innerText = pending[i].mgr_U_Id;
        cell5.innerText = pending[i].rq_Status_Id;
        cell6.innerText = pending[i].rq_Type;
        cell7.innerText = pending[i].time_Submission;
        cell8.innerText = pending[i].r_Id;
        x++;

    }
}


function createDenied(){
    table = document.getElementById('table3');
    let x = 1;
    for (let i = 0; i < denied.length; i++) {
        if(denied.rq_Status_Id == 3){
            continue;
        }
        console.log(denied [i].rq_Status_Id);
        var row = table.insertRow(x);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);
        var cell8 = row.insertCell(7);

        cell1.innerText = denied[i].amt;
        cell2.innerText = denied[i].description;
        cell3.innerText = denied[i].emp_U_Id;
        cell4.innerText = denied[i].mgr_U_Id;
        cell5.innerText = denied[i].rq_Status_Id;
        cell6.innerText = denied[i].rq_Type;
        cell7.innerText = denied[i].time_Submission;
        cell8.innerText = denied[i].r_Id;
        x++;

    }
}


function createApproved(){
    table = document.getElementById('table4');
    let x = 1;
    for (let i = 0; i < approve.length; i++) {
        if(approve.rq_Status_Id == 1){
            continue;
        }
        console.log(approve[i].rq_Status_Id);
        var row = table.insertRow(x);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);
        var cell8 = row.insertCell(7);

        cell1.innerText = approve[i].amt;
        cell2.innerText = approve[i].description;
        cell3.innerText = approve[i].emp_U_Id;
        cell4.innerText = approve[i].mgr_U_Id;
        cell5.innerText = approve[i].rq_Status_Id;
        cell6.innerText = approve[i].rq_Type;
        cell7.innerText = approve[i].time_Submission;
        cell8.innerText = approve[i].r_Id;
        x++;

    }
}


function createEmp(){
    table = document.getElementById('table5');
    let x = 1;
    for (let i = 0; i < emp.length; i++) {
        if(emp.rq_Status_Id == 1){
            continue;
        }
        console.log(emp [i].rq_Status_Id);
        var row = table.insertRow(x);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
       

        cell1.innerText = emp[i].u_Id;
        cell2.innerText = emp[i].email;
        cell3.innerText = emp[i].fName;
        cell4.innerText = emp[i].lName;
        cell5.innerText = emp[i].pos_Id;
        x++;

    }
}

function EmpAllReim(){
    table = document.getElementById('table6');
    let x = 1;
    for (let i = 0; i < empAll.length; i++) {
        var row = table.insertRow(x);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);
        var cell8 = row.insertCell(7);

        cell1.innerText = empAll[i].amt;
        cell2.innerText = empAll[i].description;
        cell3.innerText = empAll[i].emp_U_Id;
        cell4.innerText = empAll[i].mgr_U_Id;
        cell5.innerText = empAll[i].rq_Status_Id;
        cell6.innerText = empAll[i].rq_Type;
        cell7.innerText = empAll[i].time_Submission;
        cell8.innerText = empAll[i].r_Id;
        x++;


    }
}