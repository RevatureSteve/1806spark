


document.getElementById("data").addEventListener("change", fizzBuzz);
function fizzBuzz()
{
    var liLength = document.getElementsByTagName("li").length;
    var ul = document.getElementById("renderList");
    for (var i = 0; i <liLength; i++)
    {
        ul.removeChild(ul.childNodes[1]);
    }
    var n = parseInt(event.target.value);
    for (var i=1; i <= n; i++){
        var li = document.createElement('li');
        if (i % 15 == 0) 
        {
            li.appendChild(document.createTextNode("FizzBuzz"));
    }
        else if (i % 3 == 0){
            li.appendChild(document.createTextNode("Fizz"));
        } 
        else if (i % 5 == 0) 
        {
            li.appendChild(document.createTextNode("Buzz"));
        }
        else {
            li.appendChild(document.createTextNode(i));
        }
        ul.appendChild(li); 
    }
    
}
