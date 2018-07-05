/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/

function getUSA(){
    var allElements = document.body.getElementsByTagName("*");
    for(let i = 0; i < allElements; i++)
    return usaElement;
    //console.log(usaElement.innerHTML);
}

/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/
function getPeopleInSales(){
    var salesTable = document.getElementsByTagName("td");
    var salesPeople = [];
    var salesCount = 0;
    for(var i = 0; i < salesTable.length; i++){
        if(salesTable[i].innerHTML=="Sales"){
            salesPeople[salesCount] = salesTable[i-1];
            salesCount++;
        }
    }
    return salesPeople;
}
/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>fin
*/
function getAnchorChildren(){
    var children = document.querySelectorAll("a span");
    for(var i = 0; i<children.length; i++){
        console.log(children[i].innerHTML);
    }
}

/*
4. Hobbies
Define function getHobbies()
Find all checked options in the 'hobbies' select element.
Print the value and the contents.
*/
function getHobbies(){
    var hobbies = document.querySelector('[name="hobbies"]');
    var hobbiesOpt = hobbies.querySelectorAll('[selected="selected"]');
    for(var i = 0; i < hobbiesOpt.length; i++){
        hobby = hobbiesOpt[i];
        console.log("Value: " + hobby.value + " content: " + hobby.innerHTML);
    }
}

/*
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/
function getCustomAttribute(){
    var att = document.querySelectorAll('[data-customAttr]')
    for(var i = 0; i < att.length; i++){
        var item = att[i];
        console.log(item.getAttribute("data-customAttr"));
        console.log(item);
    }
}

/*
6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
    <h3>Sum: <span id="sum"></span></h3>
*/