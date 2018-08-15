/**
 * i want to count things
 *  birf
 *  cars
 *  etc
 * 
 * solve this of sharing a global variable with closure!
 *  nexted function hold the variable of the outer function
 * 
 * closure is javascript way of en
 */

 let count = 0;  // available globally

 function countBird(){
     return "bird count is " + ++count;
 }

 function countCar(){
    return "bird count is " + ++count;
}


//solution is 
//dynamic function for counting different items/things/w.e
function makeCounter(){ //outer function

    function countBird(){ // inner function
        return noun + "count is " + ++count;
    }
    return countBird;
   
//     function countCar(){ // inner function
//        return "count is " + ++count;
//    }

//    return countCar;
}