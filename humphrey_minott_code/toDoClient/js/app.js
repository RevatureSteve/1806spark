/*
Core javascript file
*/

window.onload = function(){

    console.log("page has loaded")
    loadNavBar();
}

function loadNavBar(){
    console.log("loading navBar")
    let navBar = document.getElementById("navBar");
    fetch("pages/navbar.html").then((resp)=> {
        nav = resp;
        return resp.text();
    }).then((text) =>{
        navBar.innerHTML= text;
    })
}