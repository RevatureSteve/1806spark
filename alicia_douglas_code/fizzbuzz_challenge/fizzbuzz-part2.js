/*
Part 2 
Create a 2nd input box
Instead of 0, use both the input boxes to display N to N with requirements of Part 1
*/

document.getElementById("fizzBtn").addEventListener("click", printN);

function printN(){
    var liLength = document.getElementsByTagName("li").length;
    var ul = document.getElementsByTagName("ul")[0];
    for (var i = 0; i < liLength; i++){
        ul.removeChild(ul.childNodes[1]);
    }
    let num1 = parseInt(document.getElementById('num1').value);
    let num2 = parseInt(document.getElementById('num2').value);
    for (var i = num1; i <= num2; i++){
        var value = "";
        if(i % 3 == 0){
            value += "fizz";
        };
        if (i % 5 == 0){
            value += "buzz";
        };
        if (i % 3 != 0 && i % 5 != 0){
            value += i;
        };
        var li = document.createElement("li");
        li.appendChild(document.createTextNode(value));
        ul.appendChild(li);
    };
}