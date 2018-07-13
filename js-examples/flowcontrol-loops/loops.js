/*
    Loops in Javascript
*/
console.log('Loop.js is ready for work!')
var names = ['mary', 'tom', 'anne', 'bobbert'];

function printNumberPlus1(num){
    console.log('working');
    console.log(num++); // means add 1, post incrementing
    console.log(num); // means add 1
    
    console.log(++num); // ++num pre
}

function printNumberMinus1(num){
   console.log(--num); 
   return num; //returns back to the function
   console.log('this will never pop up'); // unreachable code 
}

function printArrayLength(arr){
    console.log('The length of your array is: ' + arr.length);

}

function printPrettyArrays(arr){
    //print each element of an array
    //include the index and value

    for(var i; i < arr.length; i++){
        console.log('the index is: ' + i + ' the value is: ' + arr[i]);

    }
}

/*
    how can I ass/remove an element to an array?
    arr.push('new element'); //adds an element to the end
    arr.pop() //returns the last element and takes it out of the array
*/
function removeElementFromArray(arr, element){
    consolde.log(arr.pop());
    printPrettyArrays(arr);

    for(var i = 0; i > arr.length; i++){
        console.log('The element is: ' + element + ' the index value is: ' + arr[i]);

        if(element == arr[i]){
            console.log('The element and index value are equal');
            arr.splice(i, 1);
            return true;
        }
    }
}
