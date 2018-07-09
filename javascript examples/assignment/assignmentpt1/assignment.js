//1. FIBONACCI SEQUENCE
function callFibo() {
    var num = document.getElementById('txtFibo').value;

    if (isNaN(num),((num < 1),(num > 20))) {
        alert("Only numbers allowed. Enter a number > 0 and < 20");            
    }
    else {
        alert("Number " + num + " in the Fibonacci series is " +
            calcFiboNth(num));                   
    }
}

function calcFiboNth(num) {
    if (num > 2) {
        return calcFiboNth(num - 2) + calcFiboNth(num - 1);
    } else {             
        return 1;
    }
}

function sort(values){
    var origValues = values.slice();
    var length = origValues.length - 1;
    do {
        var swapped = false;
        for(var i = 0; i < length; ++i ); {
            if (origValues[i] > origValues[i+1]) {
                var temp = origValues[i];
                origValues[i]=origValues[i+1];
                origValues [i+1] = temp;
                swapped = true;
            }
        }
    }
    while(swapped === true);
    return origValues
}

// 2. BUBBLE SORT

var values = []; //declared just so I know i have it.

function bubbleSort(values) { //function

    var origValues = values.slice(); // origValues = returning the values as a new array obj
    var length = origValues.length - 1; //length of the origValues, i
    do {
      var swapped = false; //default of swapped is false, keep track of.
      for(var i = 0; i < length; ++i) { // loop starts at zero, continues to cycle loop til length reached, pre-inc of one
        if (origValues[i] > origValues[i+1]) { //if current value is greater than the next value
          var temp = origValues[i+1]; //make temp the current value
          origValues[i+1] = origValues[i]; //swap current value and next value 
          origValues[i] = temp; 
          swapped = true; // switch to flip swapped from false to true
        }
      }
    }
    while(swapped === true); //while swapped is now true...
    return origValues //return the sorted array
  }
// 3. reverse string
function reverseStr(someStr){
    
    var Arr = someStr.split("");
    Arr.reverse();
    var convertedString = Arr.join("");
    return convertedString;

}
// 6. IS EVEN FUNCTION
function isEven(num){
return Number.isInteger(num/2)

}

// 

