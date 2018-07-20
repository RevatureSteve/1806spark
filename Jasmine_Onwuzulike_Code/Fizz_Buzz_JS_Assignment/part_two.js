



function getInput2() {
    //Get values of inputs.
var x = document.getElementById("first").value;
var y = document.getElementById("second").value;
var list = document.getElementById("demo");
var count = [];

if ( x < y) {
    for (var i = x; i <= y; i++) {
        console.log(i);
        count.push(i);
        
    }
}
else if ( y < x) {
   for (var i = y; i <= x; i++) {
       console.log(i);
       count.push(i);
       count.sort(function(a,b) {
          return b-a
       })

       }
   }
count.forEach(checkForMultiples);

function checkForMultiples(value, index, array) {
    if (value % 3 == 0 && value % 5 == 0) {
        value += "fizzbuzz";
    }
    else if (value % 3 == 0) {
        value += "fizz";
    }
    else if (value % 5 == 0 ) {
        value += "buzz";
    }
}

   console.log(count);


   let listItem = document.createElement("li");
   listItem.innerHTML = count;
   list.appendChild(listItem);


};
