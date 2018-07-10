
function print3() {

    var inputValue = document.getElementById("num").value;
    var unorderedLi = document.getElementsByTagName("ul")[0];
    var listItem = document.createElement("li");
 
 
 
    for(var counter = 0; counter <= inputValue; counter++){
     listItem = document.createElement("li");
     unorderedLi.appendChild(listItem);
     if (counter % 5 == 0 && counter % 3 == 0 && counter !== 0){
         document.getElementsByTagName("li")[counter].innerHTML= "FizzBuzz";
     }
     else if (counter % 5 == 0 && counter !== 0){
         document.getElementsByTagName("li")[counter].innerHTML= "Buzz";
     } 
     else if (counter % 3 == 0 && counter !== 0){
         document.getElementsByTagName("li")[counter].innerHTML= "Fizz";
     } 
     else {
     document.getElementsByTagName("li")[counter].innerHTML= counter;
     }
    }
 }
 
 document.getElementsByTagName("input")[0].addEventListener("input",print3)
 
 
 
 

 