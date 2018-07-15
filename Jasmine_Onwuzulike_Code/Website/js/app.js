//Allows the form to display for a user to suggest an item.
document.getElementById('add-item').addEventListener("click", function() {
    document.getElementById('shop-form').style.visibility = 'visible';
});
//Allows user to submit suggested item
document.getElementById('submit').addEventListener("click", function() {
    let itemName = document.getElementById('item-name').value;
    let itemSource = document.getElementById('item-source').value;
    let itemImage = document.getElementById('item-image').value;
    alert("Thank you for your submission");
    return (itemName + " " + itemSource + " " + itemImage);
});

//Close the form.
document.getElementById('cancel-item').addEventListener("click", function() {
    document.getElementById('shop-form').style.visibility = 'hidden';
});