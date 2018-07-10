/* Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n) {
    if (n <= 1) return 1;
  
    return fib(n - 1) + fib(n - 2);
  }
/*
 Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same
*/
  someArr = ['mary', 'tom', 'anne', 'bobbert'];
  function deleteElement(someArr){
      someArr.length;
      delete someArr[2];
  }
/*
Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length
*/

someArr = ['mary', 'tom', 'anne', 'bobbert'];
function spliceElement(someArr) {
         console.log(someArr.length);
         someArr.splice(2,1);
         console.log(someArr.length);
         return someArr;

}
/*
Reverse String
Define function: reverseStr(someStr)
Reverse and return the String
*/
str = "RevatureSpark"
function reverseStr(str) {
    var newString = "";
    for (var i = str.length - 1; i >= 0; i--) {
        newString += str[i];
    }
    return newString;
}
