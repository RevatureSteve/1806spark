/* 
pokemon.js */



// the browser has a window object with the property; "onload" this is a 
// function that will be triggered once the DOM has finished being loaded
window.onload = function(){
    // use window.onload for global functions
    console.log('pokemon.js ready');                            
    document.getElementById('pokemonBtn').addEventListener('click', getPokemon);
}

let pokemon = null;
function getPokemon(){
    console.log('get pokemon called/invoked');
    let pokemonNumber = document.getElementById("pokemonNumber").value;
    let pokemonName = document.getElementById('name');
    let pokemonImg = document.getElementById('picture');
    
    console.log('Pokemon value ' + pokemonNumber);
    if(pokemonNumber > 151){
        alert("can\'t use a number greater than 151");
        
    }else{
        pokemonName.innerHTML = "Getting Pokemon!";
        pokemonImg.src = "https://i.gifer.com/AGNB.gif";
        console.log('get pokemon value' + pokemonNumber);
       
        // fetch the pokemon
        fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber)  
        .then( function(data) {
            return data.json();  //reading the response and looking for the json
        })
        .then( function(jsonPokemon){
            pokemon = jsonPokemon;   // allowing jsonPokemon to be seen globally
        console.log('finished loading pokemon');
        pokemonName.innerHTML = pokemon.name;
        pokemonImg.src = pokemon.sprites.front_default;
        }); 
    }

}










