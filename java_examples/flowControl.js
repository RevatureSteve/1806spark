console.log("flow control js file loaded!");

var myBoolean = true;

if(myBoolean == true){
    console.log("my boolean is true");
    myBoolean = false;
} else if (myBoolean == false){
    console.log("my boolean is false");
    myBoolean = true;
}

function compareXandY(x,y){
    if(x==y){
        console.log("x equals y")
    } else{
        console.log("x doesn't equal y")
    }
}

function comparefour(a,b,c,d){
    if (a==b && c==d){
        console.log('a =b and c = d')
    } else if(a != b && c != d ){
        console.log("a doesn't = b, c != d")
    } else if( a == b || c == d){
        console.log("either a=b or c=d")
    } 
}

function whichIsBigger(a,b){
    if (a > b){
        return a;
    } else if(a<b){
        return b;
    } else {
        return "=";
    }
}

/*
    truthy/falsy
*/
function isTrue(a){
    if(a){
        return true; //true, strings, non-zero numbers, objects
    } else {
        return false; //false, empty string, null, NaN, 0, undefined
    }
}




var myArray = ["bob", "mark", "tom", "tony", "jack"];

function printMyArray(arr){
    // the for loop is the most popular loop
    for(var i = 0; i<myArray.length; i++){
        console.log("value of myArray at index: " + i + " is: " + myArray[i]);
    }
}