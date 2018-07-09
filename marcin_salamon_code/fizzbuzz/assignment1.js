function createRandomList(){
    var arr = [];
    for(var i = 0; i < 10; i++){
        arr[i] = Math.floor(Math.random() * (101-1))+1;
    }
    return arr;
}

var myRandomList = createRandomList();

for(var i = 0; i < myRandomList.length; i++){
    console.log("Item " + i + " in the array is " + myRandomList[i]);
}