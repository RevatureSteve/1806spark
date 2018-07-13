/*
    Loops in Javascript
*/
console.log("loop.js ready for work!");
var names = ['mary', 'tom', 'anne', 'bobbert'];

function printNumberPlus1(num){
    console.log(num++); //++ adds 1, post increment
    console.log(num);


    console.log(++num);
}

function printNumberMinus1(num){
    console.log(--num);
    return ++num //increment then return
    console.log("hi"); //unreachable code
    
}

function printArrayLength(arr){

console.log("The length of your array is: " + arr.length);
}

var names = ["mary", "tom", "anne", "bobbert"];
function printPrettyArrays(arr){

    // print each element of an array include the index and value

    for( i=0; i<arr.length;i++) {

        console.log("The index is: " + i + ", and the value is " + arr[i] + ".")
    }

}

/*
    How can I add/remove an element to an array?
    arr.push("name")
    arr.pop removes the last element in the index
    */

function removeElementFromArray(arr, element){
    var names = ["mary", "tom", "anne", "bobbert"];
    // printPrettyArrays(arr)

    for(var i=0; i < arr.length;i++){
    console.log("The element is: " + element + " the index value is: " + arr[i])
        if(element == arr[i]) {
            console.log("The element and index value are equal")
            arr.splice(i,1);
            printPrettyArrays(arr)
            return true
        }
    }

    return false;

}
