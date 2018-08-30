

function managerLogged() {

    let navbar = document.getElementById('loaded-content');
    fetch('pages/manager.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
        let pro = document.getElementById('profile-info-btn-mgr');
        let sub = document.getElementById('submit-reim-btn-mgr');
        let pend = document.getElementById('pending-reim-btn-mrg');
        let news = document.getElementById('news-btn-mgr');
        let ser = document.getElementById('search-emp');
        document.getElementById('back-btn').addEventListener('click', loginPage)

        pro.addEventListener('click', clickedMgr);

        sub.addEventListener('click', clickedMgr);

        pend.addEventListener('click', clickedMgr);

        ser.addEventListener('click', clickedMgr);

        news.addEventListener('click', clickedMgr);
        let fnameLname = newUser.fname + " " + newUser.lname;
        document.getElementById('username').innerText = fnameLname.toUpperCase();
        mgrTabs(5);
    });
}

function mgrTabs(num) {
    let navbar = document.getElementById('content');
    switch (num) {
        case 1:
            fetch('pages/all-pending.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;
                document.getElementById('approved').addEventListener('click', updateApproved);
                document.getElementById('denied').addEventListener('click', updateHandler);
                tableOn = 0;
                allReqs();
            });
            break;

        case 2:
            fetch('pages/all-emp.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;
                allEmps();

            });
            break;

        case 3:
            fetch('pages/view-reqs.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;
                getAllResolvedReqs();

            });
            break;

        case 5:

            fetch('pages/home-mgr.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;
                document.getElementById('news-btn-mgr').style.backgroundColor = "yellow";
                document.getElementById('news-btn-mgr').style.fontSize = "97%";

            });
            break;
        case 6:

            fetch('pages/search.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;
                document.getElementById('search-emp').style.backgroundColor = "yellow";
                document.getElementById('search-emp').style.fontSize = "97%";
                document.getElementById('lookUp').addEventListener('click', searchEmp);
                document.getElementById('approved').addEventListener('click', updateApproved);
                document.getElementById('denied').addEventListener('click', updateHandler);
                tableOn = 1;
            });
            break;

    }
}

function mgrActiveBtn(eventId) {
    let innerElement = document.getElementById(eventId);
    let pro = document.getElementById('profile-info-btn-mgr');
    let sub = document.getElementById('submit-reim-btn-mgr');
    let pend = document.getElementById('pending-reim-btn-mrg');
    let news = document.getElementById('news-btn-mgr');
    let ser = document.getElementById('search-emp');

    switch (eventId) {
        case "profile-info-btn-mgr":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            sub.removeAttribute("style");
            pend.removeAttribute("style");
            news.removeAttribute('style');
            ser.removeAttribute('style');
            mgrTabs(1);

            break;
        case "search-emp":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            sub.removeAttribute("style");
            pend.removeAttribute("style");
            news.removeAttribute('style');
            pro.removeAttribute('style');

            mgrTabs(6);

            break;
        case "submit-reim-btn-mgr":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            pro.removeAttribute("style");
            pend.removeAttribute("style");
            news.removeAttribute('style');
            ser.removeAttribute('style');
            mgrTabs(2);

            break;
        case "pending-reim-btn-mrg":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "95%";
            sub.removeAttribute("style");
            pro.removeAttribute("style");
            news.removeAttribute('style');
            ser.removeAttribute('style');
            mgrTabs(3);
            break;
        case 'news-btn-mgr':
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            sub.removeAttribute("style");
            pend.removeAttribute("style");
            pro.removeAttribute('style');
            ser.removeAttribute('style');
            mgrTabs(5);
            break;
    }
}
function createAllPendingTable() {
    document.getElementById('clear').addEventListener('click', clearArray);
    table = document.getElementById('table2');
    let x = 1;
    for (let i = 0; i < newAllReqs.length; i++) {
        var row = table.insertRow(x);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);

        cell1.innerHTML = JSON.stringify(newAllReqs[i].amt);
        cell2.innerHTML = JSON.stringify(newAllReqs[i].description);
        cell3.innerHTML = JSON.stringify(newAllReqs[i].emp_u_id);
        cell4.innerHTML = JSON.stringify(newAllReqs[i].rb_type);
        cell5.innerHTML = JSON.stringify(newAllReqs[i].rq_status);
        cell6.innerHTML = JSON.stringify(newAllReqs[i].timeStamp);
        cell7.innerHTML = JSON.stringify(newAllReqs[i].r_id);
        row.id = newAllReqs[i].r_id;
        cell1.id = newAllReqs[i].r_id;
        cell2.id = newAllReqs[i].r_id;
        cell3.id = newAllReqs[i].r_id;
        cell4.id = newAllReqs[i].r_id;
        cell5.id = newAllReqs[i].r_id;
        cell6.id = newAllReqs[i].r_id;
        cell7.id = newAllReqs[i].r_id;
        console.log(row.id);
        x++;
        document.getElementById(cell1.id).addEventListener('click', rowListener);
        document.getElementById(cell2.id).addEventListener('click', rowListener);
        document.getElementById(cell3.id).addEventListener('click', rowListener);
        document.getElementById(cell4.id).addEventListener('click', rowListener);
        document.getElementById(cell5.id).addEventListener('click', rowListener);
        document.getElementById(cell6.id).addEventListener('click', rowListener);
        document.getElementById(cell7.id).addEventListener('click', rowListener);
    }
    document.getElementById('newTable').addEventListener('click', rowListener);
        console.log("Listening...");

}
function populateEmpTable() {
    console.log("popping table " + empList);
    table = document.getElementById('table3');
    let x = 1;
    for (let i = 0; i < empList.length; i++) {
        var row = table.insertRow(x);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);


        cell1.innerHTML = JSON.stringify(empList[i].u_id);
        cell2.innerHTML = JSON.stringify(empList[i].fname);
        cell3.innerHTML = JSON.stringify(empList[i].lname);
        cell4.innerHTML = JSON.stringify(empList[i].email);
        x++;
        
    }
}
function populateSearchTable() {
    console.log("popping table " + searchData);
    document.getElementById('clear').addEventListener('click', clearArray);

    table = document.getElementById('table4');
    let x = 1;
    if (table.rows.length > 1) {
        for (let y = table.rows.length - 1; y > 0; y--) {
            console.log("table is " + y);
            table.deleteRow(y);
        }
    }
    for (let i = 0; i < searchData.length; i++) {

        let row = table.insertRow(x);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);

        cell1.innerHTML = JSON.stringify(searchData[i].amt);
        cell2.innerHTML = JSON.stringify(searchData[i].description);
        cell3.innerHTML = JSON.stringify(searchData[i].timeStamp);
        cell4.innerHTML = JSON.stringify(searchData[i].r_id);
        cell1.id = searchData[i].r_id;
        cell2.id = searchData[i].r_id;
        cell3.id = searchData[i].r_id;
        cell4.id = searchData[i].r_id;
        document.getElementById(cell1.id).addEventListener('click', rowListener);
        document.getElementById(cell2.id).addEventListener('click', rowListener);
        document.getElementById(cell3.id).addEventListener('click', rowListener);
        document.getElementById(cell4.id).addEventListener('click', rowListener);
        console.log("Listening... to " + row.id);
        x++;
    }
    document.getElementById('newTable').addEventListener('click', rowListener);
    console.log("Listening...");
}
function populateReqTable() {
    console.log("popping table " + newAllResolvedReqs);

    table = document.getElementById('table5');
    let x = 1;
    if (table.rows.length > 1) {
        for (let y = table.rows.length - 1; y > 0; y--) {
            console.log("table is " + y);
            table.deleteRow(y);
        }
    }
    for (let i = 0; i < newAllResolvedReqs.length; i++) {

        var row = table.insertRow(x);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);
        var cell8 = row.insertCell(7);

        cell1.innerHTML = JSON.stringify(newAllResolvedReqs[i].amt);
        cell2.innerHTML = JSON.stringify(newAllResolvedReqs[i].description);
        cell3.innerHTML = JSON.stringify(newAllResolvedReqs[i].emp_u_id);
        cell4.innerHTML = JSON.stringify(newAllResolvedReqs[i].mgr_u_id);
        cell5.innerHTML = JSON.stringify(newAllResolvedReqs[i].rb_type);
        cell6.innerHTML = JSON.stringify(newAllResolvedReqs[i].rq_status);
        cell7.innerHTML = JSON.stringify(newAllResolvedReqs[i].timeStamp);
        cell8.innerHTML = JSON.stringify(newAllResolvedReqs[i].r_id);

        x++;
    }
    popped = true;
}