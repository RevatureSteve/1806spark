
//1. USA
function getUSA() {
var merica = document.getElementsByTagName("span");
var searchText = "USA";
for (var i = 0; i < merica.length; i++) {
    if (merica[i].textContent == searchText) {
        console.log(merica[i]);
        console.log(merica[i].parentNode);
        return merica[i].textContent;
    }
}
    
}

// 10. CLOCK
function updateClock(){
var currentTime = new Date();
var cHour = currentTime.getHours();
var cMin = currentTime.getMinutes();
var cSec = currentTime.getSeconds();

cMin = (cMin < 10 ? "0":"")+cMin;
cSec = (cSec < 10 ? "0":"")+cSec;

var cPeriod = (cHour < 12) ? "AM":"PM";
cHour = (cHour > 12) ? cHour - 12: cHour;
cHour = (cHour == 0) ? 12 : cHour;

var cTime = (cHour + ":" + cMin + ":"+ cSec + " " + cPeriod);

// ask about these children...still foggy.

document.getElementById("clock").firstChild.nodeValue = cTime;
};


// 9. Show / Hide Event
function mOver(obj) {
    obj.innerHTML = "Amy"
}

function mOut(obj) {
    obj.innerHTML = "HIDDEN"
};

// COLOR SWAP TIME DELAY
function colorSwap() {
    document.getElementById("helloWorld").style.color = "#ff0000"; 
document.getElementById("helloWorld").style.transitionDelay = "3s";
};

// SumEvent

function sumNum(){
    x = getElementById("num1").value;
    y = getElementById("num2").value;
    z = x+y;
    document.getElementById("total") +z;

}
