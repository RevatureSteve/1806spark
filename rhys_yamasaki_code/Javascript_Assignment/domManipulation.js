// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.

function getUSA() {
    return document.getElementsByTagName("span")[2].innerHTML;
    
    // for (i = 0; i < USA.length; i++) {
    //     if (USA.innerHTML == "USA") {
    //         span.push(USA[i]);
    //     }
    // }
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