/*
    1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents

*/

function getUSA(csg) {
    // used get element to get he html tag by name which is span element
    let csg = document.getElementsByTagName("span")[2];
    // let elementLocator = querySelector(span)[2]; // locate the span element at index 2 which translate to 0, 1, 2... place with be 3
    //console.log(elementLocator);
    return csg;

}


/*
    4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.

*/

function getHobbies() {

    let hob = document.getElementsByTagName("option");
    let hobArray = ("some hobbies are: " + x[0].innerHTML + ", " + x[1].innerHTML + ", and " + x[2].innerHTML)
    console.log(hobArray);
}

/* 
function getHobbies() {
    let hob = querySelectorAll('option, skill');
    console.log(hob)

}
*/

// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.

var theTime;
theTime = document.getElementById("CurrentTime");
//var theTimeIs = new getTime();
console.log(theTime + time);

function theTime() {
    let now = new Date();
    let hour = getHours();
    let minutes = getMinutes();
    let seconds = getSeconds();
    let fullTime = now + hour + minutes + seconds;
    let amorpm = function () {
        if (fullTime < 12 || fullTime > 1) {
            fullTime = fullTime + "am"
        }
        else {
            fullTime = fullTime + "pm"
        }
    }
    document.getElementById("currentTime").innerHTML = " The Current time is: " + fullTime;
}




// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
// 

function getCustomAttribute() {
    var customElement = document.querySelectorAll('[data-customAttr]');
    console.log(customElement);
}
