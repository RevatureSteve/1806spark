function createTable(){
    table = document.getElementById('table');
    let x = 1;
    for (let i = 0; i < getAllReim.length; i++) {
        var row = table.insertRow(x);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);
        var cell8 = row.insertCell(7);
        var cell9 = row.insertCell(8);

        cell1.innerHTML = JSON.stringify(newgetAlllReim[i].amt);
        cell2.innerHTML = JSON.stringify(newgetAlllReim[i].description);
        cell3.innerHTML = JSON.stringify(newgetAlllReim[i].emp_U_Id);
        cell4.innerHTML = JSON.stringify(newgetAlllReim[i].img);
        cell5.innerHTML = JSON.stringify(newgetAlllReim[i].mgr_U_Id);
        cell6.innerHTML = JSON.stringify(newgetAlllReim[i].rq_Status);
        cell7.innerHTML = JSON.stringify(newgetAlllReim[i].rq_Type);
        cell8.innerHTML = JSON.stringify(newgetAlllReim[i].Timestamp);
        cell9.innerHTML = JSON.stringify(newgetAlllReim[i].r_Id);
        x++;
    }
}
