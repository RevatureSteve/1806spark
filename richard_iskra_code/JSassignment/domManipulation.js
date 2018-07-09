//PART II

/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/

function getUSA() {
    var tags = document.getElementsByTagName("span");
    var searchText = "USA";
    for (var i = 0; i < tags.length; i++) {
        if (tags[i].textContent == searchText) {
            console.log(tags[i]);
            console.log(tags[i].parentNode);
            return tags[i].textContent;
        }
    }
}

/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/

function getPeopleInSales() {
    var sales = [];
    sales = (document.getElementsByClassName("empName")); //get all elements with the class empName
    for (var i = 0; i < sales.length; i++) {
        if (sales[i].nextElementSibling.textContent == 'Sales') {
            console.log(sales[i].textContent);
        } //convert each element to it's text
    }
}


/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/

function getAnchorChildren() {
    var parents = document.getElementsByTagName("A");
    for (var i = 0; i < parents.length; i++) {
        var possible = parents[i].childNodes;
        for (var j = 0; j < possible.length; j++) {
            if (possible[j].tagName == "SPAN") {
                console.log(possible[j].textContent);
            }
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
    var sales = [];
    sales = document.querySelectorAll(`[${'selected'}="${'selected'}"]`);
    for (var i = 0; i < sales.length; i++) {
        if (sales[i].parentElement.name == "skills") {
            console.log(sales[i]);
            console.log(sales[i].textContent);
        }
    }
}