window.onload = function() {
    console.log('pokemon.js ready');
    document.getElementById('pokemonBtn').addEventListener('click', getPokemon);
}


let pokemon = null;             
function getPokemon() {
    console.log('getPokemon called/invoked');
    let pokemonNumber = document.getElementById('pokemonNumber').value;
    
    if(pokemonNumber > 151) {
        alert('Can\'t use a number bigger than 151');
        
    } else{
        console.log('Pokemon value: ' + pokemonNumber);
        
        document.getElementById("pic").src="https://media.giphy.com/media/N256GFy1u6M6Y/giphy.gif";
        fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber)
    .then(function(data){
        return data.json(); //reading the response/data and looking for just the json object
    })
    .then(function(jsonPokemon){
        pokemon = jsonPokemon;

        console.log(pokemon);
        
        document.getElementById("name").innerHTML = pokemon.name;
        document.getElementById("pic").src= pokemon.sprites.front_shiny;
        
        // x = document.getElementById("pic").src;
        // document.getElementById("pic").innerHTML = 


    //     var x = document.getElementById("myImg").src;
    // document.getElementById("demo").innerHTML = x;

    });
    }
}

