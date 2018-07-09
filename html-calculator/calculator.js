/*
    calculator js
*/

console.log('calculator js!');
document.getElementById('one').addEventListener("click", cal);

var num1 = document.getElementById('num1');
var num2 = document.getElementById('num2');
var answer = document.getElementById('answer');

var step = 1;
var tempNum1 = null;
var tempNum2 = null;
var tempOperator = '+';

function cal(e) {
    console.dir(e);
    console.log(e.target);
    console.log(e.target.id);
    console.log(e.target.value);

    if(step == 1){
        tempNum1 = e.target.value;
        num1.innerHTML = e.target.value;
        step++;
    }else if(step == 2){
        tempNum2 = e.target.value;
        num2.innerHTML = e.target.value;
        step++
    }else if(step == 3){
        answer.innerHTML = parseInt(tempNum1) + parseInt(tempNum2);
        step = 1;
    }
}