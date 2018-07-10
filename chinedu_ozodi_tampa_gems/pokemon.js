
//ONLOAD WILL BE TRIGGERED ONCE DOM HAS FINISHED BEING LOADED
window.onload = function () {
    console.log("pokemon.js ready");
    document.getElementById("pokemonBtn").addEventListener("click", getPokemon)
}

function getPokemon(data){
    console.log('/$');
    let pokeId = document.getElementById("pokemonId").value;
    console.log(`Pokemon ID is: ${pokeId}`);

    if (pokeId > 151 || pokeId < 0){
        alert(`Can't use: ${pokeId}` );
    }
}




















// Funciton arrow syntax
// () => {}
// used for callback functions

