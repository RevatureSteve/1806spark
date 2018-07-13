// creating the audio objects

var guessaudio = new Audio('../audio/shot.wav');
guessaudio.volume = 0.4;
var winaudio = new Audio('../audio/capture.wav');
winaudio.volume = 0.7;
var loseaudio = new Audio('../audio/pldead.wav');
loseaudio.volume = 0.4;
var restart = new Audio('../audio/bonus.wav');
restart.volume = 0.5;
var warning = new Audio('../audio/warning.wav');
warning.volume = 0.4;

var attemptnum = 0;
var attempts = 10;
var answer = [];
var ansLength = 4;
var chars = 6;
var digits2 = [];
var answerholder = [];

window.onload = function music() {       //plays music and creates the hidden answer
    var audio = new Audio('../audio/road3.wav');
    audio.volume = 0.3;
    audio.loop = true;
    audio.play();
    restart.play();
    document.getElementById("guessbox").value = "";

    for (var i = 0; i < ansLength; i++) {    //create answer
        answer[i] = Math.floor(Math.random() * chars) + 1;
    }
    console.log(answer);
    answerholder = answer.slice(0, 4);
}

function attemptrun() {     //when the user clicks the submit button....
    var num = document.getElementById("guessbox").value;
    var num2 = document.getElementById("guessbox").value;

    if (!valid(num)) {  //check if the given value is valid
        return;
    }

    var guess = document.createElement("li");  //make list element and display guess
    var t = document.createTextNode(num);
    guess.appendChild(t);
    document.getElementById("guesses").appendChild(guess);

    var digits = ("" + num).split("");
    digits2 = ("" + num2).split("");

    if (check(digits, answer)) {        //display win message when correct guess is given
        winaudio.play();
        document.getElementById("guessbutton").disabled = true;
        var win = document.createElement("h1");
        var winNode = document.createTextNode("Your guess is correct! the answer is " + answer);
        win.appendChild(winNode);
        document.getElementById("Submit").appendChild(win);
        return;
    } else {
        guessaudio.play();
    }

    gethints(digits, answerholder);  //get hints for the right column
    answerholder = answer.slice(0, 4);

    document.getElementById("guessbox").value = "";
    ++attemptnum;   //set current attempt number

    if (attemptnum >= attempts) {     //check for final attempt
        var lose = document.createElement("h1");
        var loseNode = document.createTextNode("Out of attempts. the answer is " + answer);
        lose.appendChild(loseNode);
        document.getElementById("Submit").appendChild(lose);
        document.getElementById("guessbutton").disabled = true;
        loseaudio.play();
        return;
    } else if (attemptnum == attempts - 1) {
        warning.play();
    }
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

function valid(num) {      //check if given value is valid (same length as answer and consists of valid numbers)
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

function gethints(digits, ans) {
    for (var p = 0; p < ansLength; p++) {
        ans[p] = ans[p].toString();

    }
    var correctPlace = 0;
    var wrongPlace = 0;
    for (var m = 0; m < ansLength; m++) {
        for (var n = 0; n < ansLength; n++) {
            //console.log("testing." + m + digits[m] + n + ans[n])
            if (digits[m] === ans[n] && m == n) {                   //find correct numbers in the correct possition
                //console.log("correct");
                ++correctPlace;
                ans[n] = "x";
                digits[m] = "y";
            }
        }
    }
    for (var m = 0; m < ansLength; m++) {
        for (var n = 0; n < ansLength; n++) {
            //console.log("testing." + m + digits[m] + n + ans[n])
            if (digits[m] === ans[n] && m != n) {                   //find correct numbers in the wrong possition
                //console.log("wrong");
                ++wrongPlace;
                ans[n] = "x";
                digits[m] = "y";
                //console.log(typeof digits[m] + typeof ans[n])
            }
        }
    }
    var placement = document.createElement("li");       //make new list element and display hints
    var q = document.createTextNode(correctPlace + " in the right place and " + wrongPlace + " in the wrong place");
    placement.appendChild(q);
    document.getElementById("hints").appendChild(placement);
}

function reset() {          //start a new game
    attemptnum = 0;
    digits2 = [];
    for (var r = 0; r < ansLength; r++) {
        answer[r] = Math.floor(Math.random() * chars) + 1;
    }
    console.log(answer);
    answerholder = answer.slice(0, 4);
    var hints = document.getElementById("hints");  //remove hints
    while (hints.hasChildNodes()) {
        hints.removeChild(hints.firstChild);
    }
    var guesses = document.getElementById("guesses");   //remove guesses
    while (guesses.hasChildNodes()) {
        guesses.removeChild(guesses.firstChild);
    }
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