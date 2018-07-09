function createRandomList() {
    var i;
    var numbers = [];
    for (i = 0; i <= 9; i++) {
        var num = Math.floor(Math.random() * 101);
        numbers.push(num);
    }
    var myRandomList = numbers;

    var x;
    for(x = 0; x < numbers.length; x++) {
        var item = x;
        console.log("Item " + item + " in the array is " + myRandomList[x]);
    }

}

