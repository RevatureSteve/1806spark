
function formValidation () {

var w = document.forms["regForm"]["userName"].value;
    if (w == "") {
        alert("Please Enter Your USERNAME!");
   
}
var x = document.forms["regForm"]["password"].value;
    if (x == "") {
        alert("Please Enter Your PASSWORD");
   
}
var y = document.forms["regForm"]["fullName"].value;
    if (y == "") {
        alert("Please Enter Your First and Last Name");
    
}
var z = document.forms["regForm"]["email"].value;
    if (z == "") {
        alert("Please Enter Your EMAIL!");
        return false;
    }
}