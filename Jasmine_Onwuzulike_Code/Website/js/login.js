let url = "http://localhost:3000/login";

//Add event listener to create button.
document.getElementById("createAcc").addEventListener("click", getEntryData);

//Get login form fields.

function getEntryData() {
    let firstName = document.getElementById("p_first").value;
    let lastName = document.getElementById("p_last").value;
    let email = document.getElementById("p_email").value;
    console.log(firstName);
    console.log(lastName);
    console.log(email);

};



