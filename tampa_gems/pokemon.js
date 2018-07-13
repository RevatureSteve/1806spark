
//The browser has a window object with a property called onload
//This is a function that will be triggered once the dom has finished loaded
// put Event listeners inside the onload Function
window.onload = function () {

    console.log("Pokemon.js Ready")
    document.getElementById("pokemonBtn").addEventListener("click", getPokemon)
    
    pokemon = null;
    pokeName = document.getElementById("pokeName");
    pokeImg = document.getElementById("imgName");
}
let pokemon = null;
var pokeName = null;
let pokeImg = null;
function getPokemon() {
    pokeImg.src = "https://i.gifer.com/8RDk.gif"
    console.log("getPokemon called/invoked")
    var pokemonNumber = document.getElementById("pokemonNum").value;
    if (pokemonNumber > 151) {
        alert("Can't use number greater than 151")
    }
    else {
        console.log("pokemon value " + pokemonNumber);
        fetch("https://pokeapi.co/api/v2/pokemon/" + pokemonNumber).then(function(data) {
            return data.json(); // reading response and looking for just the json
        }).then(function(jsonPokemon) {
            pokemon = jsonPokemon;
            pokeName.innerHTML = pokemon.name;
            pokeImg.src = pokemon.sprites.front_default;
        });
    }
}








/* 
        2 ways to create a function
*/

function foo() { }
var foo = function () { }

/*
var window = {


}

Function Arrow Syntax

Test this as the second parameter in the addEventListener Function
() => {

}

*/
