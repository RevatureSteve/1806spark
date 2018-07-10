console.log('Daniels Assignment 2 has loaded');

/*
    Define function getUSA()
    Find the html element that contains "USA".
    Print that element's contents.
*/

//declaring the variables to be pulled e.g. USA
var com1 = document.getElementsByTagName("span"); //used to access any element
var com2 = document.getElementsByTagName("span")[2]; //used to access a certain element 

function getUSA() {
    //console.log('I am in the function');
    //^ use to see where I am in the func
    console.log("this function pulled the text '" + com2.innerHTML + "'");
    //^ will print: "this function pulled the text 'USA'"
    return com2; //this lets me know what my com2 is 
}

//^^^ THIS IS NOT A DYNAMIC CODE!!!

/****************************************************************************************************************************/
/****************************************************************************************************************************/
/****************************************************************************************************************************/

/*
    Define function getPeopleInSales()
    Print the names of all the people in the sales department.
*/

var x = document.querySelectorAll('tr');//selecting all the table row elements

function getPeopleInSales() {
    //console.log('I am in the function');
    //console.log(x);
    for (i = 1; i < x.length; i++) {
        // this for loop goes through the name/ dept table to find those who work sales   
        //    console.log('Name is ' + x[i].children[0].innerHTML + ' and they work in ' + x[i].children[1].innerHTML);

        if (x[i].children[1].innerHTML == 'Sales') {
            // This if statement will compare the table to sales

            console.log(x[i].children[0].innerHTML + ' works in sales'); //prints who works in sales

        }
    }
}

/****************************************************************************************************************************/
/****************************************************************************************************************************/
/****************************************************************************************************************************/

/*
    Define function getAnchorChildren()
    Find all anchor elements with a <span> child.
    Print the contents of <span>
*/

y = document.querySelectorAll('a');
// selecting all anchor tags

function getAnchorChildren() {
    //  console.log('in the func');

    for (i = 0; i < y.length; i++) {
        // checking all anchor tags
        //        console.log(y[i].children[0]);

        if (y[i].children.length != 0) {
            // if the children elements of the anchor elements is not equal then continue
            console.log(y[i].children[0].innerHTML);
            //print the text of the children tags
        }
    }
}

/****************************************************************************************************************************/
/****************************************************************************************************************************/
/****************************************************************************************************************************/

/**
    Define function getHobbies()
    Find all checked options in the 'skills' select element.
    Print the value and the contents.
*/
//INCOMPLETE
var z = document.getElementsByTagName('select');

function getHobbies() {
    for (i = 0; i < z.length; i++) {
        //check all selected tags
        //        console.log(z[i].children[0]);

        if (z[i].name == 'skills') {
            //if it matches the tag 'skills' then continue

            for (j = 0; j < z[i].children.length; j++) {
                //check all children tags

                if (z[i].children[j].attributes.selected) {
                    //truthy statement used
                    //if true then print the skill

                    console.log(z[i].children[j].innerHTML);
                    //skill printed
                }
            }
        }

    }
}
/****************************************************************************************************************************/
/****************************************************************************************************************************/
/****************************************************************************************************************************/

/* 
    Define function getCustomAttribute()
    Find all elements with "data-customAttr" attribute
    Print the value of the attribute.
    Print the element that has the attribute.
*/

//var xx = document.querySelectorAll('[]');