console.log('Daniels Assignment 1 is loaded');

/*
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n) {
    var f = 0; //first var declared
    var s = 1; //second var declared
    var sum;   //sum  var declared 

    for (var i = 0; i < n; i++) {
        sum = f + s;
        f = s;
        s = sum;
        console.log('value ' + i + ' is ' + sum); //print statement
    }
    return sum;
}

/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/


/*
    Define function: bubbleSort(numArray)
    Use the bubble sort algorithm to sort the array.
    Return the sorted array.
*/

/*
    if you want to use an Array of any size
    just goto the console and type ' arr =["insert numbers"]; '
    then type ' bubbleSort(arr) ' 
    then run
*/

//you must declare an array within the console to use this code
function bubbleSort(numArray) {
    workingArr = numArray; //used so you are working with the direct user input
    for (var j = 0; j < workingArr.length; j++) { //goes through each array iteration

        for (var i = 0; i < workingArr.length - j; i++) { //goes through a single array iteration

            if (workingArr[i] > workingArr[i + 1]) { //checks to see if the two array locations are true or not
                var t = workingArr[i]; //stores a temporary var for the first array location
                workingArr[i] = workingArr[i + 1]; //switches the second array location to the first one
                workingArr[i + 1] = t; //stores the temporary var to the second arrat location
            }
        }
        console.log('Array ' + workingArr + ' is still sorting'); //prints each line of the sort
    }
    console.log('Array ' + workingArr + ' has been bubbled'); //prints each line of the sort
    return workingArr; //another way to return just the array
}

/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/


/*
    Define function: reverseStr(someStr)
    Reverse and return the String.
*/

// you must declare a string within the console to make the code work
function reverseStr(someStr){
    var newStr = ''; //used to store the new string

    for(var i = someStr.length - 1; i >= 0; i--){
        newStr = newStr + someStr[i]; 
        /*
         the above eq. grabs the last string and prints that letter 
        and moves down 1 after each iteration
        */
    }
    console.log('The reverse string of "' + someStr + '" is "' + newStr + '"');
}

/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/


/*
    Define function: factorial(someNum)
    Use recursion to compute and return the factorial of someNum.
*/

//this code was just used to see how the factorial works 
    //and to compare to the recursion code
/*
function factorial(someNum){
    var fac = 1;

    for(var i = 1; i <= someNum; i++){
        fac = fac * i;
    }
    console.log('The factoral of ' + someNum + '! is ' + fac);
}
*/

function factorial(someNum) {

    var fac;
    if (someNum == 1) {
        return 1;
    } else {
        fac = someNum * factorial(someNum - 1);
    }
    return fac;
}   

/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/


/*
Define function substring(someStr, length, offset)
Return the substring contained between offset 
and (offset + length) inclusively.
If incorrect input is entered, use the alert function 
and describe why the input was incorrect.
*/
