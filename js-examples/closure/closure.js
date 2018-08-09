/*
    i wanna count things
    birds
    cars
    10+ things
    etc
*/
// let count = 0;
// function makeBirdCounter() {
//     let count = 0;

//     function countBird() {
//         return "Bird count is: " + ++count;
//     }

//     return countBird;
// }

function makeCounter(noun){
    let count = 0;

    function countNoun(){
        return noun + ' count is: ' + ++count;
    }

    return countNoun;
}


// function countCar() {
//     return "Car count is: " + ++count;
// }
