window.onload = function() {
    document.getElementById("add-item").addEventListener("click", function() {  // Function to allow the form to show up on the shop page
        document.getElementById("shop-form").style.visibility = "visible";
    });
    document.getElementById("cancel").addEventListener("click", function() {  // Function to hide the form.
        document.getElementById("shop-form").style.visibility = "hidden";
    });
    document.getElementById("submit").addEventListener("click", submitItem);  // Function to allow the user to submit the item on the form. 
}





