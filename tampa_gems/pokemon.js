<<<<<<< HEAD
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

=======
/*
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
    
>>>>>>> 150ae089dc796e1fd85d51541da637eb19e228a4
}










<<<<<<< HEAD
=======




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



>>>>>>> 150ae089dc796e1fd85d51541da637eb19e228a4
