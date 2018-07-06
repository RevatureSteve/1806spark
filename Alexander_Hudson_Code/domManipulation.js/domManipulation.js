//Get USA
function getUSA(){

var myElement = document.getElementsByTagName("span")[2]; // get elements by tag to aquire the span instead of the id name e.g (span, div, h3)
console.log(myElement);
}

//Sales
function getPeopleInSales(){

var myElement = document.getElementsByTagName("table")[0].rows; //
console.log(myElement[1]);
console.log(myElement[3]);
console.log(myElement[5]);
console.log(myElement[6]);
}

//Custom Attribute
function getCustomAttribute()
{
var myElement = document.querySelectorAll('[data-customAttr]');
console.log(myElement);
}

// Current Time
startTime();
function startTime(){
    var today = new Date ();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    var ampm = h >= 12 ? "pm" : 'am';

    m = checkTime(m);
    s = checkTime(s);
    document.getElementById ('currentTime').innerHTML = h + ':' + m + ':' + s + ampm;
    var t = setTimeout(startTime, 500);
}
function checkTime(i){
    if (i<10) {i ="0" + i}; // add zero in front of numbers < 10
    return i;
}
