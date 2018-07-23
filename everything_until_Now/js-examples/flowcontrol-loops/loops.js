/*
    Loops in Javascript
*/
console.log("look.js ready for work")
var names = ['mary', 'tom', 'anne', 'bobbert'];

function printNumberPlus1(num) {
    console.log(num++)  // ++ mean add one, numm++ is apost incremnet... ++num pre increment 
    console.log(num)  // ++ mean add one
    console.log(++num)  // ++ mean add one
}

function printNumberMinus1(num) {
    console.log(--num);  // -- mean minus one, numm-- is apost decremnet
    console.log(num);
    console.log(num--);
    return num;
    console.log("after return");// unreachable code aka bad

}

// var nu= [1, 2, 3, 4, , 5, 6] runin colsole before calling function
function printArrayLength(arr) {
    console.log("the length of the arr is: " + arr.length);

    // 
}
var names = ["mary", "tom", "anne"]
function printPrettyArrays(arr) {
    /*
        print each e;lent array of an array
        include the index value
    */
    for (var i = 0; i < arr.length; i++) {
        console.log("The index is: " + i + "tHE value is: " + arr[i] + ".")
        // 1<3 - "hello"
        // 2 < 3 - "hello"
        // 3<3 - "nothig"

        return arr[arr.length - 1];
    }
}


/*
       how can i add/ remove an element to an array
       arr.push("new element"); // add an element to the end
       arr. pop() /// retuen the last lement and take it out of the arry

   */

function removeElementFromArray(arr, element) {

   // console.log("hi");
   // printPrettyArrays(arr);
    for (var i=0; i < arr.length; i++) {
        //console.log("The element is: " + element + "tHE index value is: " + arr[i] + ".")
        if(element == arr[i]){
            
            //console.log("the element and index value are equal")
            arr.splice(i, 1);
            return true; 
        }
    }
   // arr.splice()

}
