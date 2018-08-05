var up = false;
var low = false;
var number = false;
var length = false;

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
    if (!up || !low || !number || !length) {
        return false;
    }
    var extend = new Audio('../audio/extend.wav');
    extend.volume = 0.3;
    extend.play();
    return true;
}

function uvalid() {
    var name = document.getElementById("usrbox").value;

}

function pvalid() {
    var lowcheck = false
    var upcheck = false
    var numcheck = false
    var pass = document.getElementById("passbox").value;
    for (var i = 0; i < pass.length; i++) {
        if (pass.charAt(i).charCodeAt() < 123 && pass.charAt(i).charCodeAt() > 96) {
            lowcheck = true;
        }
        if (pass.charAt(i).charCodeAt() < 91 && pass.charAt(i).charCodeAt() > 64) {
            upcheck = true;
        }
        if (pass.charAt(i).charCodeAt() < 58 && pass.charAt(i).charCodeAt() > 47) {
            numcheck = true;
        }
    }
    if (lowcheck == true) {
        low = true;
        document.getElementById("lower").style.color = "green";
    } else {
        low = false;
        document.getElementById("lower").style.color = "red";
    }
    if (upcheck == true) {
        up = true;
        document.getElementById("upper").style.color = "green";
    } else {
        up = false;
        document.getElementById("upper").style.color = "red";
    }
    if (numcheck == true) {
        number = true;
        document.getElementById("number").style.color = "green";
    } else {
        number = false;
        document.getElementById("number").style.color = "red";
    }
    if (pass.length >= 8 && pass.length <= 20) {
        length = true;
        document.getElementById("length").style.color = "green";
    } else {
        length = false;
        document.getElementById("length").style.color = "red";
    }
}