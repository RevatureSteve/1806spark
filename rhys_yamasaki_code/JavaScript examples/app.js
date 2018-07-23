var cat = "cat";
console.log(cat);

function foo() {
    console.log("foo");
}

foo(cat);

// create a function that takes two arguments: they should be numbers & return the sum

function sum(a,b) {
    console.log("The value of a: " + a);
    console.log("The value of b: " + b);
    console.log("The sum is: " + (a + b));
    return a+b;
}

function subtract(x, y) {
    return x - y;
}