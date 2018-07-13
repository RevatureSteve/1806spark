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
