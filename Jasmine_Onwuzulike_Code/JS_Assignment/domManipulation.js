// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.

function getUSA(x) {
    var x = document.getElementsByTagName("span")[2];
    return x;
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales() {
    var names = document.getElementsByTagName("td");
    var first = document.getElementsByTagName("td");
    var john = names[0].innerHTML;
    var austin = names[4].innerHTML;
    var courtney = names[8].innerHTML;
    var scout = names[10].innerHTML;
    return john + " " +  austin + " " +  courtney + " " + scout;
}


// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren() {
    var list = [];
var anchor = document.querySelectorAll("a span");
var first = anchor[0].innerHTML;
var second = anchor[1].innerHTML;
var third = anchor[2].innerHTML;
var fourth = anchor[3].innerHTML;
return first + " " + second + " " + third + " " + fourth;
}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies() {
    var checkedOptions = document.getElementsByTagName("select")[1];
    var first = checkedOptions[0].innerHTML;
    var second = checkedOptions[1].innerHTML;
    var third = checkedOptions[2].innerHTML;
    return first + " " + second + " " + third;
}