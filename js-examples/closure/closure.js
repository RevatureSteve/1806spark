/*
    I want to count thinkgs
        birds, cars, etc

    Solve this issue of sharing a global variable with closure
        Nested functions hold the variables of the outer function

    Closure is JS way of encapsulation
*/
let count = 0; //global count

//dynamic function for counting different items
function makeCounter(noun) {
    let count = 0; //outer function count

    function countNoun() {
        return noun + " count is: " + ++count;
    };

    return countNoun;
}