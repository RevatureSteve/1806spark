console.log('Daniels Part 2 is loaded');

/*
    Define function: bubbleSort(numArray)
    Use the bubble sort algorithm to sort the array.
    Return the sorted array.
*/

/*
    if you want to use an Array of any size
    just goto the console and type ' arr =["insert numbers"]; '
    then type ' bubbleSort(arr) ' 
    then run
*/

function bubbleSort(numArray) {
    workingArr = numArray; //used so you are working with the direct user input
    for (var j = 0; j < workingArr.length; j++) { //goes through each array iteration

        for (var i = 0; i < workingArr.length - j; i++) { //goes through a single array iteration

            if (workingArr[i] > workingArr[i + 1]) { //checks to see if the two array locations are true or not
                var t = workingArr[i]; //stores a temporary var for the first array location
                workingArr[i] = workingArr[i + 1]; //switches the second array location to the first one
                workingArr[i + 1] = t; //stores the temporary var to the second arrat location
            }
        }
        console.log('Array ' + workingArr + ' is still sorting'); //prints each line of the sort
    }
    console.log('Array ' + workingArr + ' has been bubbled'); //prints each line of the sort
    return workingArr; //another way to return just the array
}