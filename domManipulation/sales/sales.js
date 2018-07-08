// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.



function getPeopleInSales() {

    var td = document.getElementsByTagName("td");

    for (var i = 0; i < td.length; i++) {
        if (td[i].innerHTML == "Sales") {
            console.log(td[i - 1].innerHTML);
        }
    }
}