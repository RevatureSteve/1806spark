 var i = 0;
 var inputValue;
 var inputValue2;

function print() {

    inputValue = parseInt(document.getElementById("inputNum").value);
    inputValue2 = parseInt(document.getElementById("inputNum2").value);
    var unorderedLi = document.getElementById("unordered");
    // var listItem = document.createElement("li");
 
 
    for(inputValue; inputValue <= inputValue2; inputValue++){
     listItem = document.createElement("li");
     unorderedLi.appendChild(listItem);
     if (inputValue % 5 == 0 && inputValue % 3 == 0 && inputValue !== 0){
         document.getElementsByTagName("li")[i].innerHTML= "FizzBuzz";
     }
     else if (inputValue % 5 == 0 && inputValue !== 0){
         document.getElementsByTagName("li")[i].innerHTML= "Buzz";
     } 
     else if (inputValue % 3 == 0 && inputValue !== 0){
         document.getElementsByTagName("li")[i].innerHTML= "Fizz";
     } 
     else {
     document.getElementsByTagName("li")[i].innerHTML= inputValue;
     }
     i++;
    }
 }
 
 document.getElementsByTagName("input")[1].addEventListener("change",print);

