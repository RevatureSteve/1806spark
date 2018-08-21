
let userId = 2;
window.onload = function foo() {

    
    console.log("app.js is loaded in...")


    if (document.getElementById('content')) {

    }
    else if (document.getElementById('talos')) {
        document.getElementById('talos').addEventListener('click', loadPage);
    } else {
        loadPage();
    }
}

function loadPage() {
    let navbar = document.getElementById('loaded-content');
    fetch('pages/start.html').then((resp) => {
        console.log(resp);
        nav = resp;
        return resp.text();
    }).then((text) => {
        console.log(text);
        navbar.innerHTML = text;
        document.getElementById('talos').addEventListener('click', loginPage);

    });
}

function loginPage() {
    
    let eventID = event.target.id;
    console.log('ID IS: ' + eventID);
    let navbar = document.getElementById('loaded-content');
    fetch('pages/login.html').then((resp) => {
        console.log(resp);
        nav = resp;
        return resp.text();
    }).then((text) => {
        console.log(text);
        navbar.innerHTML = text;
        document.getElementById('login').addEventListener('click', userLogged);
        document.getElementById('return').addEventListener('click', loadPage);


    });
}
function userLogged(){
    if(userId == 2){
            managerLogged();
    }else{
        employeeLogged();
    }
}

function employeeLogged() {
    let navbar = document.getElementById('loaded-content');
    fetch('pages/employee.html').then((resp) => {
        console.log(resp);
        nav = resp;
        return resp.text();
    }).then((text) => {
        console.log(text);
        navbar.innerHTML = text;
        let pro = document.getElementById('profile-info-btn');
        let sub = document.getElementById('submit-reim-btn');
        let pend = document.getElementById('pending-reim-btn');
        let resolved = document.getElementById('resolved-riem-btn');
        let news = document.getElementById('news-btn');
        document.getElementById('back-btn').addEventListener('click', loginPage)

        pro.addEventListener('click', clicked);

        sub.addEventListener('click', clicked);

        pend.addEventListener('click', clicked);

        resolved.addEventListener('click', clicked);

        news.addEventListener('click', clicked);

        employeeTabs(5);
    });
}

function employeeTabs(num) {
    let navbar = document.getElementById('content');

    switch (num) {
        case 1:
            fetch('pages/profile.html').then((resp) => {
                console.log(resp);
                nav = resp;
                return resp.text();
            }).then((text) => {
                console.log(text);
                navbar.innerHTML = text;

            });
            break;

        case 2:
            fetch('pages/submit.html').then((resp) => {
                console.log(resp);
                nav = resp;
                return resp.text();
            }).then((text) => {
                console.log(text);
                navbar.innerHTML = text;


            });
            break;

        case 3:
            fetch('pages/pending.html').then((resp) => {
                console.log(resp);
                nav = resp;
                return resp.text();
            }).then((text) => {
                console.log(text);
                navbar.innerHTML = text;


            });
            break;

        case 4:
            fetch('pages/resolved.html').then((resp) => {
                console.log(resp);
                nav = resp;
                return resp.text();
            }).then((text) => {
                console.log(text);
                navbar.innerHTML = text;


            });
            break;

        case 5:

            fetch('pages/home.html').then((resp) => {
                console.log(resp);
                nav = resp;
                return resp.text();
            }).then((text) => {
                console.log(text);
                navbar.innerHTML = text;
                document.getElementById('news-btn').style.backgroundColor = "yellow";
                document.getElementById('news-btn').style.fontSize = "97%";

            });
            break;

    }


}

function managerLogged() {
    
    let navbar = document.getElementById('loaded-content');
    fetch('pages/manager.html').then((resp) => {
        console.log(resp);
        nav = resp;
        return resp.text();
    }).then((text) => {
        console.log(text);
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
        console.log("starting mgrTabs");
        mgrTabs(5);
    });
}

function mgrTabs(num) {
    let navbar = document.getElementById('content');
    console.log("Switching case" + num);
    switch (num) {
        case 1:
            fetch('pages/profile.html').then((resp) => {
                console.log(resp);
                nav = resp;
                return resp.text();
            }).then((text) => {
                console.log(text);
                navbar.innerHTML = text;

            });
            break;

        case 2:
            fetch('pages/submit.html').then((resp) => {
                console.log(resp);
                nav = resp;
                return resp.text();
            }).then((text) => {
                console.log(text);
                navbar.innerHTML = text;


            });
            break;

        case 3:
            fetch('pages/pending.html').then((resp) => {
                console.log(resp);
                nav = resp;
                return resp.text();
            }).then((text) => {
                console.log(text);
                navbar.innerHTML = text;


            });
            break;

        case 5:

            fetch('pages/home-mgr.html').then((resp) => {
                console.log(resp);
                nav = resp;
                return resp.text();
            }).then((text) => {
                console.log(text);
                navbar.innerHTML = text;
                document.getElementById('news-btn-mgr').style.backgroundColor = "yellow";
                document.getElementById('news-btn-mgr').style.fontSize = "97%";

            });
            break;

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

function activeBtn(eventId) {

    let innerElement = document.getElementById(eventId);
    let pro = document.getElementById('profile-info-btn');
    let sub = document.getElementById('submit-reim-btn');
    let pend = document.getElementById('pending-reim-btn');
    let resolved = document.getElementById('resolved-riem-btn');
    let news = document.getElementById('news-btn');

    switch (eventId) {
        case "profile-info-btn":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            sub.removeAttribute("style");
            pend.removeAttribute("style");
            resolved.removeAttribute('style');
            news.removeAttribute('style');

            employeeTabs(1);

            break;
        case "submit-reim-btn":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            pro.removeAttribute("style");
            pend.removeAttribute("style");
            resolved.removeAttribute('style');
            news.removeAttribute('style');
            employeeTabs(2);

            break;
        case "pending-reim-btn":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            sub.removeAttribute("style");
            pro.removeAttribute("style");
            resolved.removeAttribute('style');
            news.removeAttribute('style');
            employeeTabs(3);
            break;
        case "resolved-riem-btn":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            sub.removeAttribute("style");
            pend.removeAttribute("style");
            pro.removeAttribute('style');
            news.removeAttribute('style');

            employeeTabs(4);
            break;
        case 'news-btn':
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            sub.removeAttribute("style");
            pend.removeAttribute("style");
            pro.removeAttribute('style');
            resolved.removeAttribute('style');

            employeeTabs(5);
            break;
    }
}
function mgrActiveBtn(eventId) {

    let innerElement = document.getElementById(eventId);
    let pro = document.getElementById('profile-info-btn-mgr');
    let sub = document.getElementById('submit-reim-btn-mgr');
    let pend = document.getElementById('pending-reim-btn-mgr');
    let news = document.getElementById('news-btn-mgr');

    switch (eventId) {
        case "profile-info-btn":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            sub.removeAttribute("style");
            pend.removeAttribute("style");
            news.removeAttribute('style');

            mgrTabs(1);

            break;
        case "submit-reim-btn":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            pro.removeAttribute("style");
            pend.removeAttribute("style");
            news.removeAttribute('style');
            mgrTabs(2);

            break;
        case "pending-reim-btn":
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "95%";
            sub.removeAttribute("style");
            pro.removeAttribute("style");
            news.removeAttribute('style');
            mgrTabs(3);
            break;
        case 'news-btn':
            innerElement.style.backgroundColor = "yellow";
            innerElement.style.fontSize = "97%";
            sub.removeAttribute("style");
            pend.removeAttribute("style");
            pro.removeAttribute('style');

            mgrTabs(5);
            break;
    }
}