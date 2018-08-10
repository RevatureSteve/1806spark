


function makeCounter(noun){
    let count = 0; 

    function countBird(){
        return noun + " count is " + ++count;
    }

    function countCar(){
        return "Car count is: " + ++count
    }
    return noun;
}

function countBird(){
    return "Bird count is " + ++count;
}

