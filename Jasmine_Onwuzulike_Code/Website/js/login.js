let url = "http://localhost:3000/login";
let firstName = document.getElementById("p_first");
let lastName = document.getElementById("p_last");
let email = document.getElementById("p_email");
//Add event listener to create button.
document.getElementById("createAcc").addEventListener("click", function() {
    console.log(`Thank you for creating a account ${firstName}`);
});




//Post information about new user.
let data = {
    "firstName": firstName,
    "lastName": lastName,
    "email": email
}

fetch(url , {
  method: POST,
  body: JSON.stringify(data),
})
.then(data=> data.json()).then(entry => {
    console.log(entry.firstName);
    console.log(entry.lastName);
    console.log(entry.email);
});