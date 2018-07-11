/*
    pokemon.js
*/


// browser has a window object with a property called onload
// this function will trigger that will be triggered once the dom has 
// finished loading
window.onload = function () {
    console.log("pokemon.js ready");
    document.getElementById('pokemonBtn').addEventListener('click', getPokemon);


}

let pokemon = null;
function getPokemon() {
    let pokemonNumber = document.getElementById('pokemonNumber').value;
    let pokemonName = document.getElementById('pokemonName');
    let pokemonImg = document.getElementById('pokemonImg');
    pokemonName.innerHTML = 'loading content';
    pokemonImg.src = 'https://i.imgur.com/bJbZTqf.gif';
    if (pokemonNumber > 151) {
        alert('can\'t use a numer bigger than 151');
    } else {
        console.log('Pokemon value: ' + pokemonNumber);

        fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber)
            .then(function (data) {
                return data.json(); // reading the response and looking for just the json object
            })
            .then(function (jsonPokemon) {
                pokemon = jsonPokemon;

                pokemonName.innerHTML = pokemon.name;
                pokemonImg.src = pokemon.sprites.front_default;
            });
    }


}


/*
    2 ways to create functions

    function foo() {}
    var foo = function() {}
*/

// function arrow syntax... same but short
// () => {

//}

/*
    test it on the second parameter on the addEventListener
    () => {
        console.log('btn click');

*/
