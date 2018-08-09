let previewUrl = 'http://localhost:3001/preview';

fetch(previewUrl).then(function(previewData){
    return previewData.json();
}).then(function (jsonPreview) {
    jsonPreviewResults = jsonPreview;
    console.log(jsonPreviewResults);
    document.getElementById("name").value = jsonPreviewResults[1].name;
    document.getElementById("description").value = jsonPreviewResults[1].description;
    document.getElementById("html").value = jsonPreviewResults[1].html;
    document.getElementById("css").value = jsonPreviewResults[1].css;
    document.getElementById("js").value = jsonPreviewResults[1].js;
});

document.getElementById('previewBtn').addEventListener('click', preview);
function preview(){
    let name = document.getElementById('name').value;
    let description = document.getElementById('description').value;
    let html = document.getElementById('html').value;
    let css = document.getElementById('css').value;
    let js = document.getElementById('js').value;
    
    // Post data!
    let projectData = {
        "name": name,
        "description": description,
        "html": html,
        "css": css,
        "js": js
    }

    fetch(previewUrl, {
        method: 'POST', // or 'PUT'
        body: JSON.stringify(projectData), // data can be `string` or {object}! Must be converted to JSON
        headers:{
          'Content-Type': 'application/json'
        }
    }).then(projectData=> projectData.json()).then(c => {
            console.log(c);
    });
}

document.getElementById('previewBtn').addEventListener('click', newTab);
function newTab(){
    window.open("/pages/preview.html");
}