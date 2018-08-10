
/**
 * I want to count things:
 *      birds
 *      cars 
 *      ect
 * 
 * Solve this issue of sharing a global variable with closure!
 *      Nested functions hold the variables of the outer function
 * 
 * Clousre is JavaScript's way of encapsulation
 */

let count = 0;//global variable
function countCar() {
    return "Car count is: " + ++car;
}

//dynamic function for counting different items
function makeCounter(noun) {
    let count = 0;//local variable

    function countBird() {
        return noun + " count is: " + ++count;
    }

    return countNoun;

}


