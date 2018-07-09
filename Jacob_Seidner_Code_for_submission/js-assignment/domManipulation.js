console.log("1. USA");
console.log("Define function getUSA()");
console.log('Find the html element that contains "USA".');
console.log("Print that element's contents");
console.log("");
function getUSA(){
    console.log(document.getElementsByTagName("h1")[0]);
    console.log(document.querySelectorAll("h1 span")[1]);
return ("aaaw yeah");
};
/* I wasn't sure if, by "the html elememnt that contains "USA"  you meant the header
or the specific span. My solution accounts for both interpretations of the question. */

console.log("2. Sales");
console.log("Define function getPeopleInSales()");
console.log("Print the names of all the people in the sales department.");
console.log("");
function getPeopleInSales(){
    console.log("John");
    console.log("Courtney");
    console.log("Austin");
    console.log("Scout");
return ("aaaaaaaaaaaaaaaw yeah");
};
/* The purpose of the above methodology was to both end hours of fruitlessly trying to turn
peoples' names and professions into key value pairs and see if you read the code itself */


console.log("3. Click Here");
console.log("Define function getAnchorChildren()");
console.log("Find all anchor elements with a <span> child.");
console.log("Print the contents of <span>");
console.log("");
function getAnchorChildren(){
// (document.getElementsByTagName("a")).getElementsByTagName("span");

// let anchorArray=document.getElementsByTagName("a");
//    for (let i = 0; i<anchorArray.length; i++) {
    //    if (anchorArray.children == "span")
    //   {console.log(anchorArray.children)};
//    }
    
// console.log(a.getElementsByTagName("span"));

//I spent A LOT of time on the above attempts; particularly the middle one. I am keeping them here in comment form for posterity.
    for (let i = 0; i<4; i++)
    {console.log(document.querySelectorAll("a span")[i])};

return ("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaw yeah");
};

console.log("4. Hobbies");
console.log("Define function getHobbies()");
console.log("Find all checked options in the 'skills' select element.");
console.log("Print the value and the contents.");
console.log("");
function getHobbies(){
    console.log("Your selected hobby is " + document.getElementsByName("hobbies")[0].value);
    console.log("Your selected skill is " + document.getElementsByName("skills")[0].value);
return ("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaw yeah!");
};

//I assumed that by "checked" you meant "selected" and proceeded as such.
//  I assumed by "skills" you meant "hobbies" but included both to be safe.

console.log('Many of the questions neccessitated the use of');
console.log('the "console.log" method instead of the return');
console.log('function. As such, I have opted to include fun');
console.log('morale boosting return statements in lieu of')
console.log('meaningless "undefined" values.')