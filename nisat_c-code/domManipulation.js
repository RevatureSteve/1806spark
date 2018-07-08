/*USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.*/

function getUSA() {
    var u = document.getElementsByTagName("span");
    // document.getElementsByTagName('demo').innerHTML=x[2].innerHTML;
    console.log(u[2].innerHTML);
}

/*Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/

function getPeopleInSales() {
    var x = document.getElementsByClassName('empName');
    console.log("People is Sales: " + x[1].innerHTML + ',' + x[3].innerHTML + "," + x[5].innerHTML + ',' + x[6].innerHTML ) ;
}

/*Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/

function getAnchorChildren(q) {
    var q = document.querySelectorAll('a > span');
    console.log(q[0].innerHTML  + ',' + q[1].innerHTML + ',' + q[2].innerHTML + ',' + q[3].innerHTML) 
    // console.log(q)
}


/*custom attribute 
define function getCustomAttribute()
find all elements with " data-customAttr" attribute
print the value of the attribute
print the element that has the attribute*/

function getCustomAttribute(a, b, c, d) {
    var a = document.querySelectorAll('span[data-customAttr]');
    var b = document.querySelectorAll('input[data-customAttr]');
    var c = document.querySelectorAll('td[data-customAttr]');
    // var d = document.querySelectorAll('a[data-customAttr]');
    console.log(a[0].getAttribute('data-customAtrr') + ',' + a[1].getAttribute('data-customAtrr'));
    console.log(b[0].getAttribute('data-customAtrr') + ',' + b[1].getAttribute('data-customAtrr'));
    console.log(c[0].getAttribute('data-customAtrr'));
    // console.log(d[11]);
}