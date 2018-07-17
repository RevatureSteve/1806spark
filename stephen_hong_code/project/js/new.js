let url = 'http://localhost:3001/preview';
document.getElementById('previewBtn').addEventListener('click', preview);
function preview(){
    let name = document.getElementById('name').value;
    let description = document.getElementById('description').value;
    let html = document.getElementById('html').value;
    let css = document.getElementById('css').value;
    let js = document.getElementById('js').value;
    
    // Post data!
    let data = {
        "name": name,
        "description": description,
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