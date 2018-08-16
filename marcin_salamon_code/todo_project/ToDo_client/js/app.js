window.onload = function(){
    console.log('page has loaded');

    loadNavbar();
    document.getElementById('button').addEventListener('click', loadTasks)
}

function loadNavbar(){
    console.log('load navbar');
    let navbar = document.getElementById('navbar');
    fetch('pages/navbar.html').then((resp)=> {
        console.log(resp);
        nav = resp;
        return resp.text();
    }).then((text)=>{
        console.log(text);
        navbar.innerHTML = text;
    })
}

function loadTasks(){
    console.log('load tasks');
    let tasks = document.getElementById('tasks');
    let x = document.getElementById('number').value;
    fetch('http://localhost:8080/TodoList/task/id?userId='+x).then((resp)=>{
        console.log(resp);
        task = resp;
        return resp.json();
    }).then((json)=>{
        console.log(json);
        let a = document.createElement('li');
        a.innerHTML = json;
        tasks.appendChild(a);
    });
}