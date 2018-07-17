var someUrl = 'http://localhost:3000/register/users';
document.getElementById("loginBtn").addEventListener("click", login);

function login(){
    
    let email = document.getElementById('inputEmail').value;
    let password = document.getElementById('inputPassword').value;

    let data = {
        "emailAddress": email,
        "password": password
    }
    fetch(someUrl, {
        method: 'POST',  // to post data to the db
        body: JSON.stringify(data),
        headers:{
            'Content-Type': 'application/json'
        }
    // }).then(response => {
    //     if (!response.ok) {
    //         return response.status(404).send("User not found");
    //     }
    }).then(data => data.json()).then(u => {
        for (let i = 0; i < u.length; i++) {
            if (u[i].emailAddress == email) {
                console.log(u[i].emailAddress);
            }
        }
    });
    
    window.location.href = "./profile.html";
}
// let jsonObject = null;

