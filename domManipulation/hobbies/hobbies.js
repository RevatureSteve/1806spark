// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.



function getHobbies(){

    o = document.getElementsByName("skills");

    for (var i = 0; i < o.length; i++) {
        console.log(o[i]);
    }
}