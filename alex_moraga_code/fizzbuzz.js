document.addEventListener("input", fizzbuzz);

function fizzbuzz() {

    var N = document.getElementById("water").value;
    //document.getElementsByTagName("li")[0].innerHTML = list;
    var list = document.getElementById("unordered");


    for (i = 1; i <= N; i++) {
        var listItem = document.createElement("li");

        list.appendChild(listItem);

        if (i % 3 == 0 && i % 5 == 0) {
            document.getElementsByTagName("li")[i - 1].innerHTML = "buzzfizz";
        }
        else if (i % 3 == 0) {
            document.getElementsByTagName("li")[i - 1].innerHTML = "fizz";
        }
        else if (i % 5 == 0) {
            document.getElementsByTagName("li")[i - 1].innerHTML = "buzz";
        }
        else {
            document.getElementsByTagName("li")[i - 1].innerHTML = i;
        }
    }
}