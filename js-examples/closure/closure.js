


/* I w to count things 
        - birds
        -cars
        etc..


    solve this issue of sharing a global variable with closure!
        Nested functions hold the variables of the outer function


    closure is Javascript's way of encapsulation

*/

let count = 0; //outer couter

function countCar(){
    return "Car count is: " + ++count;
}


//make a dynamic function for counting different items/things/whatever
function makeCounter(noun){
    let count = 0;

    function countNoun(){
        return noun + " count is: " + ++count;
    }

    return countNoun;


}

