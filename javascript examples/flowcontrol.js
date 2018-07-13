console.log('flow control js file loaded!');

/*
 == is comparison   - type coercion: converts second argument to the datatype of the first then compares.
 === comparison and dataty[e check]-

 e.g. 5=="5" will be true
      5 === "5" coerce 
*/
var myBoolean = true;


function foo(){
if( myBoolean ==true){
    console.log('my boolean is true');
    myBoolean = false;
}else if ( myBoolean == false) {
    console.log('my boolean is false');
    myBoolean = true;
}else {
    console.log('my boolean is no longer true/false')
    }
}

function compareXandY(x,y){
    if( x == y){
        console.log('x does = y');
    } else console.log('x does not = y')
}
// 7-15-4

function compareFour(a, b, c, d){
// compare a == b, c == d
if(a == b && c == d){
    console.log('a = b and c = d');
}else if(a != b && c != d ){
    console.log('a does not = b and c != d')
}else if (a == b || c == d){
    console.log(" One of these two are equivalent.")
}

}

function whichIsBigger(a, b){
    if ( a > b ){
        return a;
    }else if ( a < b ){
        return b;
    }else {
        return "equal"
    }
}

/*

truthy / falsy


*/

function isTrue(a){
    if(a){
        return true; // real numbers, true, strings, objects, 
    }else {
        return false; // false, NaN, ""-empty string, null, 0, undefined.
    }
}

var myArray = [ "bob", "tom", "bobbert", "mark" ]
// get the length by: myArray.length property

// Loops

function printMyArray(arr){
    // the for loop is the most popular loop

    //  init;           condition;     after each iteration
    for( var i = 0; i < myArray.length; i++ ){
            console.log("myArray at index " + i + " is " + myArray[i]);
// i + 1 = i++
    }
}