
    document.addEventListener("change", appendItems);
    document.addEventListener("change", appendItems);

    let getValueFrom;
    let getValueTo;
    
      function appendItems() {

      getValueTo = document.getElementById("numTo").value;
      getValueFrom = document.getElementById("numFrom").value;

      var length = document.getElementsByTagName("li").length;

      var ul = document.getElementById("item");
      
      for (var i = 0; i < length; i++) {
          ul.removeChild(ul.childNodes[1]);
      }
      for (let i = getValueFrom; i <= getValueTo; i++) {
        var char = "";
        if (i % 3 == 0) {
            char += "fizz";
        }
        if (i % 5 == 0) {
            char += "buzz";
        }
        

       else char += i;
    

        var node = document.createElement("li");

        node.appendChild(document.createTextNode(char));

        ul.appendChild(node);
    } } 