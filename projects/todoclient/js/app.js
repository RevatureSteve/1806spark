window.onload = function(){

    console.log('page loaded.');

    loadNavbar();
    loadTask();
    
}


// injecting navbar html into doc.
function loadNavbar(){
    console.log('loading navbar.');
let navbar = document.getElementById('navbar')
    fetch('pages/navbar.html').then((resp) =>{
        console.log(resp);
        nav = resp;
        return resp.text();
    }).then((text)=>{
        console.log(text);
        navbar.innerHTML = text;
    })
}

function loadTask(){
    console.log('loading task.');
let task = document.getElementById('view')
    fetch('http://localhost:8080/TodoList/task').then((resp) =>{
        console.log(resp);
        task = resp;
        return resp.text();
    }).then((text)=>{
        console.log(text);
        task.innerHTML = text;
    })
}