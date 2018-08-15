/*
    core javascript file
*/

window.onload = function(){
    console.log('page has loaded');
}

function loadNavbar(){
    console.log('loading navbar..');
    let navbar = document.getElementById('navbar')
    fetch('pages/navbar.html').then((resp)=>{
        console.log(resp);
        nav = resp;
        return resp.text();
    }).then((text)=>{
        console.log(text);
        navbar.innerHTML = text;
    });
    }
function loadTask(){
    console.log('loading task..');
    let task = document.getElementById('task')
    fetch('http://localhost:8080/task/id?=60').then((resp)=>{
        console.log(resp);
        return resp.json();
    }).then((text)=>{
        console.log(text);
        task.innerHTML = json;
    });
    }