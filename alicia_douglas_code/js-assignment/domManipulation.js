/*
11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/

document.getElementById("helloWorld").addEventListener("click", delay)

/* Adds a 3 second delay */
function delay() {
    setTimeout(changeColor, 3000);
}

/* Change font color */
function changeColor() {
    var r = getRandomInt(0, 255);
    var g = getRandomInt(0, 255);
    var b = getRandomInt(0, 255);
    document.getElementById("helloWorld").style.color = "rgb(" + r + "," + g + "," + b + ")";
}

/* A function to return random number from min to max */
function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}


/*
10. Current Time
Regarding this element:
  <h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/

setInterval(time, 1000);

function time() {
    var d = new Date();
    document.getElementById("currentTime").innerHTML = d.toLocaleTimeString();
}

/*
7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/

document.getElementsByName("skills")[0].addEventListener("change", skillMessage);

function skillMessage() {
    var element = document.getElementsByName("skills")[0];
    var selStr = element.options[element.selectedIndex].text;
    alert("Are you sure " + selStr + " is one of your skills?");
}

/*
8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/

var favColor = document.getElementsByName('favoriteColor');
for (var i = 0; i < favColor.length; i++) {
    favColor[i].addEventListener("change", favoriteColor)
}

var color;

function favoriteColor() {
    var previousColor = color;
    for (var i = 0; i < favColor.length; i++) {
        if (favColor[i].checked) {
            color = favColor[i].value;
        }
    };
    for (var i = 0; i < favColor.length; i++) {
        favColor[i].style.backgroundColor = color;
    };
    alert("So you like " + color + " more then " + previousColor + " now?");
}


/*
6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
	<h3>Sum: <span id="sum"></span></h3>

Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element
*/

document.getElementById("num1").addEventListener("change", sum);
document.getElementById("num2").addEventListener("change", sum);

function sum() {
    var num1 = parseInt(document.getElementById("num1").value);
    var num2 = parseInt(document.getElementById("num2").value);
    var total = num1 + num2;
    if (isNaN(total)) {
        document.getElementById("sum").innerHTML = "Cannot add";
    } else {
        document.getElementById("sum").innerHTML = total;
    }
}

