let page = "http://localhost:1313/jungle";
var comments = null;
callComments();

function callComments() {
    fetch(page).then((resp) => {
        return resp.json();
    }).then((info) => {
        console.log(info);
        comments = info;
        setComments(comments);
    });
}

function setComments(com) {
    console.log("setting comments to page")
    console.log(com);
    var commentsSection = document.getElementById("savedComment");

    for (let i = 0; i < com.length; i++) {
        let newDiv = document.createElement("div");
        newDiv.innerHTML = com[i].name + " wrote:  " + com[i].comment;
        commentsSection.appendChild(newDiv);
    }
}