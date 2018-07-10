// Pokemon
let pokemon = null;
window.onload = function () {
    console.log("Ready to work");
    document.getElementById("pokemon-btn").addEventListener("click", getPokemon )
}

function getPokemon() {
    console.log("Get Pokemon function invoked.");
    var pokemonNumber = document.getElementById("pokemon-number").value;
    if (pokemonNumber > 151) {
        alert("Can't use a number greater than 151!");
    }
    else {
        console.log("The pokemon number is " + pokemonNumber);
        
        
//Fetch the pokemon API
fetch("https://pokeapi.co/api/v2/pokemon/" + pokemonNumber)

    .then(function(data) {
        return data.json();
    })
    .then(function(jsonPokemon) {
        pokemon = jsonPokemon;
        let name = pokemon.name;
        let image = pokemon.sprites["back_default"];
        console.log(name);
        console.log(image);
        document.getElementById("name").innerHTML = name;
        document.getElementById("image").src = image;
    });
    }
}



