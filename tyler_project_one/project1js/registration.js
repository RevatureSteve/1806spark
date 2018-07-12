
function formValidation () {

var x = document.forms["regForm"]["userName"].value;
    if (x == "") {
        alert("Please Enter Your USERNAME!");
   
}
var x = document.forms["regForm"]["password"].value;
    if (x == "") {
        alert("Please Enter Your PASSWORD");
   
}
var x = document.forms["regForm"]["fullName"].value;
    if (x == "") {
        alert("Please Enter Your First and Last Name");
    
}
var x = document.forms["regForm"]["email"].value;
    if (x == "") {
        alert("Please Enter Your EMAIL!");
        return false;
    }
}