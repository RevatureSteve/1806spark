function createRandomList() {
    var randArr = [];
    randArr.length = 10;
    var l = randArr.length;
    while ( l > 0 ) {
        l--;
        randArr[l] = Math.floor( ( Math.random() * 100 ) + 1 );
    }

    return randArr;
}

var myRandomList = createRandomList();

for ( var i = 0; i < myRandomList.length; i++ ) {
    console.log( "Item " + i + " in the array is " + myRandomList[i] + "\n");
}