let url = "http://localhost:3000/login";

//Login form fields.
let firstName = document.getElementById("p_first");
let lastName = document.getElementById("p_last");
let email = document.getElementById("p_email");
//Add event listener to create button.
document.getElementById("createAcc").addEventListener("click", function() {
   console.log("You have started creating an account!")
});

let data = {
   "firstName": firstName,
   "lastName": lastName,
   "email": email
};
