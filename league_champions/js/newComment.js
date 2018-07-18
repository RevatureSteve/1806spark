window.onload = function () {
    document.getElementById("commentBtn").addEventListener("click", newComment);
}

function newComment() {
    var newCommentString = document.getElementById("savedComment");
    console.log(newCommentString);
    var name = document.getElementById("nameBox").value;
    var comment = document.getElementById("commentBox").value;

    var info = {
        "name": name,
        "comment": comment
    }

    fetch(page, {
        method: "POST",
        body: JSON.stringify(info),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(info => info.json()).then(c => {
        console.log(c);
        newCommentString.innerHTML = c.name + " " + c.comment;
    });
    location.reload(true);
}