
function getInput() {
    var x = document.getElementById("in").value;
    var list = document.getElementById("demo");
    var count = [];
    for (var i = 0; i <= x; i++) {
    console.log(i);
    list.innerHTML += i;
    count.push(i); 
    }
    return count;
}

function clearAll() {
   var x = document.getElementById("in").value = " ";
   var y = document.getElementById("demo").innerHTML = " ";
}



