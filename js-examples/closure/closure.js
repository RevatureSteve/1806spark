<<<<<<< HEAD
/*
 i want to count things

    birds

    cars




    solve this issue of sharing a global variable with closure!
        nested functions hold the variables of the outer function 


    // closure is javascripts way of encapsulation!

    */

let count = 0; // global count 
=======

/*
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
function countCar(){
    return "Car count is: " + ++count;
}
>>>>>>> 38121be61b8803b137ff28d6b6958cc4fb8e904b


//dynamic function for counting different items/things/whatever
function makeCounter(noun){
<<<<<<< HEAD
    let count = 0; //outer function count 

    function countNoun(){
        return noun + " count is: " + ++count;
=======
    let count = 0; // outer function count

    function countNoun(){
        return  noun + " count is: " + ++count;
>>>>>>> 38121be61b8803b137ff28d6b6958cc4fb8e904b
    }

    return countNoun;

<<<<<<< HEAD
    
}




function countCar(){
    return "Car count is: " +  ++count;
=======
}


function sum(x,y){
    function foo(y){
        return x + y;
    }
    return foo(y);
>>>>>>> 38121be61b8803b137ff28d6b6958cc4fb8e904b
}