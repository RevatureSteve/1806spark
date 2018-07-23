/**
 Pokemon
 */
//the browser has a window object with a propery call onload.
//this fucnction thst will be triggered 
//once the dom is finished loading


window.onload = function () {
    //global in here that need to be refernce by html
    console.log('pokemon.js ready');
    document.getElementById('pokemonBtn').addEventListener('click', getPokemon);
} 

let pokemon = null;
var globalx = 'globalx'
function getPokemon(){
    console.log('getpokemon called/invoked');
    let pokemonNumber = document.getElementById('pokemonNumber').value;  
    let pokemonName = document.getElementById('thatPokemon'); /// these are variable for the image or gif image while the information are loacted they will be activated when the variable pass on at *******)()
    let pokemonImg = document.getElementById('thatPicture');
    

    //console.log("pokemon value: " + pokemonNumber)
    if (pokemonNumber > 150) {
        alert('can\'t use a number bigger that 151 ' + pokemonNumber);
      
    } else{
        console.log("pokemon value: " + pokemonNumber);
        pokemonName.innerHTML = 'loading pokemon..'; //*******)()
        pokemonImg.src ="https://media2.giphy.com/media/xT9DPldJHzZKtOnEn6/200w.webp"; //*******)()//these variable store a loading while image and name are been loading
        

        //var localx = "localx";
        //fetch('https://pokeapi.co/api/v2/pokemon/25'), then(function(data) { console.log('request promise') }
        fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber)
         .then(function(data) {
             return data.json(); //reading the response/data and  looking just for the json data
         })
         .then(function(jsonPokemon) {
         pokemon = jsonPokemon;
       
         document.getElementById('thatPokemon').innerHTML = pokemon.name;
         document.getElementById('thatPicture').src = pokemon.sprites.front_shiny
        });
   
    


    }
    //console.log('localx: ' + localx);
}




    /*
    2 ways to create a function 
     */

    //  function foo(){
    //      var foo = function() {}

    //  }

    //  var window = {
    //     onload: function(){}
    //  }

    //function arrow syntax... same but short
    //() => { }

// /*
//     window.onload = function () {
//         //global in here that need to be refernce by html
//         console.log("pokemon.js ready")
//         document.getElementById('pokemonBtn').addEventListener('click', () => {
//             console.log('Btn click')
//         }); // this is a function () => {
//            // console.log('Btn click')
//         })
//     }
//
