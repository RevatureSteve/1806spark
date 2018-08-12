// /* Counter to count multiple thigs will count all things ++count keeps counting stuff

// to solve the issue of sharing a global variable with closere
// nested functions hold the variables of the outer function



let count = 0;

function countCar(){
    return "Car count is: " + ++count;
}


//dynamic function for ocunting different items
function makeCounter(noun){

    let count =0;

    function countNoun(){
    return  noun +" count is: " + ++count;
    }

return countNoun;

}


