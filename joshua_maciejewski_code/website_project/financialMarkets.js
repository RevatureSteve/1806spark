// fetch('https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=' + stockSym + '&apikey=02CANEX07CURZ8RX')
// .then(function(data){
//     return data.json(); 
// })
// .then(json=>{console.log(json)})



window.onload = function() {
        console.log('let\s get stock info!');
        document.getElementById('stockButton').addEventListener('click', getStock);
    }
    
    
    let stockInfo = null;             
    function getStock() {
        console.log('getStock called/invoked');
        let stockSym = document.getElementById('stock').value;
        console.log(stockSym);

                fetch('https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=' + stockSym + '&apikey=02CANEX07CURZ8RX')
        .then(function(data){
            return data.json(); 
        })
        .then(function(json) {
            stockInfo = json;

            console.log(stockInfo);
            jsonStr = document.getElementById("stockData").innerHTML =  JSON.stringify(stockInfo["Time Series (Daily)"]);
        });


         }
        
    //     if(pokemonNumber > 151) {
    //         alert('Can\'t use a number bigger than 151');
            
    //     } else{
    //         console.log('Pokemon value: ' + pokemonNumber);
            
    //         document.getElementById("pic").src="https://media.giphy.com/media/N256GFy1u6M6Y/giphy.gif";
    //         fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber)
    //     .then(function(data){
    //         return data.json(); //reading the response/data and looking for just the json object
    //     })
    //     .then(function(jsonPokemon){
    //         pokemon = jsonPokemon;
    
    //         document.getElementById("name").innerHTML = pokemon.name;
    //         document.getElementById("pic").src= pokemon.sprites.front_shiny;
            
    //         x = document.getElementById("pic").src;
    //         document.getElementById("pic").innerHTML = 
    
    
    //         var x = document.getElementById("myImg").src;
    //     document.getElementById("demo").innerHTML = x;
    
    //     });
    //     }
    // }



// window.onload = function() {
//     console.log('let\s get stock info!');
//     document.getElementById('pokemonBtn').addEventListener('click', getPokemon);
// }


// let pokemon = null;             
// function getPokemon() {
//     console.log('getPokemon called/invoked');
//     let pokemonNumber = document.getElementById('pokemonNumber').value;
    
//     if(pokemonNumber > 151) {
//         alert('Can\'t use a number bigger than 151');
        
//     } else{
//         console.log('Pokemon value: ' + pokemonNumber);
        
//         document.getElementById("pic").src="https://media.giphy.com/media/N256GFy1u6M6Y/giphy.gif";
//         fetch('https://pokeapi.co/api/v2/pokemon/' + pokemonNumber)
//     .then(function(data){
//         return data.json(); //reading the response/data and looking for just the json object
//     })
//     .then(function(jsonPokemon){
//         pokemon = jsonPokemon;

//         document.getElementById("name").innerHTML = pokemon.name;
//         document.getElementById("pic").src= pokemon.sprites.front_shiny;
        
//         x = document.getElementById("pic").src;
//         document.getElementById("pic").innerHTML = 


//         var x = document.getElementById("myImg").src;
//     document.getElementById("demo").innerHTML = x;

//     });
//     }
// }