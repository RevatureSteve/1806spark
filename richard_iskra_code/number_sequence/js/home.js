window.onload = function music() {  //home page music
    var title = new Audio('../audio/title.wav');
    title.volume = 0.3;
    title.loop = true;
    title.play();
}

function btnpress() {   //audio when opening login modal
    var boon = new Audio('../audio/boon.wav');
    boon.volume = 0.5;
    boon.play();
}

function cancle() { //audio for closing login modal
    var cancle = new Audio('../audio/cancle.wav');
    cancle.volume = 0.3;
    cancle.play();
}

function login() {  //audio for "logging in"
    var extend = new Audio('../audio/extend.wav');
    extend.volume = 0.3;
    extend.play();
}

