/*
    questions.js
*/
// No window.onload it has already been used by app.js

let port = 2001;
window.onload = function() {
    // get navbar html fragment
    setBudget();
    
}

var url = 'http://localhost:2001/viewBudget';
var budget = null;
callBudget();

function callBudget(){
    fetch(url)
    .then((resp) => {
        return resp.json();
    })
    .then((data) => {
        console.log(data);
        budget = data;
        setBudget(budget);
    })
}

function setBudget(b){
    console.log('setting budget to page');
    console.log(b);
    var budgetSection = document.getElementById('budget');

    for(let x = 0; x< b.length; x++){
        let bDiv = document.createElement('div');
        bDiv.innerHTML = b[x].expense + "\xa0\xa0\xa0\xa0\xa0$" + b[x].amount;
        budgetSection.appendChild(bDiv);

        // {/* <script type="text/javascript"> */}
// Load google charts


// // Draw the chart and set the chart values
// function drawChart() {
//   var pie = google.visualization.arrayToDataTable([
//   ['expense', 'amount'],
//   ['b[x].expense', b[x].amount],
// //   ['Eat', 2],
// //   ['TV', 4],
// //   ['Gym', 2],
// //   ['Sleep', 8]
// ]);

//   // Optional; add a title and set the width and height of the chart
//   var options = {'title':'My Average Day', 'width':550, 'height':400};

//   // Display the chart inside the <div> element with id="piechart"
//   var chart = new google.visualization.PieChart(document.getElementById('piechart'));
//   chart.draw(pie, options);
// }
// </script>



    }
}


google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

var columns = Budget1.keys(results[0]);
var data = results.map(function (result) {
  var tableRow = [];
  columns.forEach(function (col) {
    tableRow.push(result[col]);
  });
  return tableRow;
});
// data will contain the table rows to be rendered by google chart.

var dataTable = new google.visualization.DataTable(document.getElementById('piechart'));
columns.forEach(function (columnName) {
  dataTable.addColumn(columnName);
});

dataTable.addRows(data);
chart.draw(dataTable, options);


