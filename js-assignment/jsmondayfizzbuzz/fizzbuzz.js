
    document.addEventListener("change", appendItems);

    let getValue;
    
      function appendItems() {

      getValue = document.getElementById("num").value;

      var length = document.getElementsByTagName("li").length;

      var ul = document.getElementById("item");

      for (var i = 0; i < length; i++) {
          ul.removeChild(ul.childNodes[1]);
      }
    
      for (let i = 1; i <= getValue; i++) {
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
    }
  }