<<<<<<< HEAD
/*
    i wanna count things
    birds
    cars
    10+ things
    etc
*/
// let count = 0;
// function makeBirdCounter() {
//     let count = 0;

//     function countBird() {
//         return "Bird count is: " + ++count;
//     }

//     return countBird;
// }

function makeCounter(noun){
    let count = 0;

    function countNoun(){
        return noun + ' count is: ' + ++count;
    }

    return countNoun;
}


// function countCar() {
//     return "Car count is: " + ++count;
// }
=======

/*
    I want to count things
        birds
        cars
        10+ things
        etc

    Solve this issue of sharing a global variable with closure!
        Nested functions hold the variables of the outer function

    Closure is JavaScript's way of encapsulation!
*/

let count = 0; // global count
function countCar(){
    return "Car count is: " + ++count;
}


//dynamic function for counting different items/things/whatever
function makeCounter(noun){
    let count = 0; // outer function count

    function countNoun(){
        return  noun + " count is: " + ++count;
    }

    return countNoun;

}


function sum(x,y){
    function foo(y){
        return x + y;
    }
    return foo(y);
}
>>>>>>> f963ce3a5c8899ea111b471162fbbacadb3bb589
