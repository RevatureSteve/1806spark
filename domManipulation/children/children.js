// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>


function getAnchorChildren() {
    var a = document.getElementsByTagName("a");
    var span = document.getElementsByTagName("span");

    for (var i = 0; i < a.length; i++) {
        if (a[i].tagName = "SPAN")
            console.log(a[i].textContent);
    }
}