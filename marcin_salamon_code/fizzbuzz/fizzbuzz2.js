var unordered;

window.addEventListener('load', function () {
    document.getElementById('btn2').onclick = fizzbuzz2;
    unordered = document.getElementsByTagName('ul')[0];
});

function fizzbuzz2() {
    while (unordered.firstChild) {
        unordered.removeChild(unordered.firstChild);
    }

    let n1 = parseInt(document.getElementById('n1').value);
    let n2 = parseInt(document.getElementById('n2').value);

    if (n1 > n2) {
        let temp = n1;
        n1 = n2;
        n2 = temp;
    }


    for (var i = n1; i <= n2; i++) {

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