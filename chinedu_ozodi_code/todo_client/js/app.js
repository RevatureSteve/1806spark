//Core js File

window.onload = function() {
    this.console.log("page has loaded");
    loadNavBar();
}

function loadNavBar(){
    console.log("loading navbar, please wait...");
    let navbar = document.getElementById('navbar');
    fetch('pages/navbar.html').then(
        (resp) => {
            console.log(resp);
            return resp.text();
        }
    ).then((text) => {
        console.log(text);
        navbar.innerHTML = text;
    })
}