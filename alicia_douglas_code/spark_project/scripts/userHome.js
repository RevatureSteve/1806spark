
let url = 'http://localhost:3001/userHome';
let commentUrl = 'http://localhost:3001/comments'



window.onload = function () {
    // variables
    let home = document.getElementById('home');
    let upload = document.getElementById("upload");
    let favs = document.getElementById("favs");
    let picView = document.getElementById("picView");
    let uploadView = document.getElementById("uploadView");
    let favView = document.getElementById("favView");
    let pics = document.getElementsByClassName('pics');
    // Event Listeners
    home.addEventListener("click", homeFN);
    upload.addEventListener("click", uploadFN);
    favs.addEventListener("click", favsFN);
    document.getElementById("src").addEventListener("input", insertPic);
    document.getElementById("uploadBtn").addEventListener("click", postPic);
    // document.getElementById('uploadForm').addEventListener('submit', postPic);
    for (let i = 0; i < pics.length; i++) {
        pics[i].addEventListener('click', modal);
    };
    document.getElementById('closePopup').addEventListener('click', () => {
        document.getElementById('imgPopup').style.display = 'none';
        let element = document.getElementById('comments');
        while (element.childElementCount != 0) {
            element.removeChild(element.childNodes[0])
        }
    });
    document.getElementById('commentBtn').addEventListener('click', postComment);
}


// Popup image with comments
function modal() {
    let comments = [];
    document.getElementById('imgPopup').style.display = 'block';
    let img = event.target.src;
    let element = document.getElementById('comments');
    document.getElementById('popupImg').src = img;
    for (let i = 0; i < picture.length; i++) {
        if (picture[i].url == img) {
            comments = picture[i].comments;
        };
    };
    for (let f = 0; f < comments.length; f++) {
        let para = document.createElement('p');
        let node = document.createTextNode(comments[f].username + ": " + comments[f].comment);
        para.appendChild(node);
        element.appendChild(para);
    }
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
    let src = document.getElementById('src').value;
    let location = document.getElementById('newPicLocation').value;
    let description = document.getElementById("newPicDesc").value;

    if (src == "") {
        return alert('Please fill out the image source location field.');
    };
    if (location == "") {
        return alert('Please fill out the location field.');
    }

    // Post Data
    let data = {
        // "userName": String,
        "url": src,
        "location": location,
        "descritpion": description
    };

    fetch(url, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(data => data.json()).then(q => {
        console.log(q);
        alert('picture posted');
    });
    let div = document.getElementsByClassName("posts");
    let clone = div[0].cloneNode(true);
    document.getElementById('picView').appendChild(clone);
    let index = div.length - 1;

    // Post pic to main page
    document.getElementsByClassName('pics')[index].src = src;
    document.getElementsByClassName('location')[index].value = location;
    document.getElementsByClassName('description')[index].value = description;

}

// Add comment to database
function postComment() {
    let comment = document.getElementById('commentText').value;
    let commentArea = document.getElementById('comments');
    let user = 'adouglas'
    let src = this.parentElement.parentElement.children[1].children[0].src;
    let id = null;
    for (let i = 0; i < picture.length; i++) {
        if (src == picture[i].url) {
            id = picture[i]._id;
        }
    }
    let data = {
        'id': id,
        'comment': {
            'username': user,
            'comment': comment
        }
    }

    fetch(commentUrl, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(data => data.json()).then(q => {
        console.log(q);
    })

    // add comment to modal right away
    let para = document.createElement('p');
    let node = document.createTextNode(user + ": " + comment);
    para.appendChild(node);
    commentArea.appendChild(para);
}


var picture = null;
callPictures();

function callPictures() {
    fetch(url).then((resp) => {
        return resp.json();
    }).then((data) => {
        console.log(data);
        picture = data;
        setPictures(picture);
    })
}


// upload new picture
function setPictures(q) {
    console.log('setting pictures to page');
    console.log(q);
    for (let i = 0; i < q.length; i++) {
        let div = document.getElementsByClassName("posts");
        let clone = div[0].cloneNode(true);
        document.getElementById('picView').appendChild(clone);
        let index = div.length - 1;
        // document.getElementsByClassName('userName')[index].innerHTML = q[i].userName;
        document.getElementsByClassName('pics')[index].src = q[i].url;
        document.getElementsByClassName('location')[index].value = q[i].location;
        document.getElementsByClassName('description')[index].value = q[i].descritpion;
    }
}
