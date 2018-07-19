// ACTUAL PART 2
var fizzbuzzInput1;
var fizzbuzzInput2;
window.onload = () =>{
    fizzbuzzInput1 =  document.getElementById("fizzbuzzInput1");
    fizzbuzzInput2 =  document.getElementById("fizzbuzzInput2");

    fizzbuzzInput1.addEventListener('input', fizzbuzz);
    fizzbuzzInput2.addEventListener('input', fizzbuzz);

    fizzbuzz();
}

function fizzbuzz(){
    let fizzbuzzUl = document.getElementById("fizzbuzzUl");
    let fizz1 = parseInt(fizzbuzzInput1.value);
    let fizz2 = parseInt( fizzbuzzInput2.value);

    // Set min and maxes
    fizzbuzzInput1.max = fizz2 - 1;
    fizzbuzzInput2.min = fizz1 + 1;
    

    //Delete all previous li
    for(let i = fizzbuzzUl.childNodes.length-1; i > 0; i--){
        fizzbuzzUl.removeChild(fizzbuzzUl.childNodes[i]);
    }

    //Create new li
    for(let i = fizz1; i <= fizz2; i++){

        let ulNode = document.createElement("li");
        let outputString = "";

        if (i % 3 == 0){
            outputString += "Fizz";
        }

        if (i % 5 == 0){
            outputString += "Buzz";
        }

        if (!outputString){
            outputString += i;
        }
        if (i == 50){
            outputString  += " (I could go on forever)";
        }

        fizzbuzzUl.appendChild(ulNode);
        ulNode.innerHTML = outputString;
    }
}