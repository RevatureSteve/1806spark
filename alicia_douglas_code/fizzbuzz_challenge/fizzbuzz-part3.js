/*
Part 3 Allow either box to be larger or smaller number
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
    let start;
    let end;
    if (num1 > num2){
        start = num2;
        end = num1;
    } else {
        start = num1;
        end = num2;
    }
    for (var i = start; i <= end; i++){
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