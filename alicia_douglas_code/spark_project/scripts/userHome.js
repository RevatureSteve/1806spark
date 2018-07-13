window.onload = function () {
    // variables
    let home = document.getElementById('home');
    let upload = document.getElementById("upload");
    let favs = document.getElementById("favs");
    let picView = document.getElementById("picView");
    let uploadView = document.getElementById("uploadView");
    let favView = document.getElementById("favView");

    // Event Listeners
    home.addEventListener("click", homeFN);
    upload.addEventListener("click", uploadFN);
    favs.addEventListener("click", favsFN);
    document.getElementById("src").addEventListener("input", insertPic);
    document.getElementById("uploadBtn").addEventListener("click", postPic)
}

// shows the user their home page when they click home on side nav bar
function homeFN() {
    home.style.color = "white";
    home.style.backgroundColor = "green";
    upload.style.color = "black";
    upload.style.backgroundColor = "lightgray";
    favs.style.color = "black";
    favs.style.backgroundColor = "lightgray";
    picView.style.display = "block";
    uploadView.style.display = "none";
    favView.style.display = "none";
}

// shows the user the upload page when they click upload on side nav bar
function uploadFN() {
    home.style.color = "black";
    home.style.backgroundColor = "lightgray";
    upload.style.color = "white";
    upload.style.backgroundColor = "green";
    favs.style.color = "black";
    favs.style.backgroundColor = "lightgray";
    picView.style.display = "none";
    uploadView.style.display = "block";
    favView.style.display = "none";
}

// shows the user their favs page when they click favorites on side nav bar
function favsFN() {
    home.style.color = "black";
    home.style.backgroundColor = "lightgray";
    upload.style.color = "black";
    upload.style.backgroundColor = "lightgray";
    favs.style.color = "white";
    favs.style.backgroundColor = "green";
    picView.style.display = "none";
    uploadView.style.display = "none";
    favView.style.display = "block";
}

// inserts picture using inputed src
function insertPic() {
    let src = document.getElementById('src').value;
    document.getElementById('newPic').src = src;
}

// posts picture to the user home page
function postPic() {
    let pic = {
        src: document.getElementById('src').value,
        location: document.getElementById('newPicLocation').value,
        description: document.getElementById("newPicDesc").value
    };
    if (pic.src == "") {
        alert('Fill out the image source location field')
    } else if (pic.location == "") {
        alert('Fill out the location field')
    } else if (pic.description == "") {
        alert('Fill out the descritpion field')
    } else {
        let div = document.getElementsByClassName("posts");
        let clone = div[0].cloneNode(true);
        document.getElementById('picView').appendChild(clone);
        let index = div.length - 1;
        document.getElementsByClassName('pics')[index].src = pic.src;
        document.getElementsByClassName('location')[index].value = pic.location;
        document.getElementsByClassName('description')[index].value = pic.description;
    }

}

