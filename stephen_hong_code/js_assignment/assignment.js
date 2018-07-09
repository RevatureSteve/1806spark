/*
    1. Fibonacci
    Define function: fib(n) 
    Return the nth number in the fibonacci sequence.

*/

function fib(n) {

	var sequence = [1, 1]; // The first 2 numbers in the fibonacci sequence

	for (var i = 2; i < n; i++) {
		sequence[i] = sequence[i - 1] + sequence[i - 2];
	} // i starts at 2 because you need the two previous values to get the next value in the fibonacci sequence

	return sequence[n - 1]; // Since Arrays start at 0, the nth sequence in the fibonacci sequence would be the n-1th value in the array
}

/*
	2. Bubble Sort
	Define function: bubbleSort(numArray)
	Use the bubble sort algorithm to sort the array.
	Return the sorted array.
*/

var numArray = [9,3,0,7,2,6]
function bubbleSort(arr) {
	console.log(arr); // Display the original array
	for (var i = 0; i < arr.length; i++) {
		/*
			# of passes
			Without this line of code, the function only does one cycle
		*/
	  for (var j = 0; j < (arr.length - i); j++) {
		if(arr[j-1] > arr[j]) {
		  // Compare adjacent numbers and swap them
		  var tmp = arr[j-1];  // Temporary variable to hold the current number
		  arr[j-1] = arr[j]; // Replace current number with adjacent number
		  arr[j] = tmp; // Replace adjacent number with current number
		}
	  }        
	}
	return (arr);
  }

/*
	3. Reverse String
	Define function: reverseStr(someStr)
	Reverse and return the String.
*/

function reverseStr(str) {
	console.log(str); // Display the original string
	// Use split() to split string into a new array
	var splitStr = str.split("");

	// Use reverse() to reverse the order in array
	var reverseArr = splitStr.reverse();

	// Use join() to join all elements in the array into a string
	var joinArr = reverseArr.join("");

	//Step 4. Return the reversed string
	return joinArr;
}

// Above code can be shortened
function reverseStr2(str) {
	console.log(str);
	return str.split("").reverse().join("");
}

/*
	4. Factorial
	Define function: factorial(someNum)
	Use recursion to compute and return the factorial of someNum.
*/

function factorial(n) {
	// Factorial is defined only for non-negative integer numbers
	if (n < 0) 
		return "Factorial undefined for negative numbers";

	// Factorial of 0 is 1.
	else if (n == 0) 
		return 1;

	// Use recursion
	else
		return (n * factorial(n - 1));
		/* 
		First Part of recursion
		Expect several nested calls, not one

		e.g. factorial(5)
		Each call - factorial(n) will return - n * factorial(n - 1)

		1st call – factorial(5) will return - 5 * factorial(4)
		2nd call – factorial(4) will return - 4 * factorial(3)
		3rd call – factorial(3) will return - 3 * factorial(2)
		4th call – factorial(2) will return - 2 * factorial(1)
		5th call – factorial(1) will return - 1 * factorial(0)

		Second part of recursion
		The method hits the if condition, factorial(0) = 1, then multiply values at each call

		5th call will return 1 * 1 = 1
		4th call will return 2 * 1 = 2
		3rd call will return 3 * 2 = 6
		2nd call will return 4 * 6 = 24
		1st call will return 5 * 24 = 120
		*/
}

/*
	5. Substring
	Define function substring(someStr, length, offset)
	Return the substring contained between offset and (offset + length) inclusively.
	If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/

function substring(str, l, i){
	if (i < 0)
		alert("Offset cannot be less than 0!")
	else if (l < 0)
		alert("Length cannot be less than 0!")
	else if (i + l > str.length)
		alert("Offset + length cannot be greater than the length of the string!")
	else
	// Use split() to split string into a new array
	console.log(splitStr = str.split(""));
	// Use splice to remove items from the array
	splitStr.splice(i+l+1, str.length-i-l-1);
	splitStr.splice(0, i);
	console.log(splitStr); //Display new array
	// Use join() to join all elements in the array into a string
	return (splitStr.join(""));
	
}

/*
	6. Even Number
	Define function: isEven(someNum)
	Return true if even, false if odd.
	Do not use % operator.
*/

/*
	Use recursion to constantly subtract 2 from someNum
	If remainder is 0, someNum is even
	If remainder is 1, someNum is odd
	Negative numbers can be even or odd so just multiply someNum by (-1)
*/
function isEven(n) {
	if (n == 0)
		return true;
	else if (n == 1)
		return false;
	else if (n < 0)
		return isEven(-n);
	else
		return isEven(n - 2);
  }

/*
	7. Palindrome
	Define function isPalindrome(someStr)
	Return true if someStr is a palindrome, otherwise return false
*/

// Apply reverse string function from #3
function isPalindrome(str) {
	var lowStr = str.toLowerCase();
	var revStr = lowStr.split('').reverse().join(''); 
	if (revStr === lowStr)
		return true;
	else
		return false;
}

/*
	8. Shapes
	Define function: printShape(shape, height, character)
	shape is a String and is either "Square", "Triangle", "Diamond".
	height is a Number and is the height of the shape. Assume the number is odd.
	character is a String that represents the contents of the shape. Assume this String contains just one character.
	Use a switch statement to determine which shape was passed in.
	Use the console.log function to print the desired shape.
	Example for printShape("Square", 3, "%");
	%%%
	%%%
	%%%
	Example for printShape("Triangle", 3, "$");
	$
	$$
	$$$
	Example for printShape("Diamond", 5, "*");
	*
	***
	*****
	***
	*
*/

/*
	9. Object literal
	Define function traverseObject(someObj)
	Print every property and it's value.
*/

/*
	10. Delete Element
	Define function deleteElement(someArr)
	Print length
	Delete the third element in the array.
	Print length
	The lengths should be the same.
*/

function deleteElement(arr) {
	console.log(arr);
	delete arr[2];
	console.log(arr);
}

/*
	11. Splice Element
	Define function spliceElement(someArr)
	Print length
	Splice the third element in the array.
	Print length
	The lengths should be one less than the original length.
*/

function spliceElement(arr) {
	console.log(arr);
	arr.splice(2, 1);
	console.log(arr);
}

/*
	12. Defining an object using a constructor
	Define a function Person(name, age)
	The following line should set a Person object to the variable john:
		var john = new Person("John", 30);
*/

function Person(name, age) {
	this.name = name;
	this.age = age;
}

var john = new Person("John", 30);

/*
	13. Defining an object using an object literal
	Define function getPerson(name, age)
	The following line should set a Person object to the variable john:
		var john = getPerson("John", 30);
*/