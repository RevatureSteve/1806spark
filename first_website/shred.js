//Javascript for the Shredding page
window.onload = function () {
    console.log("hello!");
    document.getElementById("submit").addEventListener('click', body_part_selection);
}

let body_part = null;
function body_part_selection() {
    console.log('button has been clicked');
    
    let body_part = document.getElementById('selection').value;
    let body_selection = document.getElementById('selection_complete');
    let url_s = document.getElementsByTagName('a');

    console.log(body_part);
    if (body_part == "Chest") {
        body_selection.href = "file:///C:/Users/Alex%20Moraga/my_git_repos/1806spark/first_website/pages/Chest.html";
        body_selection.innerHTML = ("Your " + body_part + " exercises are here! Click here to see! ");

    } else if (body_part == "Back") {
        body_selection.href = "file:///C:/Users/Alex%20Moraga/my_git_repos/1806spark/first_website/pages/Back.html";
        body_selection.innerHTML = ("Your " + body_part + " exercises are here! Click here to see! ");
    }
    else if (body_part == "Shoulder") {
        body_selection.innerHTML = ("Your " + body_part + " exercises are here! Click here to see! ");
    }
    else if (body_part == "Arms") {
        body_selection.innerHTML = ("Your " + body_part + " exercises are here! Click here to see! ");
    }
    else if (body_part == "Legs") {
        body_selection.innerHTML = ("Your " + body_part + " exercises are here! Click here to see! ");
    }
    else if (body_part == "Shoulder") {
        body_selection.innerHTML = ("Your " + body_part + " exercises are here! Click here to see! ");
    }
    else{
        
    }

}


