//this is part of the monday assignment and is part 2//


console.log('Part 2 has loaded');

//Part 2: FizzBuzz
/*Create an HTML page called fizzbuzz.html with an input box and unordered list.
Create a JavaScript page called fizzbuzz.js and inside the html page reference it.

The user will enter a positive number N.
Print From 0 to N;
Print For each multiple of 3, display "Fizz" instead of the number inside the unordered list of the html page. 
Print For each multiple of 5, display "Buzz" instead of the number inside the unordered list of the html page. 
Print For numbers which are multiples of both 3 and 5, display "FizzBuzz" instead of the number inside the unordered list of the html page.


e.g. Input value = 15 (modifying the ul element to display below)
1
2
fizz
4
buzz
fizz
7
8
fizz
buzz
11
fizz
13
14
fizzbuzz 

*/
var N;
function fizzBuzz(){

    //N =document.getElementById('num').value;
    //var ul = document.getElementById('list');
    var list = [];

    //while (ul.hasChildNodes()) {
    //    ul.removeChild(ul.firstChild);

    for(var i = 0; i < N; i++){

        var x = list.push(i);
        //console.log(x);

        var A = x % 3;
        var B = x % 5;

        if((A == 0) && (B == 0)){
            console.log('fizzbuzz');
        } else
        if(A == 0){
            console.log('fizz');
        } else 
        if(B == 0){
            console.log('buzz');
        } else {
            console.log(x);
        }   
    }
}