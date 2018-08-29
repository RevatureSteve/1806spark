
/*
      I want to count things
         birds
         cars
         10+ things
         etc

         Solve this issue of sharing a global variable with closure!
               Nested functions hold the variables of the outer function
        Closure is JavaScript's way of Encapsulation

*/
let count = 0; // global count
function countCar(){
    return "Car count is: " + ++count;
}


//dynamic function for counting different items/thing/whatever
function makeCounter(noun){
let count = 0; // outer function count

   function countNoun(){
    return noun + " count is: " + ++count;
   }
    return countNoun;
}
