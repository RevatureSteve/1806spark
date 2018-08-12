/*
 i want to count things

    birds

    cars




    solve this issue of sharing a global variable with closure!
        nested functions hold the variables of the outer function 


    // closure is javascripts way of encapsulation!

    */

let count = 0; // global count 


//dynamic function for counting different items/things/whatever
function makeCounter(noun){
    let count = 0; //outer function count 

    function countNoun(){
        return noun + " count is: " + ++count;
    }

    return countNoun;

    
}




function countCar(){
    return "Car count is: " +  ++count;
}