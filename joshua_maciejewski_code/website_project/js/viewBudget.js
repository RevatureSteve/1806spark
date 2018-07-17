/*
    questions.js
*/
// No window.onload it has already been used by app.js

let port = 2001;
window.onload = function() {
    // get navbar html fragment
    setBudget();
    
}

var url = 'http://localhost:2001/viewBudget';
var budget = null;
callBudget();

function callBudget(){
    fetch(url)
    .then((resp) => {
        return resp.json();
    })
    .then((data) => {
        console.log(data);
        budget = data;
        setBudget(budget);
    })
}

function setBudget(b){
    console.log('setting budget to page');
    console.log(b);
    var budgetSection = document.getElementById('budget');

    for(let x = 0; x< b.length; x++){
        let bDiv = document.createElement('div');
        bDiv.innerHTML = "budget: " + b[x].expense + " money: " + b[x].amount;
        budgetSection.appendChild(bDiv);
    }
}