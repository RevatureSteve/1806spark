/*
    new-question.js
*/

// can't use window.onload again as it is used in the app.js, reference at bottom instead


document.getElementById('budgetInput2').addEventListener('change', incomeCruncher);
document.getElementById('budgetBtn').addEventListener('click', newBudget);


function incomeCruncher(){
    let income = document.getElementById('income').value;
    let amount = document.getElementById('budgetInput2').value;
    var newTotal = income - amount;

        console.log(newTotal);
        
        document.getElementById('income').value = newTotal;

        if(newTotal >= 0) {
             document.getElementById('remainingInc').innerHTML = "good";
        }else{
            alert("Remaining income cannot be negative!")
        }
        


}






var url = 'http://localhost:2001/viewBudget';
// document.getElementById('budgetBtn').addEventListener('click', newBudget);
function newBudget(){
    var budgetStatus = document.getElementById('budgetStatus');
    var expense = document.getElementById('budgetInput').value;
    var amount = document.getElementById('budgetInput2').value;


    

var data = {
    "expense": expense,
    "amount": amount
}



fetch(url, {
    method: 'POST', // or 'PUT'
    body: JSON.stringify(data), // data can be `string` or {object}! Must be converted to JSON
    headers:{
      'Content-Type': 'application/json'
    }
}).then(data=> data.json()).then(b => {
        console.log(b);
    budgetStatus.innerHTML = b.expense + " " + b.amount;
});
}
