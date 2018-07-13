/*
pokemon.js
*/


//The browser has window object with a property 
//called onload, this is a function that will trigger 
//once the dom has finished being loaded

window.onload = function () {
    console.log("pokemon.js ready");
    document.getElementById("pokemonBtn").addEventListener("click", getPokemon);
    console.log("btn click");
}

let pokemon = null;

function getPokemon() {
    console.log("getPokemon called/invoked")
    let pokemonNumber = document.getElementById("pokemonNumber").value
    if (pokemonNumber > 151) {
        alert("Can't use a number bigger than 151")
    }
    else {
        console.log("Pokemon value: " + pokemonNumber);
        document.getElementById("pokemonImg").src = "http://www.lumene.com/sites/all/themes/lumene2016/images/loading.gif"
        fetch("https://pokeapi.co/api/v2/pokemon/" + pokemonNumber)
        .then(function (data) {
            return data.json(); // reading the response and looking for just the json object
        })
            .then(function(jsonPokemon){
            pokemon = jsonPokemon;// allowing jsonPokemon to be seen globally
            document.getElementById("pokemonName").innerHTML = pokemon.name
            document.getElementById("pokemonImg").src = pokemon.sprites.front_shiny;
        });
    }
 
}

/*
2 ways to create a function
*/

function foo() { }
var foo = function () { }
// var window = {
//     onload: function(){}
// }


// function arrow syntax...same but short
// ()=>{
console.log("btnClick")
// }