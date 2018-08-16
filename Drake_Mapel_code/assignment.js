// start with first two elements, 1 and 1
// process -- add last two elements and return their sum

// given nth fib number to land on and return
// array with four elements
// or, remember last and current element

// code for non-viable input
// might want to start with 0 in the future
function fib(n) {
    var j = 1;
    var k = 1;
    // placeholder
    var p = 1;
    for (var i = 3; i <= n; i++) {
        // explain
        p = j + k;
        j = k;
        k = p;
    }
    return p;
}

// *******************************************************

function bubbleSort(numArray) {
    var j;
    do {
        j = 0;
        // numArray.length - 1 since the last element in the array won't have a next element to be compared to
        for ( i = 0; i < numArray.length - 1; i++ ) {

            if ( numArray[i] > numArray[i+1] ) {
                p = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = p;
            } else j++;
        }
    } while ( j < numArray.length - 1)

    return numArray;
}

// ***************************************************

function reverseStr(someStr) {
    var l = someStr.length, revStr = "";
    while ( l > 0 ) {
        l--;
        revStr = revStr.concat( someStr.charAt( l ) );
    }

    return revStr;
}

// **************************************

function factorial(someNum) {
    if ( someNum > 1 ) {
        someNum = someNum * factorial(someNum - 1);
    }
    return someNum;
}