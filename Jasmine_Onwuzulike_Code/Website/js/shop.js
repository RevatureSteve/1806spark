window.onload = function() {
    document.getElementById("add-item").addEventListener("click", function() {  // Function to allow the form to show up on the shop page
        document.getElementById("shop-form").style.visibility = "visible";
    });
    document.getElementById("cancel").addEventListener("click", function() {  // Function to hide the form.
        document.getElementById("shop-form").style.visibility = "hidden";
    });
    document.getElementById("submit").addEventListener("click", submitItem);
}

submitItem = () => {
    let item = document.getElementById("name").value;
    let source = document.getElementById("source").value;
    let image = document.getElementById("image").value;
    window.alert("Your suggestion was sent! \n Item Name: " + item + " \n Source: " + source + "\n Image: " + image);
}




