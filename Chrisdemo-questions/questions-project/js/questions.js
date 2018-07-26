/*
    questions.js
*/
// No window.onload it has already been used by app.js
var url = 'http://localhost:3000/questions';
var questions = null;
callQuestions();

function callQuestions(){
    fetch(url)
    .then((resp) => {
        return resp.json();
    })
    .then((data)=> {
        console.log(data);
        questions = data;
        setQuestions(questions);
    })
}


function setQuestions(q){
    console.log('setting questions to page');
    console.log(q);
    var questionsSection = document.getElementById('questions');
    
    for(let x = 0;x < q.length; x++){
        let qDiv = document.createElement('div');
        qDiv.innerHTML = "Q: " + q[x].question + " A: " + q[x].answer;
        questionsSection.appendChild(qDiv);
    }
}
