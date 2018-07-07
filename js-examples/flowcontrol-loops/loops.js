console.log("Ready for work");


/*
    Loops in Javascript
*/

var names = ['mary', 'tom', 'anne', 'bobbert'];

function printNumberPlus1(num){
console.log(++ num); 

}

function printNumberMinus1(num){
    console.log(--num);
}

function printArrayLength(arr){
    console.log("The length of your array is " + arr.length);
}

function printPrettyArrays(arr){
for (var i = 0; i < arr.length; i++) {
    console.log("The index is " + i + "and the value is " + arr.value);
}
}

function removeElementFromArray(arr, element){
    console.log("Hi!");
    console.log(arr.pop);
}
