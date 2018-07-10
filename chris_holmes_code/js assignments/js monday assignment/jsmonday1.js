function createRandomList() {
    var arr = [];
    for (var i = 0; i < 10; i++) {
        arr[i] = (Math.floor(Math.random() * 100));
    }
    return arr
}
//method = function defined in an object
var myRandomList = createRandomList();


for (i = 0; i < myRandomList.length; i++) {
    var text = "";
    text += "Item " + i + "in the array is " + myRandomList[i];
    console.log(text);


}
