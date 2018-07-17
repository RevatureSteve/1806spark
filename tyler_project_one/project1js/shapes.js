window.onload = function () {
    document.getElementById("squareImage").onclick = myFunction;
    document.getElementById("circleImage").onclick = myFunction;
    document.getElementById("crescentImage").onclick = myFunction;
    document.getElementById("hexagonImage").onclick = myFunction;
}

function myFunction() {
    let imageId = this.id;
    console.log(this.id);
    var popup = document.getElementById(imageId + "Popup");
    popup.classList.toggle("show");

    if (popup.paused) {
        popup.play();
    }
    else {
        popup.pause();
    }

}
