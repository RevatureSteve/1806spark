window.onload = function () {
    document.getElementById("num1").addEventListener("change", inBetween)
    document.getElementById("num2").addEventListener("change", inBetween)
}

function inBetween() {
    var num1 = document.getElementById("num1").value;
    var num2 = document.getElementById("num2").value;
    var unList = document.getElementById("unList");

    if (num1.length > 0 && num2.length > 0) {
        for (var i = num1; i <= num2; i++) {
            var x = i / 3;
            var y = i / 5;
            let show = " ";
            if (Number.isInteger(x) == true && Number.isInteger(y) == true) { // checking to see if divisible by 3 AND 5
                show = "fizzbuzz";
            } else if (Number.isInteger(x) == true) { // checking to see if divisible by 3
                show = "fizz";
            } else if (Number.isInteger(y) == true) { // checking to see if divisible by 5
                show = "buzz";
            } else {
                show = i;
            }

            let item = document.createElement("li");
            let info = document.createTextNode(show);
            item.appendChild(info);
            unList.appendChild(item);
        }
    }
}