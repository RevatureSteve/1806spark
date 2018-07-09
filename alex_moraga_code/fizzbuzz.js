document.addEventListener("change", fizzbuzz);

function fizzbuzz() {

    var N = document.getElementsByName("input")[0].value;
    //document.getElementsByTagName("li")[0].innerHTML = list;
    var listItem = document.createElement("li");
    var list = document.getElementById("unordered");
    list.appendChild(listItem);

    for (i = 1; i <= N; i++) {

        if (i % 3 == 0) {
            document.createTextNode("fizz");
        }
        else if (i % 5 == 0) {
            document.createTextNode("buzz");
            //buzz
        }
        else if (i % 3 == 0 && i % 5 == 0) {
            document.createTextNode("fizzbuzz");
            //fizzbuzz
        }
        else {
            document.createTextNode(i);//print out i/N value
        }
    }
}