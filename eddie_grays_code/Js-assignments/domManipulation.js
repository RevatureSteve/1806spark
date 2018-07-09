/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents
*/

function getUSA() {
    var usa = document.getElementsByTagName("span")[2];
    console.log(usa.innerHTML);
}

/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/

function getPeopleInSales() {
    var empNames = document.getElementsByClassName('empName');
    console.log(empNames[0].innerHTML + ", " + empNames[2].innerHTML + ", " + empNames[4].innerHTML + ", " + empNames[5].innerHTML);
}

/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/

function getAnchorChildren() {
    var anchor = document.getElementsByTagName("a");
    for (var i = 0; i < anchor.length; i++) {
        if (anchor[i].querySelector("span")) {
            console.log(anchor[i].querySelector("span").innerHTML);
        }
    }
}

/*
4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/

function getHobbies() {
    var skills = document.getElementsByTagName("select")[2];
    console.log(skills[2]);
    console.log(skills[5]);
}

/*
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/

function getCustomAttribute() {
    var data = document.querySelectorAll('[data-customAttr]');
    for (var i = 0; i < data.length; i++) {
        console.log(data[i]);
    }
}