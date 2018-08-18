// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents

function getUSA() {
    let allElements = document.querySelectorAll("body *");
    for (let i = 0; i < allElements.length; i++) {
        let usaElement = allElements [i];
        if (usaElement.innerHTML.indexOf ("USA") >=0) {
            console.log(usaElement.innerHTML);
        }
    }
}

  
// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.

function getPeopleInSales(){
    var salesPeople = document.getElementsByClassName("empName");
    for (var i = 0; i < salesPeople.length; i++){
        if (salesPeople[i].nextElementSibling.innerHTML == "Sales"){
            console.log(salesPeople[i].innerHTML);
        }
    }
}
  
// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>

function getAnchorChildren(){
    var anchorElements = document.getElementsByTagName("a");
    for(var i = 0; i < anchorElements.length; i++){
        var printSpan = anchorElements[i].getElementsByTagName("span");

        for (var j = 0; j < printSpan.length; j++){
            console.log(printSpan[j].innerHTML);
        }
    }
}
// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.

function getHobbies(){
    var skillsElements = document.getElementsByName("skills");
    for (var x = 0; x < skillsElements.length; x++){
        var skillsElement = skillsElements[x];
        for (var i = 0; i < skillsElement.options.length; i++){
            var option = skillsElement.options[i];
            if(option.selected == true){
                console.log(option.value + "-" + option.innerHTML);
            }
        }
    }
}
  
// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.

function getCustomAttribute(){
    var myElement = document.querySelectorAll('[data-customAttr]');
    console.log(myElement);

}

// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// 	<input id="num1" class="nums" type="text"/>
// 	<input id="num2" class="nums" type="text"/>
// 	<h3>Sum: <span id="sum"></span></h3>

function sumIt() {
    let num1 = document.getElementById("num1");
    let num2 = document.getElementById("num2");

    if(num1.value  != "" && num2.value != "") {
        let sum = parseInt(num1.value) + parseInt(num2.value);

        document.getElementById("sum").innerHTML = sum;
    }
}


// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

document.getElementsByName("skills")[0].onchange = function () {
    var index = this.selectedIndex;
    var text = this.children[index].innerHTML.trim();
    window.prompt("Are you sure " + text + " is one of your skills?");
}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor


// for (var i = 0; i < colors.length; i++) {
//     colors[i].onchange = function () {
//         if (favoriteColor == null) {
//             favoriteColor = this.value;
//         }else {
//             var previousFav = favoriteColor;
//             favoriteColor = this.value;
//             window.alert("You Like " + favoriteColor + " more than " + previousFav + "?");
//         }
//         }
//     }



// 9. Show/Hide Event
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.


// var employees = document.getElementsByClassName("empName");

// for (var i = 0; i < emmployees.length; i++) {
//     employees[i].onpointerenter = function () {
//         if (this.style.color == "black"){
//             this.style.color = "white";
//         }else {
//             this.style.color = "black";
//         }
//         }
    



// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.

startTime();
function startTime(){
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    var ampm = h >= 12 ? 'pm' : 'am';

    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('currentTime').innerHTML = h + ":" + m + ":" + s + ampm;
    var t = setTimeout(startTime, 500);
}

function checkTime(i){
    if (i < 10) {i = "0" + i}; //add 0 in front of numbers
    return i;
}


// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.

var hello = document.getElementById("helloWorld");

hello.onclick = function () {
    setTimeout(function () {
        hello.style = "color:" + getRandomColor ();
    }, 3000);
}

function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++){
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).

function walkTheDom(node, func) {
    func(node);
}

function func(node) {
    var childs = node.children
    console.log(node);
    if(childs.length == 0){
        return true;
    }
    for(var i = 0; i < childs.length; i++){
        var c = childs[i];
        walkTheDom(c, func);
    }
}