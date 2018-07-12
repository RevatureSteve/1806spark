/*
pokemon.js
 */

//The browser has window object with a property
//called onload, this is a function that will be triggered 
//once the dom has finished being loaded

window.onload = function () {
    console.log('pokemon.js is ready');                              //funtion()
    document.getElementById('pokemonBtn').addEventListener('click', getPokemon);
}

// function getPokemon() {
//     console.log('getPokemon called/invoked');
//     let pokemonNumber = document.getElementById('pokemonNumber').value;

//     console.log('Pokemon value: ' = pokemonNumber);
//     if (pokemonNumber > 151) {
//         alert('Can\'t use a number bigger than 151');

//     } else {
//         console.log('Pokemon value: ' + pokemonNumber);

//     }

// }
function getPokemon() {
    console.log('getPokemon called/invoked');
    let pokemonNumber = document.getElementById('pokemonNumber').value;
    if (pokemonNumber > 151) {
        alert('Can\'t use a number bigger than 151');
    } else {
        console.log("Pokemon value: " + pokemonNumber);
        pokemonName.innerHTML = 'Loading Pokemon';
        pokemonImg.src ="https://www.playrosy.com/ourgamesw/mermaidspringlook/images/_preloader.gif";
        fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber).then(function (data) {
            return data.json(); // reading the response and looking for just the json object
        })
            .then(function (jsonPokemon) {
                pokemon = jsonPokemon; // allowing jsonPokemon to be seen globally
                document.getElementById('pokemonName').innerHTML = pokemon.name;
                document.getElementById('pokemonImg').src = pokemon.sprites.front_shiny;
            });
    }
    
}


