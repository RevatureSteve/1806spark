/*
 core js files
*/

window.onload = function(){
    console.log('page has loaded')
}

function loadNavBar(){
    console.log('loading nav bar')
let navbar=document.getElementById('navbar');
    fetch('pages/navbar.html').then((resp)=>{
        console.log(resp + "hahahah");
        nav = resp;
        return resp.text(); //getting html not json
      })  .then((text)=>{;
        navbar.innerHTML = text;
      })
}