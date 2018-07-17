
let login = "http://localhost:3000/login";
window.onload = function() {
   document.getElementById('login-section').addEventListener("docus", function() {
       document.getElementById('first-requirements').style.visibility = "visible";
   })

    //Add event listener to create button.
    document.getElementById("createAcc").addEventListener('click', getEntryData);
};

//Get login form fields.
function getEntryData() {
   let firstName = document.getElementById('p_first').value;
   let lastName = document.getElementById('p_last').value;
   let email =  document.getElementById('p_email').value;
   var string = "@";
    if (email.includes(string)) {
        document.getElementById('p_email').style.color = "green";
    }else {
        document.getElementById('p_email').style.color = "red";
        alert("Please enter a valid email.");
        return false;
    }
   console.log(firstName + lastName + email);

//POST Object 
let data = {
    "first_name": firstName,
    "last_name": lastName,
    "email": email
}

fetch(login, {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
        "Content-Type": "application/json"
    }
})
.then(function(data) {
    return data.json();
})
.then(function(p) {
    console.log(p.first_name);
    alert(`Thank you for signing up ${firstName}!!!! An email will be sent to ${email} shorty.`)
})

};