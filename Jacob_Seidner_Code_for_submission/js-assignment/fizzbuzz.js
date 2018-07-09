document.addEventListener("change", makeList);

let unorderedList

function makeList() {
    let unorderedList = document.getElementsByTagName("ul")[0];
    for (let i=1; i <= document.getElementsByTagName("input")[0].value; i++) {
        let output = "";
        
        if (i % 3 === 0) 
        {output += "fizz";}
        if (i % 5 === 0) 
        {output += "buzz";}
        if (i % 3 !== 0 && i % 5 !== 0) 
            {output += i;}
    
    let  node = document.createElement("li")
    node.appendChild(document.createTextNode(output));
    unorderedList.appendChild(node)}}