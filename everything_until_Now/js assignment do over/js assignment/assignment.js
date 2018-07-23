// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
//fyi splice fucntion splice() is used to add or remore object in an array 
function spliceElement(){
    var somerr = ["one", "two","three","four","five"];
    somerr.length(); // count how many items are in array
    somerr.splice[2]; // remove the 3rd item in array located at index[2]
    somerr.length(); // recount items in array fyi should be one less than before

}



// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.

function deleteElemet(){
    var somerr= ["one", "two","three","four","five"];
    somerr.length(); //count items in array above
    delete somerr[2];  // this will delete 3 item in array 
    somerr.length(); // recount array items after one is deleted/removed

}