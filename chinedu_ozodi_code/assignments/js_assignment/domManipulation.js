// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.

function getUSA(){

    let allElements = document.querySelectorAll("span");
    for (let i = 0; i < allElements.length; i++){
        let selectedElement = allElements[i];
        if (selectedElement.innerHTML.indexOf("USA") >= 0){
            console.log(selectedElement.innerHTML);
        }
    }
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.

function getPeopleInSales(){
    var person = document.getElementsByClassName("empName");
    // console.log(person);
    //Determin if in Sales

    for (var i = 0; i < person.length; i++){
        // console.log(person[i].nextElementSibling);
        if (person[i].nextElementSibling.innerHTML == "Sales"){
            console.log(person[i].innerHTML);
        }
    }
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>

function getAnchorChildren(){
    var anchorElements = document.getElementsByTagName("a");
    for (var i = 0; i < anchorElements.length; i++){
        // console.log(person[i].nextElementSibling);
        var spanElements = anchorElements[i].getElementsByTagName("span");

        for (var j = 0; j < spanElements.length; j++){
            console.log(spanElements[j].innerHTML);
        }
    }
}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.

function getHobbies(){
    var skillsElements = document.getElementsByName("skills");
    for (var j = 0; j < skillsElements.length; j++){
        var skillsElement = skillsElements[j];
        for (var i = 0; i < skillsElement.options.length; i++){
            var option = skillsElement.options[i];
            // console.log(person[i].nextElementSibling);
            if (option.selected == true){
                console.log(option.value + " - " +option.innerHTML);
            }
        }
    }
}