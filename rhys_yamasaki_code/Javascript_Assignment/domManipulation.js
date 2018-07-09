// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.

function getUSA() {
    let USA = document.getElementsByTagName("span"); // [span, span, span, span, span]
    for (i = 0; i < USA.length; i++) {
        if (USA[i].innerHTML == "USA") {
            return USA[i].innerHTML;
        }
    }
}


// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.


function getPeopleInSales() {
    let i;
    let people = [];
    let arr = document.getElementsByTagName("td");

    for (i = 0; i < arr.length; i++) {
        if (arr[i].innerHTML == "Sales") {
            people.push(arr[i - 1].innerHTML);
        }
    }
    console.log(people.join(", "));
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>

function getAnchorChildren() {
    let getSpan = document.getElementsByTagName("a");
    for (let i = 0; i < getSpan.length; i++) {
        if (getSpan[i].querySelector("span")) {
            console.log(getSpan[i].querySelector("span").innerHTML);
        }
    }
}

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

document.addEventListener("change", alertSkill);
function alertSkill() {
    let selectSkill = document.getElementsByName("skills")[0].value;
    alert("Are you sure " + selectSkill + " is one of your skills?");
}

// 9. Show/Hide Event
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.

let className = document.getElementsByClassName("empName");

Array.from(className).map(function (e) {
    e.addEventListener('mouseenter', hideShowName);
});

function hideShowName() {
    this.style.opacity == 0 ? this.style.opacity = 1 : this.style.opacity = 0;
}
