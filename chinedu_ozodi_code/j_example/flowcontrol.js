console.log("flow control js file loaded");

var myBolean = true;
function foo(){
    if( myBolean == true){
        myBolean = false;
        console.log("my bolean is true");
    }
    else if (myBolean == false){
        myBolean = true;
        console.log("my bolean is false");
    }
    else{
        console.log("not a bolean");
    }
}

function compareXAndY(x,y){
    if (x == y){
        console.log('x == y');
    }
    else{
        console.log('x != y');
    }
}

function compareFour(a,b,c,d){
    // compare a == b AND b == c
    if (a ==b && b == c){
        console.log('they are equal');
    }
}

function whichIsBigger(a,b){
    //use return
}

/*
    truthy/falsey
        - always has to evaluate to true or false
        - falsey: null, NaN, 0, undefined
        - truthy: objects, number (except 0), strings (unless empty);
*/

var myArray = ["bob", "tom",'bobbert', 'mark'];