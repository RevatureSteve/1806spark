

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
        document.getElementById('back-btn').addEventListener('click', loginPage)

        pro.addEventListener('click', clickedMgr);

        sub.addEventListener('click', clickedMgr);

        pend.addEventListener('click', clickedMgr);


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
                allReqs();
            });
            break;

        case 2:
            fetch('pages/submit.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;


            });
            break;

        case 3:
            fetch('pages/pending.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;


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

    }
}

function mgrActiveBtn(eventId) {
    let innerElement = document.getElementById(eventId);
    let pro = document.getElementById('profile-info-btn-mgr');
    let sub = document.getElementById('submit-reim-btn-mgr');
    let pend = document.getElementById('pending-reim-btn-mrg');
    let news = document.getElementById('news-btn-mgr');

    switch (eventId) {
        case "profile-info-btn-mgr":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            sub.removeAttribute("style");
            pend.removeAttribute("style");
            news.removeAttribute('style');

            mgrTabs(1);

            break;
        case "submit-reim-btn-mgr":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            pro.removeAttribute("style");
            pend.removeAttribute("style");
            news.removeAttribute('style');
            mgrTabs(2);

            break;
        case "pending-reim-btn-mrg":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "95%";
            sub.removeAttribute("style");
            pro.removeAttribute("style");
            news.removeAttribute('style');
            mgrTabs(3);
            break;
        case 'news-btn-mgr':
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            sub.removeAttribute("style");
            pend.removeAttribute("style");
            pro.removeAttribute('style');

            mgrTabs(5);
            break;
    }
}
function createAllPendingTable(){
    table = document.getElementById('table2');
let x = 1; 
for(let i = 0; i < newAllReqs.length; i++) {
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
cell4.innerHTML = JSON.stringify(newAllReqs[i].img);
cell5.innerHTML = JSON.stringify(newAllReqs[i].rq_status);
cell6.innerHTML = JSON.stringify(newAllReqs[i].timeStamp);
cell7.innerHTML = JSON.stringify(newAllReqs[i].r_id);
x++;
}
}
