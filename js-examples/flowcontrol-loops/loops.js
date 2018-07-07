/*
    Loops in Javascript
*/

var names = ['mary', 'tom', 'anne', 'bobbert'];

function printNumberPlus1(num){
    console.log(num++); //++ means add 1, num++ is post increment
    console.log(num); //++ means add 1

    console.log(++num); //++num pre
}

function printNumberMinus1(num){
    console.log(--num); 
    return num++;
    console.log('after return'); //unreachable code aka bad...
    

    
}

function printArrayLength(arr){
    console.log("The length of your array is: " + arr.length)  //use length property to get the size of an array


}

var names = ['mary', 'tom', 'anne', 'bobbert']; //
var cars = ['mustang', 'civic', 'van', 'corvette']

function printPrettyArrays(arr){
    /*
        print each element of an array
        include the index and value
    */
   for( var i = 0; i < arr.length; i++){    //i++ indicates end of the loop
       console.log("The index is: " + i + " the value is: " + arr[i] + ".");
   }

    // 0<4: index 0 value mary
    // 1<4:index 1 value tom
    // 2<4:index 2 value anne
    // 3<4:index 3 value bobbert

    // how can i return the last element
    // return arr[arr.length-1];
}

//how can i add/remove an element to an array?
//arr.push('new element');  -adds an element to the end
//arr.pop() -- returns the last element and takes it out of the array

function removeElementFromArray(arr, element){
    // console.log('hi');
    // printPrettyArrays(arr);

    for(var i = 0; i < arr.length; i++){
        // console.log("The element is : " + element + " the index value is : " + arr[i]);
        if(element == arr[i]){
            // console.log('the element and index value are equal');
            arr.splice(i,1);
            return true; //stop looking for element, we found it
            // printPrettyArrays(arr);
        }

    }

    return false;
}
