
function employeeLogged() {
    let navbar = document.getElementById('loaded-content');
    fetch('pages/employee.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
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
        let fnameLname = newUser.fname + " " + newUser.lname;
        document.getElementById('username').innerText = fnameLname.toUpperCase();
        employeeTabs(5);
    });
}

function employeeTabs(num) {
    let navbar = document.getElementById('content');

    switch (num) {
        case 1:
            fetch('pages/profile.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;
                document.getElementById('fname').value = newUser.fname;
                document.getElementById('lname').value = newUser.lname;
                document.getElementById('email').value = newUser.email;
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
            pendingReqs();
            break;

        case 4:
            fetch('pages/resolved.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;


            });
            break;

        case 5:

            fetch('pages/home.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;
                document.getElementById('news-btn').style.backgroundColor = "yellow";
                document.getElementById('news-btn').style.fontSize = "97%";

            });
            break;

    }


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