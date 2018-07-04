/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/
function getPeopleInSales() {
    var sales = [];
    sales = (document.getElementsByClassName("empName"));
    for(var i = 0; i < sales.length; i++){
        console.log(sales[i].textContent);
    }
}

/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/

function getAnchorChildren(){
    
}