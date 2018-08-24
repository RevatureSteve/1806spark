

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
            fetch('pages/profile.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;

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
