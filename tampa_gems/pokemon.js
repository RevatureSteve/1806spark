<<<<<<< HEAD
<<<<<<< HEAD
/* pokemon.js
*/

//browser has window objects with a property
// called on load, its a function that will be triggered
// once the dom has finished being loaded.





window.onload = function(){
console.log("pokemon.js is ready")                              //function s()
document.getElementById("pokemonBtn").addEventListener('click',getPokemon)
document.getElementById("mealBtn").addEventListener('click',getMeal)
}

var pPic = document.getElementById("pokePic");
var pName = document.getElementById("pokeName");

let pokemon = null;
function getPokemon() {
    console.log('Get Pokemon');
    let pokemonNumber = document.getElementById('pokemonNumber').value;
    let pokeName = document.getElementById('pokeName');
    let pokePic = document.getElementById('pokePic');


    if( pokemonNumber > 151){
        alert("Can't use a number bigger than 151.")
        
    }
    else{
        console.log('Pokemon Value is ' + pokemonNumber);
        pokeName.innerHTML = "loading"
        pokePic.src = "https://loading.io/spinners/pies/lg.pie-chart-loading-gif.gif"

        //fetching item
        fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber)
             .then ( function (data){
                 return data.json(); // reading response and looking for the json object
        })
        .then( function(jsonPokemon){
            pokemon = jsonPokemon;
            pokeName.innerHTML = pokemon.name;
            pokePic.src = pokemon.sprites.front_shiny
        });
    }
}

//searching for food with this fetch

// to do: add a query string ability
var jsonObject =null;
fetch('https://api.yummly.com/v1/api/recipes?_app_id=d2b08497&_app_key=cb8c1dfb48e25229ddf5e8f768297ada&q=').then(function(data){
    return data.json()
})
.then(json=>{console.log(json); jsonObject = json;})
// add something to the jsonObject.<something here>


var mPic = document.getElementById("mealPic");
var mName = document.getElementById("mealName");

let meal = null;
function getMeal() {
    console.log('Get Pokemon');
    let mealNumber = document.getElementById('mealNumber').value;
    let mealName = document.getElementById('mealName');
    let mealPic = document.getElementById('mealPic');


    if( mealNumber > 151){
        alert("Can't use a number bigger than 151.")
        
    }
    else{
        console.log('Pokemon Value is ' + mealNumber);
        mealName.innerHTML = "loading"
        mealPic.src = "https://loading.io/spinners/pies/lg.pie-chart-loading-gif.gif"

        //fetching item
        fetch('https://api.yummly.com/v1/api/recipes?_app_id=d2b08497&_app_key=cb8c1dfb48e25229ddf5e8f768297ada&q=' + mealNumber)
             .then ( function (data){
                 return data.json(); // reading response and looking for the json object
        })
        .then( function(jsonMeal){
            meal = jsonMeal;
            mealName.innerHTML = meal.matches[1].recipeName;
            mealPic.src = meal.matches[2].imageUrlsBySize[90];
        });
    }
}


/*

2 ways to create a function

*/

function foo(){};

var foo = function(){};

// function arrow syntax...same but short.
// typically used for one-and-done functions that dont need to be named.
=======
=======
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
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



<<<<<<< HEAD
>>>>>>> 150ae089dc796e1fd85d51541da637eb19e228a4
=======
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
