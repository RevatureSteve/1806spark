let ideaUrl = 'http://localhost:3001/ideas';
document.getElementById('ideaBtn').addEventListener('click', newIdea);
function newIdea(){
    let newIdeaStatus = document.getElementById('newIdeaStatus');
    let idea = document.getElementById('ideaInput').value;

    // Post data!
    let ideaData = {
        "idea": idea,
    }

    fetch(ideaUrl, {
        method: 'POST', // or 'PUT'
        body: JSON.stringify(ideaData), // data can be `string` or {object}! Must be converted to JSON
        headers:{
          'Content-Type': 'application/json'
        }
    }).then(ideaData => ideaData.json()).then(i => {
            console.log(i);
        newIdeaStatus.innerHTML = i.idea;
    });
}