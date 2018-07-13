var winaudio = new Audio('../audio/capture.wav');
winaudio.volume = 0.4;
var loseaudio = new Audio('../audio/pldead.wav');
loseaudio.volume = 0.4;
var restart = new Audio('../audio/bonus.wav');
restart.volume = 0.5;

var answer = [2, 4, 2];
var ansLength = 3;
var chars = 4;

window.onload = function music() {
    var audio = new Audio('../audio/road3.wav');
    audio.volume = 0.3;
    audio.loop = true;
    audio.play();
    restart.play();
    document.getElementById("guessbox").value = "";

    console.log(answer);
}

function attemptrun() {
    var num = document.getElementById("guessbox").value;

    if (!valid(num)) {  //check if the given value is valid
        return;
    }

    var digits = ("" + num).split("");

    if (check(digits, answer)) {        //display win message when correct guess is given
        winaudio.play();
        document.getElementById("guessbutton").disabled = true;
        var win = document.createElement("h1");
        var winNode = document.createTextNode("Your guess is correct! the answer is " + answer);
        win.appendChild(winNode);
        document.getElementById("Submit").appendChild(win);
        return;
    } else {
        loseaudio.play();
    }

    document.getElementById("guessbox").value = "";
}

function check(digits, answer) {                //check if given value matches the answer
    //console.log("in check");
    for (var l = 0; l < ansLength; l++) {
        if (digits[l] != answer[l]) {
            //console.log("failed match" + digits[l] + answer[l]);
            return false;
        }
    }
    //console.log("passed match");
    return true;
}

function valid(num) {      //check if given valueis valid (same length as answer and all numbers)
    if (num.length != ansLength) {
        return false;
    }
    for (var i = 0; i < num.length; i++) {
        if (num[i].charCodeAt() < 49 || num[i].charCodeAt() > 57 || num[i] > chars) {
            return false;
        }
    }
    return true;
}

function reset() {          //start a new game
    var submit = document.getElementById("Submit");    //remove win/lose message
    while (submit.hasChildNodes()) {
        submit.removeChild(submit.firstChild);
    }
    document.getElementById("guessbox").value = "";
    document.getElementById("guessbutton").disabled = false;
    restart.play();
}

function cancle() { //audio for closing login modal
    var cancle = new Audio('../audio/cancle.wav');
    cancle.volume = 0.3;
    cancle.play();
}