


function fizzbuzz2() {

    let inputValue = parseInt(document.getElementById("num").value); //turn whatever is inside of "num" into a number
    let inputValue2 = parseInt(document.getElementById("numfizz").value);// do the same to numfizz
    let unorderedLi = document.getElementsByTagName("ul")[0];//getting everything inside the unordered list (1 item)

    //THIS FUNCTION PERFORMS A SWITCH
    if (inputValue2 < inputValue) { // if inputValue 2 is less that inputValue
        let temp = inputValue;//then create a temporary container for inputValue
        inputValue = inputValue2;// take input value 2 and put it inside of inputvalue
        inputValue2 = temp;// put temp inide of input value 2

        // temp(3) switched with 1,
        // 1 switched with 2,
        //2 switched with temp,

    }


    for (var counter = inputValue; counter <= inputValue2; counter++) { // for every time the variable counter is less than or equal to input value 2
        let listItem = document.createElement("li");// create a list item
        unorderedLi.appendChild(listItem);//puts listItem inside of that unordered list 
        if (counter % 5 == 0 && counter % 3 == 0 && counter !== 0) {// if number is not 0 and the number is divisible by 5 and 3 then print 0
            listItem.innerHTML = "FizzBuzz"; //display fizzbuzz
        }
        else if (counter % 5 == 0 && counter !== 0) { // if the number is divisible by 5 and not zero
            listItem.innerHTML = "Buzz";//print buzz
        }
        else if (counter % 3 == 0 && counter !== 0) { // if the number is divisible by 3 and not zero
            listItem.innerHTML = "Fizz";//display fizz as a list item
        }
        else { // if not then just print the number to the screen
            listItem.innerHTML = counter;
        }
        
    }

}

document.getElementById("button").addEventListener("click", fizzbuzz2) // do the function fizzbuzz2
 //when I click the button 