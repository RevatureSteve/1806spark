// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.

var list = [4, 6, 9, 1, 2, 8];

function bubbleSort(list) {
    var temp;
    var iteration;
    var index;

    for (iteration = 1; iteration < list.length; iteration++) {
        for (index = 0; index < list.length - iteration; index++)

            if (list[index] > list[index + 1]) {
                temp = list[index];
                list[index] = list[index + 1];
                list[index + 1] = temp;
            }
    }
    return list;
}

