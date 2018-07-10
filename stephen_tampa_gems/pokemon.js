/*
    pokemon.js
*/

// The browser has window object with a property
// called onload, this is a function that will be triggered
// once the dom has finished being loaded
window.onload = function() {
    // global in here that is needed to reference any html
    console.log("pokemon.js ready");
    document.getElementById("pokemonBtn").addEventListener("click", getPokemon);
}
let pokemon = null;
function getPokemon() {
    console.log("getPokemon called/invoked");
    let pokemonNumber = document.getElementById("pokemonNumber").value;
    let pokemonName = document.getElementById("pokeName");
    let pokemonImg = document.getElementById("pokeSprite");
    
    if(pokemonNumber > 151) {
        alert("Can't use a number biger than 151")
        
    } else {
        console.log("Pokemon value: " + pokemonNumber);
        document.getElementById("pokeSprite").src = "https://cdn.dribbble.com/users/621155/screenshots/2835314/simple_pokeball.gif"
        // fetch the pokemon
        fetch("https://pokeapi.co/api/v2/pokemon/" + pokemonNumber)
            .then(function(data) {
                return data.json(); // reading the response and looking for just the json object
            })
            .then(function(jsonPokemon) {
                pokemon = jsonPokemon;
                pokemonName.innerHTML = pokemon.name;
                pokemonImg.src = pokemon.sprites.front_default;
            });
    }

}

// 3 ways to create a function
// function foo() {}
// var foo = function() {}

// var windows = {
//     onload: function () {}
// }

// Function arrow syntax. Same but short
/*
    Test this as the 2nd parameter in the addEventListener function
    () => {
        console.log("btn click");
    }
*/