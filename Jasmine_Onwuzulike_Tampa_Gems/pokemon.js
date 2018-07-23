/*
    Pokemon retrieval 
*/

window.onload = function(){
    console.log('pokemon.js loaded');
    document.getElementById('pokeBtn').addEventListener('click',getPokemon);
}
var pokemon;
function getPokemon(){
    let pokemonId = document.getElementById('pokemonNumber').value;
    console.log('pokemon: ' + pokemonId);
    fetch('https://pokeapi.co/api/v2/pokemon/25')
    .then( 
        function(response){
            return response.json()
        })
    .then(data => {
        console.log(data);
        pokemon = data;
    })
}
