


document.getElementById('btn').addEventListener('click', appendItems);
// document.addEventListener("change", appendItems);

function appendItems() {
    var getValue = document.getElementById("selectedNum").value;
    var getValue2 = document.getElementById("selectedNum2").value;
 
   var ul = document.getElementsByTagName("ul")[0]; 
   var length =document.getElementsByTagName("li").length;
   
   for (var i = 0; i < length; i++) {
       ul.removeChild(ul.childNodes[1]);
   }


  

   for (let i = getValue; i <= getValue2; i++) {
       var text = "";
       if (i % 3 == 0) {
           text += "fizz";
       }
       if (i % 5 == 0) {
           text += "buzz";
       }
       if (i % 3 !== 0 && i % 5 !== 0) {
           text += i;
       }
       var li = document.createElement("li");
       li.appendChild(document.createTextNode(text));
       ul.appendChild(li);
   }
}