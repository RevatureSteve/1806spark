/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/
function getUSA()
{
    var myElement = document.getElementsByTagName('span')[2];
    console.log(myElement);
}
/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/
function getPeopleInSales()
{
    var myElement = document.getElementsByTagName('table')[0].rows;
    console.log(myElement[1]);
    console.log(myElement[3]);
    console.log(myElement[5]);
    console.log(myElement[6]);
}
/*
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/

function getCustomAttribute()
{
var myElement = document.querySelectorAll('[data-customAttr]');
console.log(myElement);
}
/*
10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/
startTime();
function startTime() {
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
function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}