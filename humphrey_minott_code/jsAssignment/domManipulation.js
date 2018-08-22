/*1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/


function getUSA() {

    printUSA = document.getElementsByTagName("span");
    console.log(printUSA[2].innerHTML);
}

/*2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/

function getPeopleInSales() {
  var x = document.getElementsByTagName("td");
    console.log("The people in sales are: " + x[0].innerHTML + ", " + x[4].innerHTML + ", " +x[8].innerHTML + ", " + x[10].innerHTML)
}

/*3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span> */

function getAnchorChildren(){

    var x= document.getElementsByTagName("a");
    firstSpanChild = x[6].innerHTML;
    secondSpanChild = x[8].innerHTML;
    thirdSpanChild = x[9].innerHTML;
    fourthSpanChild = x[11].innerHTML;
    console.log(firstSpanChild);
    console.log(secondSpanChild);
    console.log(thirdSpanChild);
    console.log(fourthSpanChild);
}

/* 4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents. */

function getHobbies(){

var x = document.getElementsByTagName("option");
console.log("The selected hobbies in the select element are: " + x[6].innerHTML + ", " + x[7].innerHTML + ", and " + x[9].innerHTML)

}

/* 5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute. */

function getCustomAttribute(){

    var x = document.querySelectorAll("span[data-customAttr]");
    var y = document.querySelectorAll("input[data-customAttr]");
    var z = document.querySelectorAll("td[data-customAttr]");
    console.log("Here are all the data-customAttr attributes and their values: ") 
    console.log(x[0].getAttribute("data-customAttr"));
    console.log(x[1].getAttribute("data-customAttr"));
    console.log(y[0].getAttribute("data-customAttr"));
    console.log(y[1].getAttribute("data-customAttr"));
    console.log(z[0].getAttribute("data-customAttr"));v
}

/* 6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
    <h3>Sum: <span id="sum"></span></h3> */


    x = document.getElementById("num1")
    y = document.getElementById("num2")
    
    x.addEventListener("change", sumEvent);
    
    y.addEventListener("change", sumEvent);
    
   
    function readValue1(){
    
    getValue1= x[0].getAttribute("value");

    return getValue1

    }
    
    function readValue2(){

    getValue2= x[1].getAttribute("value");
    return getValue2
    }

    function sumEvent(){
        x = document.getElementById("num1").value;
        y = document.getElementById("num2").value;
        sum = parseInt(x) + parseInt(y);

        document.getElementById("sum").innerHTML = sum;
    
    }


/* 9. Show/Hide Event
When user hovers over an employees name:
	Hide the name if shown.
    Show the name if hidden. */

x = document.getElementsByClassName("empName");

x[0].addEventListener("mouseover",hide);
x[1].addEventListener("mouseover",hide);
x[2].addEventListener("mouseover",hide);
x[3].addEventListener("mouseover",hide);
x[4].addEventListener("mouseover",hide);
x[5].addEventListener("mouseover",hide);

function hide() {

    x= document.getElementsByClassName("empName");
    x[0].innerHTML = " ";
    x[1].innerHTML = " ";
    x[2].innerHTML = " ";
    x[3].innerHTML = " ";
    x[4].innerHTML = " ";
    x[5].innerHTML = " ";
    

}
