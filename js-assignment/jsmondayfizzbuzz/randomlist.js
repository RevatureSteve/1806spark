

function createRandomList(){
var myRandomList = [];
    for(var i=0;i<10;i++){
myRandomList.push(Math.floor(Math.random() * 101));
    }
    return myRandomList
}

var myRandomList = createRandomList();

    for (var i=0;i<10;i++){
        console.log("Item " + i + " is " + myRandomList[i])

}


