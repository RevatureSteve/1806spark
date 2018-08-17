/*

I wan to count things
birds
cars 
etc.


Solve this issue of shairg a golabl variable with closure!
    Nested functions hold the variables of the outer function.

    Closure is JavaScript's way of encapsulation.
*/

//gloabal count
let count = 0;
function countCar() {
    return "Car count is " + ++count;
}

//Dynamic function for counting differnce items/things/whatever
function makeCounter(noun) {
    let count = 0;  //outer function count

    function countNoun() {
        return noun + " count is " + ++count;
    }

    return countNoun;
}





