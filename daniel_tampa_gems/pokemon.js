/*
    pokemon.js
*/

//the browser has a window object with a property 
//  called onload, this is a function that will be triggered
//  once the dom has finished being loaded
window.onload = function () {
    console.log('Pokemon.js is ready');
    document.getElementById('pokemonBtn').addEventListener('click', getPokemon);
}



//globaX = 'globalX';
function getPokemon() {
    console.log('pokemon called');
    let pokemonNumber = document.getElementById('pokemonNumber').value;


    if (pokemonNumber > 151) {
        alert('Cannot use a number larger than 151');

    } else {
        console.log('pokemon value: ' + pokemonNumber);
        document.getElementById('pokemonImg').src = 'https://i.gifer.com/7Pzx.gif';
        //let localX = 'localX';
        //console.log('localX: ' + localX );
        fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber)
            .then(function (data) {
                return data.json();
            })
            .then(function (pokemon) {

                document.getElementById('pokemonName').innerHTML = pokemon.name;
                document.getElementById('pokemonImg').src = pokemon.sprites.front_shiny;

            });
    }
}


/*
    3 ways to create a function
*/
function foo() { }
var foo = function () { }

// var window = {
//    onload: function(){ }
//}

//function arrow syntax...same but short

/*
    () =>{
        console.log('btn click');
    })
*/