/*
    new-question.js
*/

// can't use window.onload again as it is used in the app.js, reference at bottom instead

let url = 'http://localhost:2001/viewBudget';
document.getElementById('budgetBtn').addEventListener('click', newBudget);
function newBudget(){
    let budgetStatus = document.getElementById('budgetStatus');
    let budget = document.getElementById('budgetInput').value;
    let answer = document.getElementById('budgetInput2').value;

let data = {
    "budget": budget,
    "answer": answer
}

fetch(url, {
    method: 'POST', // or 'PUT'
    body: JSON.stringify(data), // data can be `string` or {object}! Must be converted to JSON
    headers:{
      'Content-Type': 'application/json'
    }
}).then(data=> data.json()).then(b => {
        console.log(b);
    budgetStatus.innerHTML = b.budget + " " + b.answer;
});
}