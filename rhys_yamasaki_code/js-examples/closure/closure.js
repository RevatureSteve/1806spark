/*
    I want to count things
        birds
        cats
        etc.


    Solve this issue of sharing a global variable with closure!
        Nested functions hold the variables of the outer function
*/

let count = 0; // global count
function countCar() {
    return "Car count is: " + ++count;
}

function makeCounter(noun) {
    let count = 0; // outer function count

    function countNoun() {
        return noun + "count is: " + ++count;
    }
    return countNoun;
}


/*
        Interview question

        let foobar = sum(2);
        foobar(3) = 5

    sum(2,3) = 5
    sum(2)(3) = 5


    function sum(x,y) {
    function foo(y) {
        return x+y;
    }
    if (y) {
        return x + y;
    } else {
        return foo;
    }
}

*/
