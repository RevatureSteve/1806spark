// welcome to tic-tac-toe
// Marcin Salamon
// use cases:
// -2 players
// -vs ai /bonus
// -choose x or o
// -pick where you put x or o
// -drag drop /bonus use case
// -start a new game
// -end game condition
// -end game screen
// -reset game

let player = 1;
let boolWin = false;
window.onload = function () {
    var box = document.getElementsByClassName("box");

    for (let i = 0; i < box.length; i++) {
        box[i].addEventListener("click", boxClick);
    }

    this.document.getElementById('newGame').addEventListener('click', function(){
        window.location.href = window.location.href;
    });

}
// Alicia

function boxClick() {
    if (this.innerText == "?") {
        if (player == 1) {
            //console.log(player);
            this.innerText = "X";
            winCheck();
            player = 2;
        } else if (player == 2) {
            //console.log(player);
            this.innerText = "O";
            winCheck();
            player = 1;
        }
    }

    console.log(this.id);

    if (boolWin) {
        console.log('win');
    }
    else {
        document.getElementById('player').innerText = "Player " + player;
    }
}

//Richard

function winCheck() {
    var box1 = document.getElementById('1').innerText;
    var box2 = document.getElementById('2').innerText;
    var box3 = document.getElementById('3').innerText;
    var box4 = document.getElementById('4').innerText;
    var box5 = document.getElementById('5').innerText;
    var box6 = document.getElementById('6').innerText;
    var box7 = document.getElementById('7').innerText;
    var box8 = document.getElementById('8').innerText;
    var box9 = document.getElementById('9').innerText;
    console.log(box1);
    if (box1 == box2 && box2 == box3 && box1 != '?') {
        document.getElementById('player').innerHTML = "Player " + player + " wins!";
        boolWin = true;
    }
    if (box4 == box5 && box5 == box6 && box4 != '?') {
        document.getElementById('player').innerText = "Player " + player + " wins!";
    }
    if (box7 == box8 && box8 == box9 && box7 != '?') {
        document.getElementById('player').innerText = "Player " + player + " wins!";
    }
    if (box1 == box4 && box4 == box7 && box1 != '?') {
        document.getElementById('player').innerText = "Player " + player + " wins!";
    }
    if (box2 == box5 && box5 == box8 && box2 != '?') {
        document.getElementById('player').innerText = "Player " + player + " wins!";
    }
    if (box3 == box6 && box6 == box9 && box3 != '?') {
        document.getElementById('player').innerText = "Player " + player + " wins!";
    }
    if (box1 == box5 && box5 == box9 && box1 != '?') {
        document.getElementById('player').innerText = "Player " + player + " wins!";
    }
    if (box3 == box5 && box5 == box7 && box3 != '?') {
        document.getElementById('player').innerText = "Player " + player + " wins!";
    }

    /*Chris*/

    // Drake

}