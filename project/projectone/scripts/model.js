
var modal;
let port = 3000;

window.onload = function() {

/// this is the html in modal event listener on click 
// this.document.getElementById("myBtn").addEventListener("click", myRoute); // this is for the review button
this.document.getElementById("submBtn").addEventListener("click", myRoute);

// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

}

let localhostURL = "http://localhost:3000/submit"
//"http://localhost:3000/travel"; // this route fail because it wasnt define in server 
//as a path similar to app.get("/submit", myRoute ())

function myRoute() {
    let  author = document.getElementById("username").value ;
    let comment =  document.getElementById("comment").value ;






//post data to data base

let reveiwData = {
 "author": author,
"comment": comment
}


fetch(localhostURL, {
    method: 'POST', 
    body: JSON.stringify(reveiwData), // data can be string or object must be converted to json
    headers:{ 
        'Content-Type': 'application/json'
    }
    }) .then(data => data.json()).then(q => {
        console.log(g);
    })

  location.reload(true);

}

// //this to put comment from data base
// var allComments = null;
// callComments();

// function callComments() {
//     fetch(localhostURL)
//     .then((resp) => {
//         return resp.json();
//     }) 
//     .then((data) => {
//     console.log(data);
//     allComments = data;
//     printComment(allComments)
//     })
// }


// function printComment(modalModal) {
//     console.log('setting question to page');
//     console.log(modalModal);
//     var commentSection = document.getElementById('modalModal');

//     for( x=0; modalModal.length; x++) {
//         let modalModalDiv = document.createElement('div');
//         modalModalDiv.innerHTML = modalModal[x].author + ":" + modalModal[x].comment
//         commentSection.appendChild(modalModalDiv);
//     }

// }