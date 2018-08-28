let list = [];
let rq_Status_Id;
let rqStat;

window.onload = function foo() {
    console.log('Loading login');

    login();

}

// LOGIN FUNCTIONALITY
function login (){
    let navbar = document.getElementById('content');
    fetch('Pages/login.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
        document.getElementById('submit').addEventListener('click', getLogin);
        removeNavBar();
    });
}

//LOGOUT FUNCTIONALITY
function removeNavBar (){
    let navbar = document.getElementById('topBar');
    let navbar2 = document.getElementById('topBar2');
    fetch('Pages/empty.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
        navbar2.innerHTML = text;
    });
}
//---------------------------------------------------------------------------------------------------
//NAVBARS
// EMPLOYEE NAVBAR
function topBar (){
    let navbar = document.getElementById('topBar');
    fetch('Pages/navBar.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
        document.getElementById('profile').addEventListener('click', profile);
        document.getElementById('viewReim').addEventListener('click', viewReim);
        document.getElementById('createReim').addEventListener('click', empPage);
        document.getElementById('logout').addEventListener('click', login);
    });
}

//MANAGER NAVBAR
function topBarMgr (){
    let navbar = document.getElementById('topBar2');
    fetch('Pages/navBar1.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
        document.getElementById('mgrReim').addEventListener('click', mgrPage);
        document.getElementById('ViewEmp').addEventListener('click', mgrAllEmp);
        document.getElementById('ViewAll').addEventListener('click', mgrAllReim);
        document.getElementById('ViewApp').addEventListener('click', mgrApproved);
        document.getElementById('ViewPend').addEventListener('click', mgrPend);
        document.getElementById('ViewDenied').addEventListener('click', mgrDenied);
        document.getElementById('logout2').addEventListener('click', login);
    });
}

//--------------------------------------------------------------------------------------------------------------
//EMPLOYEE HOMEPAGE
function empPage () {
console.log('loading empPage');
    let navbar = document.getElementById('content');
    fetch('Pages/empPage.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
        topBar();
        document.getElementById('reimSub').addEventListener('click', createReim);
    });
}

//EMPLOYEE REIMBURSEMENTS
function viewReim (){
    console.log('View Reimbursement');
    let navbar = document.getElementById('content');
    fetch('Pages/empReim.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
       getAllEmp();
    });
    
}

//EMPLOYEE PROFILE PAGE
function profile (){
    console.log('profile loaded');
    let navbar = document.getElementById('content');
    fetch('Pages/empProfile.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text;
        document.getElementById('update').addEventListener('click',getEmpInfo )
        document.getElementById('email').value = newUser.email;
       document.getElementById('fname').value = newUser.fName;
        document.getElementById('lname').value = newUser.lName;

    });
}

//-----------------------------------------------------------------------------------------------------------
//MANAGER
//MANAGER HOMEPAGE
function mgrPage () {
    console.log('loading mgrPage');
        let navbar = document.getElementById('content');
        fetch('Pages/mgrPage.html').then((resp) => {
            nav = resp;
            return resp.text();
        }).then((text) => {
            navbar.innerHTML = text;
            topBarMgr();
        });
    }

//MANAGER VIEW ALL EMPLOYEES
function mgrAllEmp (){
    console.log('loading mgrAllEmp');
        let navbar = document.getElementById('content');
        fetch('Pages/mgrAllEmp.html').then((resp) => {
            nav = resp;
            return resp.text();
        }).then((text) => {
            navbar.innerHTML = text;
            topBarMgr();
            getAllEmp2();
        });
    }

//MANAGER VIEW ALL APPROVED
    function mgrApproved (){
        console.log('loading All Approved');
            let navbar = document.getElementById('content');
            fetch('Pages/mgrApproved.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;
                topBarMgr();
                viewApprove();
            });
        }

//MANAGER VIEW ALL PENDING
    function mgrPend (){
        console.log('loading All Pending');
            let navbar = document.getElementById('content');
            fetch('Pages/mgrPend.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;
                topBarMgr();
                viewPending();
            document.getElementById('approve').addEventListener('click', updateApprove);
            document.getElementById('denied').addEventListener('click', updateDenied);
            document.getElementById('clear').addEventListener('click', clearArray);
               });
        }

//MANAGER VIEW ALL DENIED
    function mgrDenied (){
        console.log('loading All Denied');
            let navbar = document.getElementById('content');
            fetch('Pages/mgrDenied.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;
                topBarMgr();
                viewDenied();
               });
        }

//MANAGER VIEW ALL REIMBURSEMENTS
    function mgrAllReim (){
        console.log('loading mgr All Reimbursements');
            let navbar = document.getElementById('content');
            fetch('Pages/mgrAllReim.html').then((resp) => {
                nav = resp;
                return resp.text();
            }).then((text) => {
                navbar.innerHTML = text;
                topBarMgr();
                getAllReim();
               });
        }

//-------------------------------------------------------------------------------------------------------





