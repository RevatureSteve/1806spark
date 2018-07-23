document.getElementById("button").addEventListener("click", fizzbuzz);



function fizzbuzz() {

    var N_1 = document.getElementById("box_one").value;
    var N_2 = document.getElementById("box_two").value;
    //document.getElementsByTagName("li")[0].innerHTML = list;
    var list = document.getElementById("unordered");
    var N_1 = parseInt(N_1);
    var N_2 = parseInt(N_2);

    for (i = N_1, j = 0; i <= N_2 , j <= N_2 - N_1; i++, j++) {
        var listItem = document.createElement("li");

        list.appendChild(listItem);

        if (i % 3 == 0 && i % 5 == 0) {
           
            document.getElementsByTagName("li")[j].innerHTML = "buzzfizz";
        }
        else if (i % 3 == 0) {
           
            document.getElementsByTagName("li")[j].innerHTML = "fizz";
        }
        else if (i % 5 == 0) {
           
            document.getElementsByTagName("li")[j].innerHTML = "buzz";
        }
        else {
            
            document.getElementsByTagName("li")[j].innerHTML = i;
        }
    }
}