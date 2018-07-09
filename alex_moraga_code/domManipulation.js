/*1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents*/
function getUSA() {
    var x = document.getElementsByTagName("span"); /*gathers all the span within the document
                            into an array list*/
    var y = x[2].innerHTML; /*setting y as the string contained in the element index 
                            two in the array*/

    console.log(y); //Displays the string contained in y 
}

/*2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.*/

function getPeopleInSales() {
    var x = document.getElementsByClassName("empName");
    console.log("The people in sales are: " + x[0].innerHTML + ", " + x[2].innerHTML + ", " +
        x[4].innerHTML + ", and " + x[5].innerHTML + ".");
}

/*4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.*/

/*9. Show/Hide Event
When user hovers over an employees name:
	Hide the name if shown.
    Show the name if hidden.
var x = document.getElementsByClassName("empName");
onmouseover = "on"
function on() {
    console.log(x[0].innerHTML);
    x[0].innerHTML = " ";
}

x[0].addEventListener("mouseover", on);*/

/*10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.*/

var timer = setInterval(clock, 1000);

function clock() {
    var d = new Date();
    document.getElementById("currentTime").innerHTML = d.toLocaleDateString();
}

/*11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.*/

document.addEventListener("click", changing);
var tyme = setTimeout(changing, 3000);
function changing() {
    var colors = document.getElementById("helloWorld").innerHTML; //obtaining Hello, World
    var blue = colors.fontcolor("red");
    document.getElementById("helloWorld").innerHTML = blue;

}
 //colors.addEventListener("click", changing);



















