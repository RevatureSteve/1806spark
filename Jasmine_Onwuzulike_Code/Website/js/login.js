let url = "http://localhost:3000/login";

//Add event listener to create button.
document.getElementById("createAcc").addEventListener("click", getEntryData);

//Get login form fields.
function getEntryData() {
   let firstName = document.getElementById('p_first').value;
   let lastName = document.getElementById('p_last').value;
   let email = docuemt.getElementById('p_email').value;
    return firstName + " " + lastName + " " + email;
};

// let data = {
//     "first name" : firstName,
//     "last name" : lastName,
//     "email" : email
// };

// fetch(url, {
//     method: 'POST',
//     body:JSON.stringify(data)
// })
// .then(data => data.json())
// .then(p => {
//     alert(p.firstName + " " + p.lastName + " " + p.email);
// });



