var unordered;

window.addEventListener('load', function () {
    document.getElementById('btn1').onclick = fizzbuzz;
    unordered = document.getElementsByTagName('ul')[0];
});

function fizzbuzz() {
    while (unordered.firstChild) {
        unordered.removeChild(unordered.firstChild);
    }

    var n = document.getElementById('n1').value;
    for (var i = 1; i <= n; i++) {

        var listItem = document.createElement('li');
        var displayStr = "";
        if (i == 0) {
            listItem.innerHTML = 0;
            unordered.appendChild(listItem);
            continue;
        }

        if (i % 3 == 0) {
            displayStr = "fizz";
        }

        if (i % 5 == 0) {
            displayStr = displayStr + "buzz";
        }

        if (i % 3 != 0 && i % 5 != 0) {
            displayStr = i;
        }

        listItem.innerHTML = displayStr;
        unordered.appendChild(listItem);
    }
}