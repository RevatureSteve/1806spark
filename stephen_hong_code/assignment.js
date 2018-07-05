/*
    1. Fibonacci
    Define function: fib(n) 
    Return the nth number in the fibonacci sequence.

*/

function fib(n) {

	var sequence = [1, 1];

	for (var i = 2; i < n; i++) {
		sequence[i] = sequence[i - 1] + sequence[i - 2];
	}

	return sequence[n - 1];
}