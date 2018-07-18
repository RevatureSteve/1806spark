//Serverside Javascript for Shredding back submission page
window.onload = function(){
    document.getElementById("button").addEventListener("click", submission);
}

let rating = null;
let pros = null;
let cons = null;
let url = 'http://localhost:3000/Back';

function submission(){
    let rating = document.getElementById("rating").value;
    let pro = document.getElementById('pro').value;
    let con = document.getElementById('con').value;
    //console.log(pros);
    
    // Post data/submission!
    let data = {
        "rating": rating,
        "pro": pro,
        "con": con
    }

    fetch(url, {
        method: 'POST', 
        body: JSON.stringify(data), //data can be 'string' or {object}, must be converted to JSON
        headers:{
            'Content-Type': 'application/json'
        }
    }).then(data=> data.json()).then(f => {
        console.log(f);
        submissionBox.innerHTML = f.rating + " " + f.con + " " + f.pro;
    });
}


