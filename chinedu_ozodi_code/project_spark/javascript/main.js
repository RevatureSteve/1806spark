var user = getCookie('username');
var apiUrlPrefix = 'https://api.iextrading.com/1.0';
var stockDataDiv = document.getElementById('stockData');
var graph = document.getElementById('graph');
var stockDataRows = {}; //Stores stock row data for the table
var stockList = []; // List of stock owned by user
var stockDataFetched = 0; // Number of stocked fetched from api
var stockData = {}; // Stores stock data

// Display variables
var currentPrice = document.getElementById('currentAmount');
var stockPriceChange = document.getElementById('priceChange');


// Pull user data
if (user) {
    fetch('/stock/get', {
        method: "POST", // *GET, POST, PUT, DELETE, etc.
        headers: {
            "Content-Type": "application/json; charset=utf-8",
            "Accept": "application/json"
        },
        body: JSON.stringify({ username: user }), // body data type must match "Content-Type" header
    }).then(response => {
        return response.json();
    }).then(myJson => {
        console.log(myJson);
        // Fetch stock data
        for (let i = 0; i < myJson.length; i++) {
            let stockRow = stockDataRows[myJson[i].stock];
            if (!stockRow) {
                stockDataRows[myJson[i].stock] = document.createElement('div');
                stockRow = stockDataRows[myJson[i].stock];
                stockDataDiv.appendChild(stockRow);
                stockRow.classList.add('row')
                stockList.push(myJson[i].stock);

                stockDataRows[myJson[i].stock + " name"] = document.createElement('div');
                let stockName = stockDataRows[myJson[i].stock + " name"];
                stockRow.appendChild(stockName);
                stockName.classList.add('col-sm');
                stockName.innerHTML = myJson[i].stock;

                stockDataRows[myJson[i].stock + " price"] = document.createElement('div');
                let stockPrice = stockDataRows[myJson[i].stock + " price"];
                stockRow.appendChild(stockPrice);
                stockPrice.classList.add('col-sm');
                stockPrice.innerHTML = myJson[i].price;

                stockDataRows[myJson[i].stock + " amount"] = document.createElement('div');
                let stockAmount = stockDataRows[myJson[i].stock + " amount"];
                stockRow.appendChild(stockAmount);
                stockAmount.classList.add('col-sm');
                stockAmount.innerHTML = myJson[i].amount;

                stockDataRows[myJson[i].stock + " total"] = document.createElement('div');
                let stockTotal = stockDataRows[myJson[i].stock + " total"];
                stockRow.appendChild(stockTotal);
                stockTotal.classList.add('col-sm');
                stockTotal.innerHTML = (parseFloat(myJson[i].amount) * parseFloat(myJson[i].price)).toFixed(2);
            }
            else {
                let stockPrice = stockDataRows[myJson[i].stock + " price"];
                let stockAmount = stockDataRows[myJson[i].stock + " amount"];
                let stockTotal = stockDataRows[myJson[i].stock + " total"];
                if (myJson[i].type == 'buy') {
                    let totalPrice = parseFloat(stockPrice.innerHTML) * parseFloat(stockAmount.innerHTML);
                    totalPrice += parseFloat(myJson[i].price) * parseFloat(myJson[i].amount);
                    stockTotal.innerHTML = totalPrice.toFixed(2);

                    totalPrice /= parseFloat(myJson[i].amount) + parseFloat(stockAmount.innerHTML);
                    stockPrice.innerHTML = totalPrice.toFixed(2);
                    stockAmount.innerHTML = parseFloat(myJson[i].amount) + parseFloat(stockAmount.innerHTML);
                }
                else if (myJson[i].type == 'sell') {
                    stockAmount.innerHTML = (parseFloat(stockAmount.innerHTML) - parseFloat(myJson[i].amount)).toFixed(2);
                    stockTotal.innerHTML = (parseFloat(stockAmount.innerHTML) * parseFloat(stockPrice.innerHTML)).toFixed(2);
                }
                else {
                    console.error('Unknown type: ' + myJson[i].type);
                }
            }
        }
    }).then(getStockData);
}

function getStockData() {
    for (let i = 0; i < stockList.length; i++) {
        var graphUrl = `${apiUrlPrefix}/stock/${stockList[i]}/chart/1d`;
        // Get graph information
        fetch(graphUrl).then(resp => {
            return resp.json();
        }).then(myJson => {
            stockDataFetched++;
            let priceStart = 0;
            let priceEnd = 0;
            let dates = [];
            let averageData = [];
            let openData = [];
            console.log(myJson);
            for (let i = 0; i < myJson.length; i++) {
                if (i == 0) {
                    priceStart = myJson[i].open;
                }
                if (myJson[i].average > 0) {
                    dates.push(myJson[i].label);
                    averageData.push(myJson[i].average);
                    openData.push(myJson[i].open);
                }
                if (i == myJson.length - 1) {
                    priceEnd = myJson[i].close;
                }
            }

            stockData[stockList[i] + " dates"] = dates;
            stockData[stockList[i] + " average"] = averageData;

            if (stockDataFetched == stockList.length) {
                graphStockData();
            }

        });
    }
}

function graphStockData() {
    var data = [];
    let layout = {
        title: 'All Stocks'
    };
    let dates = stockData[stockList[0] + " dates"].slice();
    let totalAverage = stockData[stockList[0] + " average"].slice();

    // reset total average to zero;
    for (let k = dates.length - 1; k >= 0; k--) {
        totalAverage[k] = 0;
    }

    for (let i = 0; i < stockList.length; i++) {
        let rowDataIsFinished = false;
        for (let k = dates.length - 1; k >= 0; k--) {
            if (stockData[stockList[i] + " dates"].includes(dates[k])) {
                let price = stockData[stockList[i] + " average"][stockData[stockList[i] + " dates"].indexOf(dates[k])];
                let amount = parseFloat(stockDataRows[stockList[i] + " amount"].innerHTML);
                totalAverage[k] += parseFloat(price) * amount;

                if (!rowDataIsFinished) {
                    finishRowData(stockList[i], parseFloat(price).toFixed(2), amount);
                    rowDataIsFinished = true;
                }
            }
            else {
                totalAverage.splice(k, 1);
                dates.splice(k, 1);
            }
        }
    }
    let syncedAverageData = {
        x: dates,
        y: totalAverage,
        mode: 'lines',
        name: 'All Stocks'
    };
    data.push(syncedAverageData);
    Plotly.newPlot(graph, data, layout, { staticPlot: true });

    //Set other data
    let startPrice = totalAverage[0];
    let endPrice = totalAverage[totalAverage.length - 1];
    let priceChange = (endPrice - startPrice).toFixed(2);

    currentPrice.innerHTML = `$${endPrice.toFixed(2)}`;
    if (priceChange >= 0) {
        stockPriceChange.innerHTML = `(+${priceChange})`;
        changeToGreen();
    }
    else {
        stockPriceChange.innerHTML = `(${priceChange})`;
        changeToRed();
    }
}

function finishRowData(stock, price, amount) {

    let stockRow = stockDataRows[stock];


    let stockTotal = stockDataRows[stock + " total"];

    stockDataRows[stock + " today"] = document.createElement('div');
    let stockToday = stockDataRows[stock + " today"];
    stockRow.appendChild(stockToday);
    stockToday.classList.add('col-sm');
    stockToday.innerHTML = (price * amount).toFixed(2);

    stockDataRows[stock + " change"] = document.createElement('div');
    let stockChange = stockDataRows[stock + " change"];
    stockRow.appendChild(stockChange);
    stockChange.classList.add('col-sm');
    stockChange.innerHTML = (parseFloat(stockToday.innerHTML) - parseFloat(stockTotal.innerHTML)).toFixed(2);
}