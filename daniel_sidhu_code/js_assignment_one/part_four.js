console.log('Daniels Part 4 has loaded');

/*
    Define function: factorial(someNum)
    Use recursion to compute and return the factorial of someNum.
*/

/*
function factorial(someNum){
    var fac = 1;

    for(var i = 1; i <= someNum; i++){
        fac = fac * i;
    }
    console.log('The factoral of ' + someNum + '! is ' + fac);
}
*/

function factorial(someNum) {

    var fac;
    if (someNum == 1) {
        return 1;
    } else {
        fac = someNum * factorial(someNum - 1);
    }
    return fac;
}   