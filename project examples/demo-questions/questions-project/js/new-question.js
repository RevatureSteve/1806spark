/*
    new-question.js
*/

// can't use window.onload again as it is used in the app.js, reference at bottom instead
let url = 'http://localhost:3000/questions';
document.getElementById('questionBtn').addEventListener('click', newQuestion);
function newQuestion(){
    let newQuestionStatus = document.getElementById('newQuestionStatus');
    let question = document.getElementById('questionInput').value;
    let answer = document.getElementById('answerInput').value;
    
    // Post data!
    let data = {
        "question": question,
        "answer": answer
    }

    fetch(url, {
        method: 'POST', // or 'PUT'
        body: JSON.stringify(data), // data can be `string` or {object}! Must be converted to JSON
        headers:{
          'Content-Type': 'application/json'
        }
    }).then(data=> data.json()).then(q => {
            console.log(q);
        newQuestionStatus.innerHTML = q.question + " " + q.answer;
    });
}