
window.onload = function () {
    document.getElementById("clickHere").addEventListener('click', appendNumbers);

}

function appendNumbers() {
    let getValue1 = document.getElementById("num1").value;
    let getValue2 = document.getElementById("num2").value;
    let ul = document.getElementById("item");
    while (ul.hasChildNodes()) {
        ul.removeChild(ul.firstChild);
    }
    for (let i = getValue1; i <= getValue2; i++) {
        let c = "";
        if (i % 3 == 0) {
            c += "fizz";
        }
        if (i % 5 == 0) {
            c += "buzz";
        }
        if (i % 3 !== 0 && i % 5 !== 0) {
            c += i
        }
        let li = document.createElement("li");
        li.appendChild(document.createTextNode(c));
        ul.appendChild(li);
    }
}