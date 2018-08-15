
/*
<<<<<<< HEAD
Iwant to count things
    birds
    cars
    10+things
    etc

Solve this issue of shating a global variable with closure!
    Nested functions hold the variables of the outer function

Closure is Javascript's way of encapsulation!
*/

let count = 0; //global count
=======
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
>>>>>>> 96a3cef7a318d158b57fa6b631d5de2e88dffb70
function countCar(){
    return "Car count is: " + ++count;
}


//dynamic function for counting different items/things/whatever
function makeCounter(noun){
<<<<<<< HEAD
    let count = 0;

    function countNoun(){
    
        return noun + "count is: " + ++count;
=======
    let count = 0; // outer function count

    function countNoun(){
        return  noun + " count is: " + ++count;
>>>>>>> 96a3cef7a318d158b57fa6b631d5de2e88dffb70
    }

    return countNoun;

}


<<<<<<< HEAD



=======
function sum(x,y){
    function foo(y){
        return x + y;
    }
    return foo(y);
}
>>>>>>> 96a3cef7a318d158b57fa6b631d5de2e88dffb70
