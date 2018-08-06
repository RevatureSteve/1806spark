/*
    Loops in Javascript
*/
console.log('loop.js ready for work!');

console.log("loop.js ready for work!");

var names = ['mary', 'tom', 'anne', 'bobbert'];

function printNumberPlus1(num){
    console.log(num++); //post increment
    console.log(num);

    console.log(++num);
}
                        // 5
function printNumberMinus1(num){
    console.log(--num);
}

function printArrayLength(arr){
    console.log("The length of your array is: " + arr.length);
}
var names = ['mary', 'tom', 'anne', 'bobbert']; // length? 4
function printPrettyArrays(arr){
    for (let i = 0; i < arr.length; i++) {
        console.log('The index is: ' + i + ' the value is: ' + arr[i] + '.');
    }    
}
/*
    how can I add/remove an element to an array?
    arr.push('new element'); //adds an element to the end
    arr.pop() //returns the last element and takes it out of the array



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


function foo(){
    for(var i = 0; i < 3; i++){
        console.log('hello');
    }
    // 0 < 3: hello
    // 1 < 3: hello
    // 2 < 3: hello;
} */