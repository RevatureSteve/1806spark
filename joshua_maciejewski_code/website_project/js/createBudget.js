




document.getElementById('budgetInput2').addEventListener('change', incomeCruncher);
document.getElementById('budgetBtn').addEventListener('click', newBudget);


function incomeCruncher(){
    let income = document.getElementById('income').value;
    let amount = document.getElementById('budgetInput2').value;
    var newTotal = income - amount;

        console.log(newTotal);
        
        

        if(newTotal < 0) {
            alert("Remaining income cannot be negative!");
            document.getElementById('income').value = income;
            document.getElementById('budgetInput2').value= ""

        }else{
            document.getElementById('income').value = newTotal;
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
    method: 'POST', 
    body: JSON.stringify(data), 
    headers:{
      'Content-Type': 'application/json'
    }
}).then(data=> data.json()).then(b => {
        console.log(b);
    budgetStatus.innerHTML = b.expense + " " + b.amount;
});
}


// document.getElementById('budgetInput').select();