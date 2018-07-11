// Validates registration information before submitting to server

// Global variables

window.onload(() =>{
    // Set Listeners
    let registerPassword = document.getElementById("registerPassword");
    registerPassword.addEventListener("change", () => passwordChanged(registerPassword));
})

// checks for correct password parameters in a changed password element
function passwordChanged(node){
    node.style.backgroundColor = "green";
}