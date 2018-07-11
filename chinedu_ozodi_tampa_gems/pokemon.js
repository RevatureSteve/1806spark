
//ONLOAD WILL BE TRIGGERED ONCE DOM HAS FINISHED BEING LOADED
window.onload = function () {
    console.log("pokemon.js ready");
    document.getElementById("pokemonBtn").addEventListener("click", getPokemon);
    // setInterval(()=>{
    //     let pokeId = Math.floor(Math.random() * 151 + 1);
    //     fetch(`https://pokeapi.co/api/v2/pokemon/${pokeId}/`).then(
    //         (data) => {return data.json()}).then(pokeDataLoaded);
    // },10000);
}

function getPokemon() {
    let pokeId = document.getElementById("pokemonId");
    console.log(`Pokemon ID is: ${pokeId.value}`);
    // let pokeData = data.json();
    let div = document.createElement("div");
    let h1 = document.createElement("h1");
    let pokeImage = document.createElement("img");

    h1.innerHTML = "Loading Pokemon";
    pokeImage.setAttribute("src", 'https://cdn.dribbble.com/users/621155/screenshots/2835314/simple_pokeball.gif');

    pokeId.parentElement.insertBefore(div, pokeId.nextElementSibling.nextElementSibling);
    div.appendChild(h1);
    div.appendChild(pokeImage);

    if (pokeId.value > 151 || pokeId.value < 0) {
        alert(`Can't use: ${pokeId}. Number needs to be no bigger than 151`);
    }
    else {
        // Fetch pokemon name, and sprite
        fetch(`https://pokeapi.co/api/v2/pokemon/${pokeId.value}/`).then(
            (data) => { return data.json() }).then((pokeData) => {
                pokeImage.setAttribute("src", pokeData.sprites.front_shiny);
                h1.innerHTML = pokeData.name;
            });
    }


}

function pokeDataLoaded(pokeData) {

}




















// Funciton arrow syntax
// () => {}
// used for callback functions

