/*
    pokemon.js
*/

// The browser has window object with a property
//  called onload, this is a function that will be triggered
//  once the dom has finished being loaded
window.onload = function() {
    console.log("pokemon.js ready");
    document.getElementById("pokemonBtn").addEventListener('keypress', getPokemon)
}

let pokemon = null;
function getPokemon() {
    console.log("getPokemon called/invoked");
    let pokemonNumber = document.getElementById('pokemonNumber').value;

    if ( pokemonNumber > 151 ) {
        alert("Can't use a number bigger than 151");
    } else {
        console.log("Pokemon value: " + pokemonNumber);
        
        // fetch the pokemon
        fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber)
            .then( function(data) {
                return data.json(); // reading the response/data and looking for just the JSON object
            })
            .then( function(jsonPokemon) {
                pokemon = jsonPokemon;
                
                var pokeName = document.getElementById('pokeN');
                pokeName.innerHTML = pokemon.name;

                var pokePic = document.getElementById('pokeP');
                pokePic.src = pokemon.sprites.front_shiny;
            })
        
    }

}

// function arrow syntax...same but short
/* 
    test this as the 2nd parameter in the addEventListener function
    () => {
        console.log("");
    }
*/
