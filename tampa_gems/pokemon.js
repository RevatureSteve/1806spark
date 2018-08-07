/*
<<<<<<< HEAD
    pokemon.js
*/

// The browser has window object with a property
//  called onload, this is a function that will be triggered
//  once the dom has finished being loaded
window.onload = function(){
    // global in here that is needed to reference any html
    console.log('pokemon.js ready');                               
    document.getElementById('pokemonBtn').addEventListener('click', getPokemon);
}
let pokemon = null;
function getPokemon() {
    console.log('getPokemon called/invoked');
    let pokemonNumber = document.getElementById('pokemonNumber').value;
    let pokemonName = document.getElementById('pokemonName');
    let pokemonImg = document.getElementById('pokemonImg');

    if( pokemonNumber > 151){
        alert('Can\'t use a number bigger than 151');
    }else{
        console.log('Pokemon value: ' + pokemonNumber);
        pokemonName.innerHTML = 'loading pokemon..';
        pokemonImg.src ="https://zippy.gfycat.com/SkinnySeveralAsianlion.gif";
        // fetch the pokemon
        fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber)
            .then( function(response){ 
                return response.json(); // reading the response/data and looking for just the json object
            })
            .then( function(jsonPokemon){
                pokemon = jsonPokemon; // allowing jsonPokemon to be seen globally
                console.log('finished loading pokemon');
                pokemonName.innerHTML = pokemon.name;
                pokemonImg.src = pokemon.sprites.front_shiny;
            });
            
    }
    
}














/*
    3 ways to create a function
*/
function foo() { }
var foo = function() {}

// var window = {
//     onload: function() {}
// }

// function arrow syntax...same but short
/*  
    test this as the 2nd parameter in the addEventListener function
    () => {
        console.log('btn click');
    }
*/



=======
pokemon.js
*/


// The browser has window object with a property
// called onload, this is a function that wil be triggered 
// once the dom has finished being loaded
window.onload = function () {
    // global in here that is needed to reference any html
    console.log('pokemon.js ready');                                // function()
    document.getElementById("pokemonBtn").addEventListener("click", getPokemon)
}

/*
    2 ways to create a function
*/
let pokemon = null;
function getPokemon() {
    console.log('get pokemon called/invoked');
    let pokemonNumber = document.getElementById('pokemonNumber').value;
    let pokemonName = document.getElementById("pokemonName");
    let pokemonPic = document.getElementById("pokemonPic");
    
    if (pokemonNumber > 151){
        alert('can\'t use a number bigger than 151')
    } else {
        console.log('Pokemon value: ' + pokemonNumber);
        pokemonPic.src = 'https://media1.tenor.com/images/3a0c9909b542717ce9f651d07c4d4592/tenor.gif?itemid=8985245';
        pokemonName.innerHTML = "loading pokemon...";

        // fetch the pokemon
        fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber)
            .then(function(data){
                return data.json(); // reading the response and looking just for the json object
            })
            .then(function(jsonpokemon){
                pokemon = jsonpokemon;
                pokemonName.innerHTML = pokemon.name;
                pokemonPic.src = pokemon.sprites.front_shiny;
            })
    }
}


// var foo = function() {}

// var window = {
//     onload: function(){}
// }

// function arrow syntax...same but short
// () => {

// }
>>>>>>> 389bd661b1467c9b599b7c6083198da9b886917f
