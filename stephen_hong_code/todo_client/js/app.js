/*
    core js file
*/

window.onload = function(){
    console.log("page has loaded");
    loadNavbar();
    searchTaskHtml();
}

function loadNavbar(){
    console.log("loading navbar...");
let navbar = document.getElementById("navbar");
    fetch("/pages/navbar.html").then((resp) => {
        console.log(resp);
        nav = resp;
        return resp.text();
    })
    .then((text) => {
        console.log(text);
        navbar.innerHTML = text;
    })
}

function loadTask(x){
    console.log("loading task...");
let task = document.getElementById("view");
    fetch("/pages/task.html").then((resp) => {
        console.log(resp);
        return resp.text();
    })
    .then((text) => {
        console.log(text);
        task.innerHTML = text;
        loadTaskList(x);
    })
}

function searchTaskHtml(){
let task = document.getElementById("view");
    fetch("/pages/searchTask.html").then((resp) => {
        console.log(resp);
        return resp.text();
    })
    .then((text) => {
        console.log(text);
        task.innerHTML = text;
    })
}

function loadTaskList(x){
    console.log("loading task list...");
    document.getElementById("listTask");
    fetch("http://localhost:8080/TodoList/task/id?userId=" + x).then((resp) => {
        console.log(resp);
        return resp.json();
    })
    .then((json) => {
        console.log(json);
        loopTask(json);
    })
}

function loopTask(json) {
    for (var i = 0; i < json.length; i++) {
        var c = document.createElement("li");
        c.innerHTML = json[i].taskName;
        document.getElementById("listTask").appendChild(c);
    }
}

function searchTask() {
    var x = document.getElementById("userid").value;
    loadTask(x);
}