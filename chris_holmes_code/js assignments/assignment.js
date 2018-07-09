function fib(num) {
    if (num <= 1) {
        return 1;
    }
    else {
        return fib(num - 1) + fib(num - 2);
    }
}

function isEven(someNum) {
    var someNumString = someNum.toString();
    var last = someNumString.substring(someNumString.length - 1, someNumString.length);
    if (last == "0" || last == "2" || last == "4" || last == "6" || last == "8") {
        return true;
    }
    return false;

}

function reverse(s) {
    return s.split('').reverse().join('');
}
//reverseString("hello");
/*this funvtion will return a splitting of the letters, reverse
the split, and then rejoin the letters*/

function isPalindrome(palindrome) {
    var pl = reverse(palindrome);
    if (pl == palindrome) { return true; }
    else {
    return false}
}