window.onload = function () {
    console.log('Sign up is ready to go');
}

document.getElementById('signUp-password').addEventListener('keyup', pw);

function pw() {
    console.log('click');

    var itemOne = document.getElementById('signUp-listItem1');
    var itemTwo = document.getElementById('signUp-listItem2');
    var itemThree = document.getElementById('signUp-listItem3');
    var itemZero = document.getElementById('signUp-listItem0');
    var b = document.getElementById('signUp-password');
    var upperCase = /[A-Z]/g;
    var numbers = /[0-9]/g;
    var symbols = /[ ! @ # $ % & ' * + - / = ? ^ _ ` { | } ~]/g;

    if (b.value.match(upperCase)) {
        console.log('uppercase found')
        itemOne.classList.remove('invalid');
        itemOne.classList.add('valid');
    } else {
        itemOne.classList.remove('valid');
        itemOne.classList.add('invalid');
    }

    if (b.value.match(numbers)) {
        console.log('number found')
        itemTwo.classList.remove('invalid');
        itemTwo.classList.add('valid');
    } else {
        itemTwo.classList.remove('valid');
        itemTwo.classList.add('invalid');
    }

    if (b.value.match(symbols)) {
        console.log('symbol found')
        itemThree.classList.remove('invalid');
        itemThree.classList.add('valid');
    } else {
        itemThree.classList.remove('valid');
        itemThree.classList.add('invalid');
    }

    if (b.value.length >= 8) {
        console.log('over 8 characters')
        itemZero.classList.remove('invalid');
        itemZero.classList.add('valid');
    } else {
        itemZero.classList.remove('valid');
        itemZero.classList.add('invalid');
    }
    return true;
}


function btn() {

    var a = document.getElementById('signUp-userName').value;
    var b = document.getElementById('signUp-password').value;
    var c = document.getElementById('signUp-name').value;
    var d = document.getElementById('signUp-email').value;
    var x = document.getElementById('signUp-btn');


    var email = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    console.log(a);
    console.log(b);
    console.log(c);
    console.log(d);

    console.log('button pressed');

    if (a.length >= 3) {
        console.log('username is: ' + a);
        document.getElementsByClassName('userName')[0].style.color = 'black';
    } else {
        console.log('insufficient characters');
        document.getElementsByClassName('userName')[0].style.color = '#ff0000';
    }

    if (b.length >= 8) {
        console.log('username is: ' + b);
        document.getElementsByClassName('password')[0].style.color = 'black';
    } else {
        console.log('insufficient characters');
        document.getElementsByClassName('password')[0].style.color = '#ff0000';
    }

    if (c.length >= 5) {
        console.log('username is: ' + c);
        document.getElementsByClassName('actualName')[0].style.color = 'black';
    } else {
        console.log('username has insufficient characters');
        document.getElementsByClassName('actualName')[0].style.color = '#ff0000';
    }

    if (d.match(email)) {
        console.log('email is: ' + d);
        document.getElementsByClassName('email')[0].style.color = 'black';
    } else {
        console.log('insufficient characters');
        document.getElementsByClassName('email')[0].style.color = '#ff0000';
    }
}
