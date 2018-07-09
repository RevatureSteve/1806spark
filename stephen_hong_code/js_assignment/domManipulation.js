/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/

function getUSA() {
    var spanUsa = document.getElementsByTagName("span");
    // "USA" is contained in a span so find all elements by the span tag
    var originalBody = document.body.innerHTML;
    // Assign variable with the original contents inside the body tag
    document.body.innerHTML = spanUsa[2].innerHTML; // "USA" is index 2 of span tags
    window.print();
    document.body.innerHTML = originalBody;
    /*
        The print property prints everything in the document.body.innerHTML
        So assign document.body.innerHTML with the innerHTML you want to print
        Then restore document.body.innerHTML to it's original contents
    */
}

/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/

function getPeopleInSales() {
    var tdSales = document.getElementsByTagName("td");
    // "Sales" is contained in a td so find all elements by the td tag
    var originalBody = document.body.innerHTML;
    document.body.innerHTML = tdSales[0].innerHTML + " " + tdSales[4].innerHTML + " " + tdSales[8].innerHTML + " " + tdSales[10].innerHTML;
    window.print();
    document.body.innerHTML = originalBody;
    /*
        There are four people in the sales department
        So add all four of the innerHTML to document.body.innerHTML
    */
}

/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/

function getAnchorChildren() {
    var anchor = document.getElementsByTagName("a");
    // Find all anchor elements
    var originalBody = document.body.innerHTML;
    document.body.innerHTML = anchor[6].innerHTML + " " + anchor[8].innerHTML + " " + anchor[9].innerHTML + " " + anchor[11].innerHTML;;
    window.print();
    document.body.innerHTML = originalBody;
    /*
        There are four anchor elements with a <span> child
        So add all four of the innerHTML to document.body.innerHTML
    */
}

/*
4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/

function getHobbies() {
    var selectSkills = document.getElementsByTagName("select").namedItem("skills");
    // Find all select tags with the name skills
    var skills = selectSkills.getElementsByTagName("option");
    // Find all option tags in <select name="skills">
        for (var i = 0; i < selectSkills.getElementsByTagName("option").length; i++) {
            if(skills[i].defaultSelected == true) {
                console.log(skills[i].label);
                console.log(skills[i].text);
            }
        }
    }

/*  
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.

6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
	<h3>Sum: <span id="sum"></span></h3>

Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element

7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.

8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

9. Show/Hide Event
When user hovers over an employees name:
	Hide the name if shown.
	Show the name if hidden.

10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.

11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.

12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node)

*/