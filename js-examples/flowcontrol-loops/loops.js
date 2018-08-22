/*
    Loops in Javascript
*/
<<<<<<< HEAD
console.log('loop.js ready for work!')


function printNumberPlus1(num){
    console.log(num++); // ++ means add 1, num++ is post increment
    console.log(num);

    console.log(++num); // pre increment
=======
console.log('loop.js ready for work!');


function printNumberPlus1(num){
    ++num; //++ means add 1, num++ is post increment
    console.log(num); //++ means add 1

    console.log(++num); //++num pre
>>>>>>> 150ae089dc796e1fd85d51541da637eb19e228a4
}
                        // 5
function printNumberMinus1(num){
<<<<<<< HEAD
    console.log(--num);
    return ++num;
    console.log('after return'); // unreachable code aka bad
}

function printArrayLength(arr){ // this is a function
    console.log('The length of your array is: ' + arr.length) // arr.length is a property
}
var names = ['mary', 'tom', 'anne', 'bobbert'];
=======
    console.log(num--); // 5 printed
    console.log(num); // 4 printed
    console.log(num--); // 4 
    return num; // 3
    console.log('after return'); // unreachable code aka bad..
}

function printArrayLength(arr){
    console.log("The length of your array is: " + arr.length);
}
var names = ['mary', 'tom', 'anne', 'bobbert']; // length? 4
>>>>>>> 150ae089dc796e1fd85d51541da637eb19e228a4
function printPrettyArrays(arr){
    /*
        Print each element of an array
        Include the index and value
    */
<<<<<<< HEAD
   for(var i = 0; i < arr.length; i++){
       console.log('The index is: ' + i + ' the value is: ' + arr[i] + '.');
   }

   return arr[arr.length-1]
}
/*
    how can I add/remove an element to an array?
    arr.push('new element'); // adds an element to the end
    arr.pop() // returns the last elemnt and takes it out of the array
*/
=======

   for( var i = 0; i < arr.length; i++){
     console.log("The index is: " + i + " the value is: " + arr[i] + ".");
   }
   // 0 < 4: index 0 value mary
   // 1 < 4: index 1 value tom
   // 2 < 4: index 2 value anne
   // 3 < 4: index 3 value bobbert

   // how can I return the last element
   return arr[arr.length-1];

}
/*
    how can I add/remove an element to an array?
    arr.push('new element'); //adds an element to the end
    arr.pop() //returns the last element and takes it out of the array
>>>>>>> 150ae089dc796e1fd85d51541da637eb19e228a4

*/

                                        // "tom"
function removeElementFromArray(arr, element){
    // console.log('hi');
    // printPrettyArrays(arr);

    for(var i = 0; i < arr.length; i++){
<<<<<<< HEAD
        console.log("The element is: " + element + " the index value is: " + arr[i]);
        if(element == arr[i]){
            // console.log("****the element and the index value are equal");
            arr.splice(i, 1);
            return true; // stop looking for the element
=======
        // console.log("The element is : " + element + " the index value is: " + arr[i]);
        if(element == arr[i]){
            // console.log('****element and index value are equal****');
            arr.splice(i,1);
            return true; // stop looking for element, we found it!
>>>>>>> 150ae089dc796e1fd85d51541da637eb19e228a4
            // printPrettyArrays(arr);
        }
    }

    return false;
<<<<<<< HEAD
=======


>>>>>>> 150ae089dc796e1fd85d51541da637eb19e228a4
}


function foo(){
    for(var i = 0; i < 3; i++){
        console.log('hello');
    }
    // 0 < 3: hello
    // 1 < 3: hello
    // 2 < 3: hello;
}