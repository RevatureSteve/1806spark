// Graphing variables
var apiUrlPrefix = 'https://api.iextrading.com/1.0';
var pageUrl = new URL(window.location.href);
var companyName = document.getElementById('stockName');
var graph = document.getElementById('graph');
var search = pageUrl.searchParams.get('search');
var fullUrl = apiUrlPrefix + '/stock/' + search + '/company';
var graphUrl = `${apiUrlPrefix}/stock/${search}/chart/1d`;

// Display variables
var currentPrice = document.getElementById('currentPrice');
var stockPriceChange = document.getElementById('stockPriceChange');

// Buy/Sell Stock Variable
var stockAmount = document.getElementById('stockAmount');


// Search for the requested stock
fetch(fullUrl).then(resp => {
    // console.log(resp);
    return resp.json();
}).then(myJson => {
    // console.log(myJson);
    companyName.innerHTML = myJson.companyName;
});

// Get graph information
fetch(graphUrl).then(resp => {
    return resp.json();
}).then(myJson => {
    let priceStart = 0;
    let priceEnd = 0;
    let dates = [];
    let averageData = [];
    let openData = [];
    console.log(myJson);
    for (let i = 0; i < myJson.length; i++) {
        if (!priceStart) {
            priceStart = parseFloat(myJson[i].open);
        }
        if (myJson[i].average > 0) {
            dates.push(myJson[i].label);
            averageData.push(myJson[i].average);
            openData.push(myJson[i].open);
        }
        if (myJson[i].close) {
            priceEnd = parseFloat(myJson[i].close);
        }
    }

    let open = {
        x: dates,
        y: openData,
        mode: 'lines',
        name: "Open"
    };
    let average = {
        x: dates,
        y: averageData,
        mode: 'lines',
        name: 'Average'
    };
    let data = [average];

    let layout = {
        title: companyName.innerHTML + ' Stock'
    };

    Plotly.newPlot(graph, data, layout, { staticPlot: true });

    //Set other data
    let img = document.createElement('img');
    img.src = `https://storage.googleapis.com/iex/api/logos/${search.toUpperCase()}.png`
    let stockPicDiv = document.getElementById('stockImg');
    stockPicDiv.appendChild(img);

    currentPrice.innerHTML = priceEnd;

    let priceChange = (priceEnd - priceStart).toFixed(2);
    if (priceChange >= 0) {
        stockPriceChange.innerHTML = `(+${priceChange})`;
        changeToGreen();
    }
    else {
        stockPriceChange.innerHTML = `(${priceChange})`;
        changeToRed();
    }
});

// Buy stock
document.getElementById('buyStock').addEventListener('mousedown', () =>{buySellStock('buy')});
document.getElementById('sellStock').addEventListener('mousedown', () =>{buySellStock('sell')});

function postData(url = ``, data = {}) {
    // Default options are marked with *
    return fetch(url, {
        method: "POST", // *GET, POST, PUT, DELETE, etc.
        mode: "cors", // no-cors, cors, *same-origin
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        credentials: "same-origin", // include, same-origin, *omit
        headers: {
            "Content-Type": "application/json; charset=utf-8",
            // "Content-Type": "application/x-www-form-urlencoded",
        },
        redirect: "follow", // manual, *follow, error
        referrer: "no-referrer", // no-referrer, *client
        body: JSON.stringify(data), // body data type must match "Content-Type" header
    }).then(response => {
        // response.json();
    }) // parses response to JSON
        .catch(error => {
            console.error(`Fetch Error =\n`, error);
        });
};

function buySellStock(type) {
    let amount = stockAmount.value;
    postData(`/stock`, { type: type, amount: parseFloat(amount),  stock: search, user: username  , price: parseFloat(currentPrice.innerHTML) })
        .then(data => {
            console.log(data);

            alert(` Transaction processed: ${type} ${amount} ${search} stock at $${currentPrice.innerHTML}` );

        }) // JSON from `response.json()` call
        .catch(error => {console.error(error);});
}
