// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.

function getUSA() {
    var usa  = document.getElementsByTagName("h1").innerHTML;
    return usa;
}