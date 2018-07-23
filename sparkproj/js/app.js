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
            console.log("resp");
            nav = resp;
            return resp.text(); // getting html not json!
        })
        .then( (text)=>{
            console.log("Navbar Loaded from navbar.HTML");
            navbar.innerHTML = text;    
        })
}


var check = function() {
  if (document.getElementsByClassName('psw').value ==
    document.getElementByClassName('pswcnfrm').value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'matching';
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'not matching';
  }
}