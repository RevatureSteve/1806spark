/*FizzBuzz
Create an HTML page called fizzbuzz.html with an input box and unordered list.
Create a JavaScript page called fizzbuzz.js and inside the html page reference it.

The user will enter a positive number N.
Print From 0 to N;
Print For each multiple of 3, display "Fizz" instead of the number inside the unordered list of the html page. 
Print For each multiple of 5, display "Buzz" instead of the number inside the unordered list of the html page. 
Print For numbers which are multiples of both 3 and 5, display "FizzBuzz" instead of the number inside the unordered list of the html page.
*/

document.getElementById('data').addEventListener('change', fizzbuzz); // 'data' is the input box, function name being fizzbuzz 
function fizzbuzz()
{
    var liLength = document.getElementsByTagName ('li').length; // the name of the tag is li, which looks for how many there are 
    
    var ul = document.getElementById('renderList'); // getting the ul and naming it by its id
    
    for (var i = 0; i < liLength; i++) // if 'i' is less than the length of the list than i++ (add one)
    {
        ul.removeChild(ul.childNodes[1]); // removes the list previously listed before allowing for the new informtion to be printed
    }
    var n = parseInt(event.target.value); // parseInt converts the string into an integer. Event Target is saying what just called this function, what is the vaule of the funtion and adjust.
    for (var i=1; i <= n; i++){ 
        
        var li = document.createElement('li'); // creating a list
        if (i % 15 == 0) // if 15 has a remainder of 0 than createTextNode "FizzBuzz"
        {
            li.appendChild(document.createTextNode('FizzBuzz'));
        }
        else if (i % 3 == 0){ // if 3 goes into the number with a remainder of 0 than createTextNode "Fizz"
            li.appendChild(document.createTextNode('Fizz'));
        }
        else if (i % 5 == 0) // if 5 goes into thed number with a remainder of 0 than createTextNode "Buzz"
        {
            li.appendChild(document.createTextNode('Buzz'));
        }
        else{ // if the number has a remainder than list the number instead of "Fizz" "Buzz" or "FizzBuzz"
            li.appendChild(document.createTextNode(i));
        }
        ul.appendChild(li);
    }
}