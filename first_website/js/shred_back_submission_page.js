//Javascript for Shredding back submission page
window.onload = function(){
    document.getElementById("button").addEventListener("click", submission);
}

let rating = null;
let pros = null;
let cons = null;

function submission(){
    let rating = document.getElementById("rating").value;
    let pros = document.getElementById('pro').value;
    let cons = document.getElementById('con').value;
    console.log(pros);
}


