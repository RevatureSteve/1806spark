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
        document.getElementById('logout').addEventListener('click', logout);
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
        document.getElementById('logout2').addEventListener('click', logout4);
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
        getEmpInfo();
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
//LOGOUT FUNCTIONALITY
function logout (){
    console.log('logging out');
    let navbar = document.getElementById('content');
    fetch('Pages/login.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text; 
        logout2();
    });
    
}

function logout4 (){
    console.log('logging out');
    let navbar = document.getElementById('content');
    fetch('Pages/login.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text; 
        logout3();
    });
    
}

function logout2 (){
    console.log('logging out');
    let navbar = document.getElementById('topBar');
    fetch('Pages/logout.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text; 
    });
    
}

function logout3 (){
    console.log('logging out');
    let navbar = document.getElementById('topBar2');
    fetch('Pages/logout.html').then((resp) => {
        nav = resp;
        return resp.text();
    }).then((text) => {
        navbar.innerHTML = text; 
    });
    
}



