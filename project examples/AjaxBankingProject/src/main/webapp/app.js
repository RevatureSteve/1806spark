/**
 *  app.js
 */

window.onload = function(){
	//addScript('features/dashboard/dashboard.js');
	loadNavbar();
	loadDashboardView();
	
}


function loadNavbar(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('navbar').innerHTML = xhr.responseText;
			document.getElementById('tx').addEventListener('click', loadTxView, false);
			document.getElementById('dashboard').addEventListener('click', loadDashboardView, false);
		}
	}
	xhr.open("GET", "ajaxNavbar", true);
	xhr.send();
}


//----------------------------------Views
function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('view').innerHTML = xhr.responseText;
			retrieveBankUserAccountInfo();
		}
	}
	xhr.open("GET", "ajaxDashboard", true);
	xhr.send();
}

function loadTxView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('txBtn').addEventListener("click",processTx, false)
		}
	}
	xhr.open("GET", "ajaxDoTransaction", true);
	xhr.send();
}


//Example of dom manipulation even with the head tag!
function addScript(src) {
    var s = document.createElement('script');
    s.type = 'text/javascript';
    s.src = src;
    document.getElementsByTagName('head')[0].appendChild(s);
    return s;  // to remove it later
}





function retrieveBankUserAccountInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log(xhr.responseText);
			var userDTO = JSON.parse(xhr.responseText);
			document.getElementById('bankuser').innerHTML = userDTO.username;
			document.getElementById('baNumber').innerHTML = userDTO.baId;
			document.getElementById('balance').innerHTML = userDTO.baBalance;
		}
	}
	xhr.open("GET", "ajaxBankInfo", true);
	xhr.send();
}


function processTx(){
	var amount = document.getElementById('amount').value;
	var txType = document.querySelector('input[name = "txType"]:checked').value;
	console.log('amount ' + amount + ' txType: ' + txType);
	
	var tx = {
			txAmount: amount,
			txType: txType  
	}
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log(xhr.responseText);
			
		}
	}
	xhr.open("POST", "ajaxProcessTx", true);
	console.log(tx);
//	xhr.setRequestHeader("key",tx);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
}
