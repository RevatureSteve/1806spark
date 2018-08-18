/* 
    pokemon.js
*/

// The browser has window object with a property
// called onload, this is a function that will be triggered
// once the dom has finished being loaded
window.onload = function () {
    console.log("pokemon.js ready");
    document.getElementById("pokemonBtn").addEventListener("click", getPokemon);
}

let pokemon = null;

// function getPokemon() {
//     console.log('getPokemon called/invoked');
//     let pokemonNumber = document.getElementById('pokemonNumber').value;
//     if (pokemonNumber > 151) {
//         alert('Can\'t use a number bigger than 151');
//     } else {
//         console.log("Pokemon value: " + pokemonNumber);
//         fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber).then(function (data) {
//             return data.json(); // reading the response and lookinf for just the json object
//         })
//             .then(function (jsonPokemon) {
//                 pokemon = jsonPokemon; // allowing jsonPokemon to be seen globally
//             });
//     }
// }

function getPokemon() {
    let pokemonNumber = document.getElementById('pokemonNumber').value;
    let h1 = document.getElementById("pokeName");
    let img = document.getElementById("pokeSprite");
    console.log('getPokemon called/invoked');
    (pokemonNumber > 151) ?
        alert('Can\'t use a number bigger than 151') :
        h1.innerHTML = "Loading...";
        img.src = "https://i.pinimg.com/originals/40/dc/6a/40dc6a0cb6f33ae2cf6afd5381159113.gif";
        // https://media.giphy.com/media/Ah2Okx99r3uX6/giphy.gif 
        //   https://lh3.googleusercontent.com/-0oCWbjVk3iM/V4ouBk3-nhI/AAAAAAAAOsM/8d63UWnVAzYjqFTJSuWgwsW2ZADWvfqPg/w500-h300/hatching-egg-loader.gif
        console.log("Pokemon value: " + pokemonNumber);
    fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber).then(data => {
        return data.json(); // reading the response and lookinf for just the json object
    })
        .then(jsonPokemon => {
            pokemon = jsonPokemon;
            h1.innerHTML = pokemon.name; // allowing jsonPokemon to be seen globally
            img.src = pokemon.sprites.back_shiny;
        });
}

