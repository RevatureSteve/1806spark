/*
1.USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents
*/
 function getUSA(){
     var x = document.getElementsByTagName("span")
     console.log(x[2].innerHTML)
 }

/*
2.Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department
*/
   function getPeopleInSales(){
    x =  document.getElementsByClassName("empName")
    console.log("The people in sales are: " + x[0].innerHTML+ "," + x[2].innerHTML+ "," + x[4].innerHTML+ "," + x[5].innerHTML+ ".")
   }
/*
3.Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/

function getAnchorChildren(){
 x = document.getElementsByTagName("span")
console.log("The AnchorChildren are: " + x[3].innerHTML+ "," + x[4].innerHTML+ "," + x[5].innerHTML+ ".")
}
/*
4.Hobbies
Define function getHobbies()
Find all checked options in the 'hobbies' select element.
Print the value and the contents
*/

function getHobbies(){
    x = document.getElementsByTagName("option")
    console.log("The Checked options in the hobbies are: " + x[6].innerHTML+ "," + x[7].innerHTML+ "," + x[8].innerHTML+ ".")

}