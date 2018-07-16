/*
    new-question.js
*/

// can't use window.onload again as it is used in the app.js, reference at bottom instead
let url = 'http://localhost:3001/preview';
document.getElementById('previewBtn').addEventListener('click', preview);
function preview(){
    let html = document.getElementById('html').value;
    let css = document.getElementById('css').value;
    let js = document.getElementById('js').value;
    
    // Post data!
    let data = {
        "html": html,
        "css": css,
        "js": js
    }

    fetch(url, {
        method: 'POST', // or 'PUT'
        body: JSON.stringify(data), // data can be `string` or {object}! Must be converted to JSON
        headers:{
          'Content-Type': 'application/json'
        }
    }).then(data=> data.json()).then(q => {
            console.log(q);
    });
}

document.getElementById('previewBtn').addEventListener('click', newTab);
function newTab(){
    window.open("/pages/preview.html");
}