var someUrl = 'http://localhost:3000/pages/profile.html';
var anotherUrl = 'http://localhost:3000/register/users';
findUsers();
let accountName = document.getElementById("accountName");
let userEmail = document.getElementById("emailAddress");
let userAccountName = document.getElementById("aUsername");
document.getElementById("addFavoriteBtn").addEventListener('click', addFavorite);

// let jsonObject = null;
function findUsers() {
    fetch(anotherUrl).then(data => {
        return data.json();
    }).then(json => {
        jsonObject = json
        
        console.log(jsonObject);
        accountName.innerHTML = jsonObject[jsonObject.length - 1].firstName;
        userEmail.innerHTML = jsonObject[jsonObject.length - 1].emailAddress;
        userAccountName.innerHTML = jsonObject[jsonObject.length - 1].username;
        let favoritesArray = jsonObject[jsonObject - 1].favoriteMovies;
        for (let i = 0; i < favoritesArray.length; i++) {
            let divChild = document.createElement("div");
            
        }
    });
}

function addFavorite() {
    let newFavorite = document.getElementById("addMovieTitle").value;
    
    let data = {
        "favoriteMovies": newFavorite
    }

    fetch(someUrl, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(data => data.json()).then(p => {
        console.log(p);
    })
}
