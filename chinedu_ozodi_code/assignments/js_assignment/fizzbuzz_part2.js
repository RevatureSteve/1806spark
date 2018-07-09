// PART 2

function fizzbuzz(){
    let fizzbuzzUl = document.getElementById("fizzbuzzUl");
    let newLiCount = document.getElementById("fizzbuzzInput").value;
    //Delete all previous li
    for(let i = fizzbuzzUl.childNodes.length-1; i > 0; i--){
        fizzbuzzUl.removeChild(fizzbuzzUl.childNodes[i]);
    }

    //Create new li
    for(let i = 1; i <= newLiCount; i++){

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