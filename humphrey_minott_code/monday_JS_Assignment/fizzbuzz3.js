 var w = 0;
 var z = 0;
 var inputValue;
 var inputValue2;

function print() {

    inputValue = parseInt(document.getElementById("inputNum").value);
    inputValue2 = parseInt(document.getElementById("inputNum2").value);
    var unorderedLi = document.getElementById("unordered");
    // var listItem = document.createElement("li");
 
    if(inputValue < inputValue2){
 
    for(inputValue; inputValue <= inputValue2; inputValue++){
     listItem = document.createElement("li");
     unorderedLi.appendChild(listItem);
     if (inputValue % 5 == 0 && inputValue % 3 == 0 && inputValue !== 0){
         document.getElementsByTagName("li")[w].innerHTML= "FizzBuzz";
     }
     else if (inputValue % 5 == 0 && inputValue !== 0){
         document.getElementsByTagName("li")[w].innerHTML= "Buzz";
     } 
     else if (inputValue % 3 == 0 && inputValue !== 0){
         document.getElementsByTagName("li")[w].innerHTML= "Fizz";
     } 
     else {
     document.getElementsByTagName("li")[w].innerHTML= inputValue;
     }
     w++;
    }
 }
 else if(inputValue2 < inputValue){
 
    for(inputValue2; inputValue2 <= inputValue; inputValue2++){
     listItem = document.createElement("li");
     unorderedLi.appendChild(listItem);
     if (inputValue2 % 5 == 0 && inputValue2 % 3 == 0 && inputValue2 !== 0){
         document.getElementsByTagName("li")[z].innerHTML= "FizzBuzz";
     }
     else if (inputValue2 % 5 == 0 && inputValue2 !== 0){
         document.getElementsByTagName("li")[z].innerHTML= "Buzz";
     } 
     else if (inputValue2 % 3 == 0 && inputValue2 !== 0){
         document.getElementsByTagName("li")[z].innerHTML= "Fizz";
     } 
     else {
     document.getElementsByTagName("li")[z].innerHTML= inputValue2;
     }
     z++;
    }
 }

}
 document.getElementById("butn").addEventListener("click",print);

