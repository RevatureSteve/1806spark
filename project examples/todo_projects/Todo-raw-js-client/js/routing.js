/*
    routing like angular routing but raw js

    path: /rev          id: revLink
    path: /dashboard    id: dashboardLink
    path: /addTodo      id: addTodoLink
    path: /login        id: loginLink    

    When clicking on a navbar link we don't want to send a synchronize 
        request as a normal href would do, we want to fetch
        asynchronously
*/

function loadNavbar(){
    console.log('loading navbar..');
    let navbar = document.getElementById('navbar');
    fetch('pages/navbar.html').then((resp)=> {
        nav = resp;
        return resp.text(); // getting html not json!
    }).then((text)=>{
        navbar.innerHTML = text;
        initNavbar();   
    });
}

function initNavbar(){
    console.log('init -navbar');
    // hiding links until login
   document.getElementById('user-navbar').style.display = "none";
   document.getElementById('logoutLink').style.display = "none";

    // routing event listeners
    initNavbarEventListeners();
}

function initNavbarEventListeners(){
    document.getElementById('revLink').onclick = updateRoute;
    document.getElementById('dashboardLink').onclick = updateRoute;
    document.getElementById('addTodoLink').onclick =updateRoute;
    document.getElementById('loginLink').onclick = updateRoute;
}

function updateRoute(e, page){
    console.log('updateUpdate:');
    // console.log(e.target.id); // see each different element IDs
    let route = null;
    e ? route = e.target.id : route = page;
    // if(e){
    //     route = e.target.id;
    // } else{
    //     route = page;
    // }
    switch(route) {
        case("revLink"):
            getView('rev');
            history.pushState(null, '', '/rev'); // updates URL without changing page
            break;
        case("dashboardLink"):
            getView('dashboard');
            history.pushState(null, '', '/dashboard');
            break;
         case("addTodoLink"):
            getView('addTodo');
            history.pushState(null, '', '/addTodo');
            break;
        case("loginLink"):
            getView('login');
            history.pushState(null, '', '/login');
            break;

    }
}

function getView(page){
    console.log('getting view..' + page);
    fetch(`pages/${page}.html`).then((resp)=> {
        return resp.text(); 
    }).then((text)=>{
        setView(text);
    });
}

function setView(view){
    document.getElementById('view').innerHTML = view;
}



