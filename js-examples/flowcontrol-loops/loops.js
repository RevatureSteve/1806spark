/*
    Loops in Javascript
*/
console.log ('loops is loaded!');


function printNumberPlus1(num){
    console.log(++num);
}

function printNumberMinus1(num){
    console.log(--num);
}

function printArrayLength(arr){
   console.log('The lenght of your array is: ' + arr.length);
}
var names = ['mary', 'tom', 'anne', 'bobbert'];

function printPrettyArrays(arr){
    //print each element of an array, include the index and value
    for (var i = 0; i < arr.length; i++)
    {
        console.log('The index is: '+ i + ' the value is: ' + arr[i] + '.');
    }

}

function removeElementFromArray(arr, element){

    for(var i=0; i < arr.length; i++)
    {
        console.log("The element is: " + element + " the index value is: " + arr[i]);
        if (element == arr[i])
        {
            console.log('the element and index value are equal');
            arr.splice(i,1);
            return true; // stop looking for the element, we found it
            printPrettyArrays(arr);
        }
    }
    return false; // stop looking for the element, we could not find it
   
}
