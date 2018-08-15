window.onload = function(){
    console.log('page has loaded');
    loadNavbar();
}

function loadNavbar(){
    console.log('loading navbar..');
    let navbar = document.getElementById('navbar');
    fetch('pages/navbar.html').then((resp) => {
        console.log(resp);
        nav = resp;
        return resp.text();
    }).then((text) =>{
        console.log(text);
        navbar.innerHTML = text;
    });
}