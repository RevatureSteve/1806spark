var myRandomList = [];

function createRandomList()
{
 for (var i = 0; i <= 9; i++)
 {
    myRandomList.push(Math.floor(Math.random() * 100) + 1 );
    
 }
 return myRandomList;
}
function readArray()
{
    for (var i = 0; i < myRandomList.length; i++ )
    {
        console.log("index is: " + i + " item is " + myRandomList[i]);
    }
    return "completed";
}