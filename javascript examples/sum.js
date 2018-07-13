// code below is for num1 and num2 input

document.getElementById('sum').addEventListener('click', sum);

function getNum1Value(){
   var num1 = document.getElementById('num1');
   return parseInt(num1.value);
console.log(num1.value);
}

function getNum2Value(){
    var num2 = document.getElementById('num2');
    return parseInt(num2.value);
 console.log(num2.value);
}

function sum(){
    console.log('Click')
    var sumNum1andNum2 = (getNum1Value() + getNum2Value()) ;
    var h2result = document.getElementById('result');
    h2result.innerHTML = sumNum1andNum2;
}

//parseInt() is available to convvert a string to a number

//add an Event Listener to an element
