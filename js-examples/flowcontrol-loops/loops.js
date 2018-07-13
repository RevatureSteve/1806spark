/*
    Loops in Javascript
*/

console.log("loop.js ready for work!");

var names = ['mary', 'tom', 'anne', 'bobbert'];

function printNumberPlus1(num){
    console.log(num++); //post increment
    console.log(num);

    console.log(++num);
}

function printNumberMinus1(num){
    console.log(--num);
}

function printArrayLength(arr){
    console.log("The length of your array is: " + arr.length);
}

function printPrettyArrays(arr){
    for (let i = 0; i < arr.length; i++) {
        console.log('The index is: ' + i + ' the value is: ' + arr[i] + '.');
    }    
}



function removeElementFromArray(arr, element){
    // printPrettyArrays(arr);
    for (let i = 0; i < arr.length; i++) {
        // console.log('The element is : ' + element + ' the index value is: ' + arr[i])
        if (element == arr[i]) {
            // console.log('the element and index value are equal');
            arr.splice(i,1);
            return true; // stop looking for the element, we found it!
            // printPrettyArrays(arr);
        }
    }
    return false;
}
