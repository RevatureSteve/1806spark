document.getElementById("skinBtn").addEventListener("click", addOne);

function addOne() {
    var one = document.getElementById("skinOne");
    var two = document.getElementById("skinTwo");
    var three = document.getElementById("skinThree");

    let x = document.getElementById("skinNum");
    let y = parseInt(x.value);

    switch (y) {
        case 1:
            let a = parseInt(one.innerHTML);
            a += 1;
            one.innerHTML = a;
            break;
        case 2:
            let b = parseInt(two.innerHTML);
            b += 1;
            two.innerHTML = b;
            break;
        case 3:
            let c = parseInt(three.innerHTML);
            c += 1;
            three.innerHTML = c;
            break;
    }
}