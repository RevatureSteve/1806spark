// pokemon js

// the browser has a window object with a property called onload,
//this is a function that will be triggered
//once  the dom has finished being loaded
window.onload = function () {
    console.log('pokemon.js is ready');
    document.getElementById("pokemonbtn").addEventListener("click", getPokemon);
}
let pokemon = null;
function getPokemon() {
    console.log("getPokemon has been invoked/called");
    let pokinumber = document.getElementById('number').value;
    let pokemonName = document.getElementById('pokiName');
    let pokemonImg = document.getElementById('pokiImage');
    if (pokinumber > 151) {
        alert('Can\'t use a number bigger than 151');
        console.log('number entered is invalid');
        var localX = 'hello';
    }
    else {
        //fetch the pokemon
        console.log('Pokemon value: ' + pokinumber);
        pokemonImg.src = 'https://em.wattpad.com/92b7abea59a7c0931b804dc7b86012f098efe006/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f38436b42425f734663614c7a46773d3d2d3637332e31353031653165633232646230373562313231303038363235382e676966?s=fit&w=720&h=720';
        pokemonName.innerHTML = "Pokemon on the way";
        fetch('https://pokeapi.co/api/v2/pokemon/'
            + pokinumber).then(function (data) {
                return data.json(); //reading the response/data and looking for just the json object
            })
            .then(function (jsonPokemon) {
                pokemon = jsonPokemon;
                pokemonName.innerHTML = pokemon.name;
                pokemonImg.src = pokemon.sprites.front_default;
            });
    }
}












// 3 ways to create a function
function foo() { }
var foo = function () { }

// var window = {
//     onload: function(){}
// }

// fuction arrow syntax... same but short
// () => { }
/*  
works as a one time fuction
    f => {
        console.log('btn click');
    }
*/