/*
   pokemon.js
*/

// the browser has a window object with a property
// called onload, this is a function that will be triggered 
// once the dom has finished being loaded
window.onload = function(){
    // global in here that is needed to reference any html
    console.log('pokemon.js ready');                                
    document.getElementById('pokemonBtn').addEventListener('click', getpokemon);
}

let pokemon = null;
function getpokemon() {
    console.log('getpokemon called/invoked');
    let pokemonNumber = document.getElementById('pokemonNumber').value;
    let pokemonName = document.getElementById('pokemonName');
    let pokemonImg = document.getElementById('pokemonImg');
    
    if( pokemonNumber > 151){
        alert('Can\'t use a number bigger than 151');
        
    }else{
        console.log('pokemon value: ' + pokemonNumber);
        pokemonName.innerHTML = 'loading pokemon..';
        pokemonImg.src = "https://media.giphy.com/media/GrVvXh2ZDZXBS/giphy.gif";
        
        // fetch the pokemon
        fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber)
             .then( function(response){
                   return response.json(); // reading the response and looking for just the json object 
             })
             .then( function(jsonpokemon){
                pokemon = jsonpokemon; // allowing jsonpokemon to be seen globally
                console.log('finshed loading pokemon');
                pokemonName.innerHTML = pokemon.name;
                pokemonImg.src = pokemon.sprites.front_shiny;
             });
    }
        
}





/*
    3 ways to creat a function
*/
function foo() { }
var foo = function() {}

//var window = {
 //   onload: function() {}
//}

// function arrow syntax... same but short
/* test this as the 2nd parameter in the addeventlistner
() => {

}
*/