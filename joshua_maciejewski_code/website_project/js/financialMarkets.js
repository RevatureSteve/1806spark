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
    let jsonStr            
    function getStock() {
        let stockSym = document.getElementById('stock').value;
        let date = document.getElementById('date').value;
        let stat = document.getElementById('stat').value;
        console.log(stockSym);

                fetch('https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=' + stockSym + '&apikey=02CANEX07CURZ8RX')
        .then(function(data){
            return data.json(); 
        })
        .then(function(json) {
            stockInfo = json;

            console.log(stockInfo);

            let statName = stat.slice(3);
            document.getElementById("stockData").innerHTML = "The " + statName + " for " + stockSym + 
                     " was " +   stockInfo["Time Series (Daily)"][date][stat];




           
        });

        

         }

       