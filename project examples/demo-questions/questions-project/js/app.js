/*
    app.js for the client
*/
let port = 3000;
window.onload = function() {
    // get navbar html fragment
    setNavbar();
    
}
var nav = null;
function setNavbar(){
    let navbar = document.getElementById('navbar');

    fetch(`http://localhost:${port}/pages/navbar.html`) // template literal w/ ` ` allows to insert variables inside of ${ variable }
        .then((resp)=> {
            console.log(resp);
            nav = resp;
            return resp.text(); // getting html not json!
        })
        .then( (text)=>{
            console.log(text);
            navbar.innerHTML = text;    
        })
}