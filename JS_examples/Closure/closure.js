/*
    I want to count things
        birds
        cars
        etc

        Solve this issue of sharing a global variable with closure!
            Nested functions hold the variables of the outer function

        Closure is javascript's way of encapsulation!
*/

let count = 0;//global count
function countCar() {
    return "Car count is: " + ++count;
}

//dynamic function for counting different items/things/whatever
function makeCounter(noun) {
    let count = 0;//outer function count

    function countNoun() {
        return noun + " count is: " + ++count;
    }
    return countNoun;
}

function sum(x, y) {
    function foo(y) {
        return x + y;
    }
    if (y) {
        return x + y;
    } else {
        return foo;
    }
}