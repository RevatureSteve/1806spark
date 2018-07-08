// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.

function getUSA() {
    
    var printUSA = document.getElementsByTagName("span")[2].innerHTML;

    return printUSA;
}