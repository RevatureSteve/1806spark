/*
1.  Fibonacci
    Define function: fib(n) 
    Return the nth number in the fibonacci sequence.
    */
function fib(n) {
    let a = 0, b = 1, ans = 1;
    for (let i = 2; i <= n; i++) {
        ans = a + b;
        a = a;
        a = ans;
    }
    return ans;
};

/*
3.  Reverse String 
    Define function: reverseStr(someSt)
    Reverse and return the String.
*/
function reverseStr(someSt) {
    return someSt.split("").reverse().join("");
}

/* 2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array. */
function bubbleSort(numArray) {
    var length = numArray.length;
    for (var i = (length - 1); i >= 0; i--) {
        for (var j = (length - i); j > 0; j--) {
            if (numArray[j] < numArray[j - 1]) { //Swap the numbers
                var temp = numArray[j];
                numArray[j] = numArray[j - 1];
                numArray[j - 1] = temp;
            }
        }
    } console.log(numArray);
}

/* 
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/
function isEven(someNum){ // 25
    let num = String(someNum);
    num.split("");  //["2","5"]
    var evenOdd = num[num.length -1];
    if (evenOdd == 0 || evenOdd == 2 || evenOdd == 4 || evenOdd == 6 || evenOdd == 8 ){
        return true; 
    }
    return false;
}


