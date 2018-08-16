/* core javascript file



*/

window.onload = function() {
    console.log("Page has loaded.");
    loadNavbar();
}

function loadNavbar() {
    let navbar = document.getElementById("navbar");
    console.log("Loading navbar");

    fetch("pages/navbar.html").then ( resp => {
        console.log(resp);
        text = resp;
        return resp.text()
    })
    .then((test)=> {
        console.log(text);
        navbar.innerHTML = text;
    })
}