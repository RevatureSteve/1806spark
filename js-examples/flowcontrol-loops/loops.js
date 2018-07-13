/*
    Loops in Javascript
*/
console.log('loop.js ready for work!');


function printNumberPlus1(num){
console.log(num++); 
console.log(num); 

console.log(++num); 

}

function printNumberMinus1(num){ //should be 5
    console.log(num--);
    console.log(num);
    console.log(num--);
    return num;
    console.log('after return'); //unreachable code aka bad...because after return
}

function printArrayLength(arr){
    console.log ("The length of your array is:" + arr.length);
}


var names = ['mary', 'tom', 'anne', 'bobbert'];
function printPrettyArrays(arr){
// Print each element of an array, include the index and value
for(var i =0; i < arr.length; i++){
    console.log("The index is:" + i + "the value is " + arr[i] +".");
} 
return arr[arr.length-1];
}

// how can i add/remove an element to an array
// arr.push('new element'); // adds an element to the end
//arr.pop() //returns the last element and takes it out of the array


function removeElementFromArray(arr, element){
    // console.log('hi');
    // printPrettyArrays(arr);
    
    for (var i = 0; i < arr.length; i++ ){
        // console.log('the element is :' + element + "the index value is:" + arr[i]);
        if(element == arr [i]){
            // console.log('****the element and index value are equal********');
            arr.splice(i,1);
            return true; //stop looking for element, we found it!
            // printPrettyArrays(arr);
        }
    }
    return false;   
    // arr.splice(1, 1);
}
