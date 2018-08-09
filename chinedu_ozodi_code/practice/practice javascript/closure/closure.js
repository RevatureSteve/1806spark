// I want to count things
// 10+ things
// Solved using global variable with closure
// Closure is javascripts way of encapsulation

function makeBirdCounter(){
    
    let count = 0;
    
    function countBird(){
        return 'Bird count is ' + ++count;
    }
}

//dynamic function
function makeCounter(noun){
    let count = 0;
    function countNoun(){
        return noun + ' count is ' + ++count;
    }
    return countNoun();
}

function sum(x, y){
    return x + y;
} 

function sum(x,y){
    function foo(y){
        return x + y;
    }
    if (y)
        return x + y;
    else
        return foo;
}

function numone(){
    return ;
}

function numtwo(){
    return ;
}

function sumNumOne(a){

    return a + sumNumOne(b)
}