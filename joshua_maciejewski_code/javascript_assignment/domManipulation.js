     



// 2. Sales
function getPeopleInSales() {

    var salesPeople = document.getElementsByTagName("td")
    var length = salesPeople.length;
    var newArray = [];

            for (var i = 0; i < length; i++) {
                if (salesPeople[i].innerHTML == "Sales") {
                newArray.push(salesPeople[i-1].innerHTML)}
        }
        console.log(newArray.join(", "));
}


// 3. Click Here

function getAnchorChildren() {

    var anchorTag = document.getElementsByTagName("a");
    var length = anchorTag.length;
   
        for (var i = 0; i < length; i++) {
            if (anchorTag[i].querySelector("span")) {
                console.log(anchorTag[i].querySelector("span").innerHTML);
            }
        }
    }

  




// 7. Skills Event


document.addEventListener('DOMContentLoaded',load);
var skills=" ";
function load() {
skills =firstForm.skills;
skills.addEventListener('change',option_change);
}

function option_change() {
alert("Are you sure "+skills.options[skills.selectedIndex].text+" is one of your skills?");
}



// 10. Current Time

function setTime() {

    var today = new Date();
    var hour = today.getHours();
    var minute = today.getMinutes();
    var second = today.getSeconds();
    var AMorPM = (hour >= 12)? " PM ":" AM ";
    document.getElementById("currentTime").innerHTML = (hour + ":" + minute + ":" + second + AMorPM);
}
setTime();
window.setInterval(function(){
    setTime();
}, 1000);


