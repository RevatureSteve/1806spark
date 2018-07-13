/*

    app.js is the main javascript file
*/

window.onload = function () {
    console.log('ready to run javascript!');
    document.getElementById('imagePopBtn').addEventListener("click", imagePopBtnClick);
    document.getElementById('clearBtn').addEventListener("click", clearImages);
    document.addEventListener('keydown', theXKey);
    document.onmousemove = updateMouseCoors;
}

var mouseX = 0;
var mouseY = 0;
var imageArray = [
    "https://worldwideinterweb.com/wp-content/uploads/2015/09/epic-gaming-pics.jpg",
    "https://worldwideinterweb.com/wp-content/uploads/2016/12/epic-awesome-pictures.png",
    "https://worldwideinterweb.com/wp-content/uploads/2016/12/epic-cat-pictures.png"

];
/*
    More images
    "https://worldwideinterweb.com/wp-content/uploads/2016/12/epic-image.png",
    "https://worldwideinterweb.com/wp-content/uploads/2016/12/epic-pics.png",
    "https://worldwideinterweb.com/wp-content/uploads/2016/12/epic-pictures-of-all-time.png",
    "https://worldwideinterweb.com/wp-content/uploads/2016/12/most-epic-movies.png"
    */

function updateMouseCoors(e){
    mouseX = e.pageX;
    mouseY = e.pageY;
}

function imagePopBtnClick() {
    console.log('Image Pop Btn Clicked!');

    var img = document.createElement('img');
    imageIndex = Math.floor(Math.random() * 3);
    img.src = imageArray[imageIndex];
    document.getElementsByTagName('body')[0].appendChild(img);
}


function clearImages() {
    console.log('clearing images');
    var body = document.getElementsByTagName('body');
    var image = document.getElementsByTagName('img');
    console.dir(image);
    body[0].removeChild(image[0]);
    if (image.length > 0) {
        //Recursion 
        clearImages();
    }
}

function theXKey(event) {
    if (event.key == 'x') {
        var image = document.createElement('img');
        imageIndex = Math.floor(Math.random() * 3);
        image.src = imageArray[imageIndex];
        var body = document.getElementsByTagName('body')[0];
        body.appendChild(image);
        image.style.position = 'fixed';
        console.log('Setting img at x' + mouseX + " y" + mouseY );
        image.style.left = (mouseX-200) + 'px';
        image.style.top = (mouseY-200) + 'px';
    }
}