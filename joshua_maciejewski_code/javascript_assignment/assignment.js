
// 1. Fibonacci
function fib(n) {

	var sequence = [1, 1];

	for (var i = 2; i < n; i++) {
		sequence[i] = sequence[i-1]+ sequence[i-2];
	}

    return sequence[n-1];
}


// // 3. Reverse String
function reverseStr(someSt) {

	var strlength = (someSt.length - 1);
	var reversedArray = [];
		for (var i = strlength; i >= 0; i--) {
		reversedArray.push(someSt.charAt(i));
	} 
		return console.log(reversedArray.join(" "));
}



// 4. Factorial
// Not solved with recursion 
function factorial(someNum) {
	
	
	var factorialSolution = 1

		for (var i = 1; i <= someNum; i++) {
			factorialSolution *= i;
		}
		return factorialSolution;
}


// 6. Even Number
function isEven(someNum) {
	
	var dividedNumber = someNum/2
	var roundedNumber= Math.round(dividedNumber)
	var multipliedNumber = roundedNumber * 2
	
	if (someNum == multipliedNumber) {
		return "true";
	} else {
		return "false"
	}
}

// 7. Palindrome
function isPalindrome(someStr) {

	var strlength = (someStr.length - 1);
	var reversedArray = [];
		for (var i = strlength; i >= 0; i--) {
		reversedArray.push(someStr.charAt(i));
	}
		var newString = reversedArray.join("");

		if (someStr == newString) {
			return "true";
		} else {
			return "false";
		}
}

// 11. Splice Element
var sunshineArray = ['kittens', 'unicorns', 'rainbows', 'candy', 'Christmas', 'circus' ]

function spliceElement(someArr) {

	console.log(someArr.length);
	someArr.splice(2,1);
	console.log(someArr.length);

}

