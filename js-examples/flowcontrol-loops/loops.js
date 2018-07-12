/*
    Loops in Javascript
*/
console.log("loops.js ready for work!");

function printNumberPlus1(num){
    console.log(num++); // ++ means adds 1 
    console.log(num); //++ means add 1
    

    console.log(++num); // ++num pre
}

function printNumberMinus1(num){
    console.log(--num);
    return ++num;
    console.log('after return') //unreachable code aka bad..

    
}

function printArrayLength(arr){
    console.log("The length of your array is: " + arr.length);

}
var names = ['mary', 'tom', 'anne', 'bobbert'];
function printPrettyArrays(arr){
    for( var i = 0; i < arr.length; i++){
        console.log("The index is: " + i + " the value is: " + arr[i] + ".");
    }
    return arr[arr.length-1];
}



function removeElementFromArray(arr, element){
    // console.log('hi');
    // printPrettyArrays(arr);
    
    for(var i = 0; i <array.length; i++){
        console.log("The element is : " + element + " the index value is: " + arr[i]);
        if(element == arr[i]){
            console.log('the element and index value are equal');
            
        }
    }    
// arr.splice(1)
}
