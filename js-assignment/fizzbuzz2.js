//this is part of the monday assignment and is part 2//


console.log('Part 1.1 has loaded');

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


document.getElementById('button').addEventListener('click', fizzbuzz);
/* this is my event listener. I get the element with the eventlistener 
    within the () I put the event, what i want to apply it to
*/

// function clearList() {
//     var list = document.getElementById('list').childNodes;
//     list.remove;
    
// }

function fizzbuzz() {
    console.log('click');
    var list = document.getElementById('list');
    // ^ object to represent the ul within the html


    var N1 = document.getElementById('input1').value;
    var N2 = document.getElementById('input2').value;
    // ^ string for the html

    if (N2 > N1) {
        N1biggerthanN2();
    } else {
        N2biggerthanN1();
    }



    function N1biggerthanN2() {

        for (var i = N1; i <= N2; i++) {
            console.log('worked');
            var x = document.createElement('li')
            //^ used to create the information of the list

            //console.log(x);

            var A = i % 3;
            var B = i % 5;

            if ((A == 0) && (B == 0)) {
                x.innerHTML = 'fizzbuzz';
            } else
                if (A == 0) {
                    x.innerHTML = 'fizz';
                } else
                    if (B == 0) {
                        x.innerHTML = 'buzz';
                    } else {
                        x.innerHTML = i;
                    }
            list.appendChild(x);
        }
    }

    function N2biggerthanN1() {

        for (var i = N2; i <= N1; i++) {
            console.log('worked');
            var x = document.createElement('li')
            //^ used to create the information of the list

            //console.log(x);

            var A = i % 3;
            var B = i % 5;

            if ((A == 0) && (B == 0)) {
                x.innerHTML = 'fizzbuzz';
            } else
                if (A == 0) {
                    x.innerHTML = 'fizz';
                } else
                    if (B == 0) {
                        x.innerHTML = 'buzz';
                    } else {
                        x.innerHTML = i;
                    }
            list.appendChild(x);
        }
    }
}