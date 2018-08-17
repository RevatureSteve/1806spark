

window.onload = function foo(){
    console.log("app.js is loaded in...")


    if(document.getElementById('content')){

    }
    else if(document.getElementById('talos')){
        document.getElementById('talos').addEventListener('click', loadPage);
    }else{
    loadPage();
    }
}

function loadPage(){
    let navbar = document.getElementById('loaded-content');
    fetch('pages/start.html').then((resp) => {
        console.log(resp);
        nav = resp;
        return resp.text();
    }).then((text) =>{
        console.log(text);
        navbar.innerHTML = text;
        document.getElementById('talos').addEventListener('click', loginPage);
   
    });
}

function loginPage(){
    let eventID = event.target.id;
    console.log('ID IS: ' + eventID);
    let navbar = document.getElementById('loaded-content');
    fetch('pages/login.html').then((resp) => {
        console.log(resp);
        nav = resp;
        return resp.text();
    }).then((text) =>{
        console.log(text);
        navbar.innerHTML = text;
        document.getElementById('login').addEventListener('click', employeeLogged);
        document.getElementById('return').addEventListener('click', loadPage);
        

    });
}
function employeeLogged(){
    let navbar = document.getElementById('loaded-content');
    fetch('pages/employee.html').then((resp) => {
        console.log(resp);
        nav = resp;
        return resp.text();
    }).then((text) =>{
        console.log(text);
        navbar.innerHTML = text;
        let pro = document.getElementById('profile-info-btn');
        let sub = document.getElementById('submit-reim-btn');
        let pend = document.getElementById('pending-reim-btn');
        let resolved = document.getElementById('resolved-riem-btn');
        document.getElementById('back-btn').addEventListener('click', loginPage)
        
        pro.addEventListener('click', clicked);
   
        sub.addEventListener('click', clicked);
       
        pend.addEventListener('click', clicked);
       
        resolved.addEventListener('click', clicked);
        
        employeeTabs(1);
    });
}

function employeeTabs(num){
    let navbar = document.getElementById('content');

    switch (num) {
        case 1:
        fetch('pages/profile.html').then((resp) => {
            console.log(resp);
            nav = resp;
            return resp.text();
        }).then((text) =>{
            console.log(text);
            navbar.innerHTML = text;
            document.getElementById('profile-info-btn').style.backgroundColor = "yellow";
            document.getElementById('profile-info-btn').style.fontSize = "97%";
            
        });
            break;
        
        case 2:
        fetch('pages/submit.html').then((resp) => {
            console.log(resp);
            nav = resp;
            return resp.text();
        }).then((text) =>{
            console.log(text);
            navbar.innerHTML = text;
            
            
        });
        break;

        case 3:
        fetch('pages/pending.html').then((resp) => {
            console.log(resp);
            nav = resp;
            return resp.text();
        }).then((text) =>{
            console.log(text);
            navbar.innerHTML = text;
            
            
        });
        break;

        case 4:
        fetch('pages/resolved.html').then((resp) => {
            console.log(resp);
            nav = resp;
            return resp.text();
        }).then((text) =>{
            console.log(text);
            navbar.innerHTML = text;
            
            
        });
        break;
    
    }
    
    
}

function managerLogged(){
    let navbar = document.getElementById('loaded-content');
}

function managerTabs(){

}

function clicked(){
let eventId = event.target.id;
activeBtn(eventId);
}

function activeBtn(eventId){
  
    let innerElement = document.getElementById(eventId);
    let pro = document.getElementById('profile-info-btn');
    let sub = document.getElementById('submit-reim-btn');
    let pend = document.getElementById('pending-reim-btn');
    let resolved = document.getElementById('resolved-riem-btn');
  
    
    switch (eventId) {
        case "profile-info-btn":
        innerElement.style.backgroundColor = "yellow";
        innerElement.style.fontSize = "97%";
        sub.removeAttribute("style");
       pend.removeAttribute("style");
       resolved.removeAttribute('style');
       
        employeeTabs(1);
       
            break;
        case "submit-reim-btn":
        innerElement.style.backgroundColor = "yellow";
        innerElement.style.fontSize = "97%";
        pro.removeAttribute("style");
       pend.removeAttribute("style");
       resolved.removeAttribute('style');
        employeeTabs(2);

            break;
        case "pending-reim-btn":
        innerElement.style.backgroundColor = "yellow";
        innerElement.style.fontSize = "97%";
        sub.removeAttribute("style");
       pro.removeAttribute("style");
       resolved.removeAttribute('style');
        employeeTabs(3);
            break;
        case "resolved-riem-btn":
        innerElement.style.backgroundColor = "yellow";
        innerElement.style.fontSize = "97%";
        sub.removeAttribute("style");
       pend.removeAttribute("style");
       pro.removeAttribute('style');
        
        employeeTabs(4);
            break;
    
    }
}