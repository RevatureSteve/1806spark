/*
    code below is for num1 input
        and num2 input for the sum

    Flow Control:
    
*/

// Add an Event Listener to a an element
document.getElementById('sum').addEventListener('click', sum);

function getNum1Value(){
    var num1 = document.getElementById('num1');
    return parseInt(num1.value);
}
function getNum2Value(){
    var num2 = document.getElementById('num2');
    // parseInt() is available to convert a string to a number
    return parseInt(num2.value); 
}

function sum(){
    console.log('click!!!!!');
    var sumNum1AndNum2 = getNum1Value() + getNum2Value();
    var h2Result = document.getElementById('result');
    h2Result.innerHTML = sumNum1AndNum2;
}





