
/*
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
function countCar(){
    return "Car count is: " + ++count;
}


//dynamic function for counting different items/things/whatever
function makeCounter(noun){
    let count = 0;

    function countNoun(){
    
        return noun + "count is: " + ++count;
    }

    return countNoun;

}





