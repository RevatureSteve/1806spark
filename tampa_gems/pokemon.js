/*
pokemon.js
*/

// The browser has window object with a property
// called onload, this is a function that will be triggered
// once the dom has finished being loaded
window.onload = function () {
    //global in here that is needed to reference any html
    console.log("pokemon.js ready");                                //function()
    document.getElementById("pokemonBtn").addEventListener("click", getPokemon) //() => {} one argument s => {}
                                           //this function is a one time use
    }

let pokemon = null;
function getPokemon() {
    console.log('getpokemon called/invoked');
    let pokemonNumber = document.getElementById('pokemonNumber').value;
    let pokemonName = document.getElementById('pokemonName');
    let pokemonID = document.getElementById('pokemonID')
    if (pokemonNumber > 151) {
        alert("Can\'t use a number bigger than 151");
    }
    else {
        console.log('Pokemon value: ' + pokemonNumber);
        pokemonName.innerHTML = "loading pokemon...";
        pokemonID.src = "http://media.giphy.com/media/UVcNpSE01XL4k/giphy.gif";
        //fetch the pokemon
        fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber)
        .then( function(response){
            return response.json(); // reading the response/data and looking for just the 
        })
        .then( function(jsonPokemon){
            pokemon = jsonPokemon; 

            console.log('finished loading pokemon');// allowing jsonPokemon to be seen globally
            pokemonName.innerHTML = pokemon.name;
            pokemonID.src = pokemon.sprites.front_shiny_female;
        });
        }
}
/* 
    3 ways to create a function 

function foo() { }
var foo = function() {} //line 16 and 19 are the same

//var window = {
//   onload: function() {}
//}

// function arrow syntax... same but short
/*
    test this as the 2nd parameter in the addEventListner function
    () 
    */