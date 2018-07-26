function checkEm() {
    let rick = parseInt(document.getElementById("field1").value);
    let morty = parseInt(document.getElementById("field2").value);
    let list = document.getElementsByTagName("ul")[0];

    if (morty < rick){
    let temp = morty ;
    morty = rick;
    rick = temp;
    }

    for (var meg = rick; meg <= morty; meg++) {
        let listItem = document.createElement("li");
        list.appendChild(listItem);

        if (meg % 2 == 0 && meg % 5 == 0 && meg !== 0) {
            listItem.innerHTML = "PhotographyRaptor";
        }

        else if (meg % 2 == 0 && meg !== 0) {
            listItem.innerHTML = "Plup";
        }

        else if (meg % 5 == 0 && meg !== 0) {
            listItem.innerHTML = "Mango";
        }

        else {
            listItem.innerHTML = meg;
        }
    }
}

document.getElementById("loose").addEventListener("click",checkEm);