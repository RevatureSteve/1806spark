var ideaUrl = 'http://localhost:3001/ideas';
var ideas = null;
callIdeas();

function callIdeas(){
    fetch(ideaUrl)
    .then((resp) => {
        return resp.json();
    })
    .then((ideaData) => {
        console.log(ideaData);
        ideas = ideaData;
        setIdeas(ideas);
    })
}


function setIdeas(i){
    console.log('setting ideas to page');
    console.log(i);
    var ideasSection = document.getElementById('ideas');
    
    for(let x = 0;x < i.length; x++){
        let iDiv = document.createElement('div');
        iDiv.innerHTML = "I: " + i[x].idea;
        ideasSection.appendChild(iDiv);
    }
}