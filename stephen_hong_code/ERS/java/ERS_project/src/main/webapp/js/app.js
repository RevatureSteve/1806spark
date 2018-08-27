window.onload = function() {
	loadLogin();
	$('#toLogin').on('click', loadLogin);
	$('#toRegister').on('click', loadRegister);
	$('#toLogout').on('click', logout);
}

function loadLogin() {
	console.log('in loadLogin()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadLoginInfo();
			$('#toRegister').show();
			$('#toLogin').show();
			$('#toReimbursements').show();
			
			$('#toHome').hide();
			$('#toProfile').hide();
			$('#toLogout').hide();
		}
	}
	
	xhr.open('GET', 'login.view', true);
	xhr.send();
}

function loadLoginInfo() {
	console.log('in loadLoginInfo()');
	
	$('#login-message').hide();
	$('#login').on('click', login);
}

function login() {
	console.log('in login()');
	
	let username = $('#login-username').val();
	let password = $('#login-password').val();
	
	let toSend = [username, password];
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			
			if(user == null) {
				$('#login-message').html('Invalid credentials!');
			} else {
				alert('Login successful!');
				loadLanding();
				console.log(`User id: ${user.id} login successful!`)
			}
		}
	}
	
	xhr.open('POST', 'login', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function loadRegister() {
	console.log('in loadRegister()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadRegisterInfo();
		}
	}
	
	xhr.open('GET', 'register.view', true);
	xhr.send();
}

function loadRegisterInfo() {
	console.log('in loadRegisterInfo()');
	
	$('#reg-message').hide();
	$('#reg-username').blur(validateUsername);
	$('#email').blur(validateEmail);
	$('#register').attr('disabled', true);
	$('#register').on('click', register);
}

function register() {
	console.log('in register()');
	
	let fn = $('#fn').val();
	let ln = $('#ln').val();
	let email = $('#email').val();
	let username = $('#reg-username').val();
	let password = $('#reg-password').val();
	
	let user = {
		id: 0,
		firstName: fn,
		lastName: ln,
		email: email,
		username: username,
		pwHash: password,
		pwSalt: '',
		role: 1
	}
	
	let userJson = JSON.stringify(user);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#message').hide();
			alert('Enrollment successful! Please login using your credentials.');
			loadLogin();
		}
	}
	
	xhr.open('POST', 'register', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(userJson);
}

function validateUsername() {
	console.log('in validateUsername()');
	
	$('#register').attr('disabled', false);
	$('#reg-message').hide();
	
	let username = $('#reg-username').val();
	let toSend = username;
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			if(user == null) {
				$('#reg-message').show();
				$('#reg-message').html('Username is already in use! Please try another.');
				$('#register').attr('disabled', true)
			}
		}
	}
	
	xhr.open('POST', username.validate, true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
	
}

function validateEmail() {
	console.log('in validateEmail()');
	
	$('#register').attr('disabled', false);
	$('#reg-message').hide();
	
	let email = $('#email').val();
	let toSend = email;
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			if(user == null) {
				$('#reg-message').show();
				$('#reg-message').html('Email address is already in use! Please try another.');
				$('#register').attr('disabled', true)
			}
		}
	}
	
	xhr.open('POST', email.validate, true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function loadHome() {
	console.log('in loadHome()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadHomeInfo();
			
			$('#toHome').show();
			$('#toProfile').show();
			$('#toLogout').show();
			$('#toLogin').hide();
			$('#toRegister').hide();
		}
	}
	
	xhr.open('GET', 'home.view', true);
	xhr.send();
}

function loadHomeInfo() {
	console.log('in loadHomeInfo()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let homeInfo = JSON.parse(xhr.responseText);
			let user = homeInfo.user;
			let accounts = homeInfo.userAccounts;
			
			$('#user_id').html(user.id);
			$('#user_fn').html(user.firstName);
			$('#user_ln').html(user.lastName);
			$('#user_email').html(user.emailAddress);
			$('#user_username').html(user.username);
			$('#user_password').html(user.password);
			
			if(accounts.length > 0) {
				accounts.forEach((account) => {
					let id = account.acctId;
					let type = account.acctType[0].toUpperCase() + account.acctType.substring(1);
					let balance = parseFloat(Math.round(account.balance * 100) / 100).toFixed(2);
					
					let markup = `<tr>
									<td>${id}</td>
									<td>${type}</td>
									<td>${balance}</td>
								  </tr>`;
					
					$('table tbody').append(markup);
				})
			} else {
				$('#acct-info').html('No accounts on record');
			}
		}
	}
	
	xhr.open('GET', 'home.loadinfo', true);
	xhr.send();
}

function logout() {
	console.log('in logout()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log('Session invalidated!');
			loadLogin();
		}
	}
	
	xhr.open('GET', 'logout', true);
	xhr.send();
}

function loadReimbursements(){
	console.log('In loadReimbursements()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			loadReimbursementInfo();
		}
	};
	
	xhr.open('GET', 'reimbursements.view', true);
	xhr.send();
}

function loadReimbursementInfo(){
	console.log('In loadReimbursementInfo()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
		}
	};
}

function loadCreateReimbursement(){
	console.log('In loadCreateReimbursement()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			loadCreateReimbursementInfo();
		}
	};
	
	xhr.open('GET', 'createReimbursement.view');
	xhr.send();
}

function loadCreateReimbursementInfo(){
	console.log('In loadCreateReimbursementInfo()');
	
	$('#reimbursement-message').hide();
	$('#description').blur(validateReimbursementInfo);
	$('#amount').blur(validateReimbursementInfo);
	$('#submit').on('click', createReimbursement);
	$('#submit').attr('disabled', true)
}

function validateReimbursementInfo(){
	console.log('In validateReimbursementInfo()');
	
	$('#submit').attr('disabled', false);
	$('#reimbursement-message').hide();
	
	if(!$('#description').val()){
		$('#submit').attr('disabled', true);
		$('#reimbursement-message').html('Please enter a description');
		$('#reimbursement-message').show();
	} else if(isNaN(parseFloat($('#amount').val()))){
		$('#submit').attr('disabled', true);
		$('#reimbursement-message').html('Please enter a number for the amount');
		$('#reimbursement-message').show();
	}
}

function createReimbursement(){
	console.log('In createReimbursement()');
	
	let desc = $('#description').val();
	let amt = parseFloat($('#amount').val());
	let time = new Date();
	let type = parseInt($('#type').val());
	console.log(type);
	
	let reimb = {
		id: 0,
		amount: amt,
		timeSubmitted: time,
		timeResolved: null,
		description: desc,
		receipt: null,
		author: null,
		resolver: null,
		status: 1,
		type: type
	};
	
	let json = JSON.stringify(reimb);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = () => {
		if(xhr.readyState == 4 && xhr.status == 200){
			loadLanding();
		}
	};
	
	xhr.open('POST', 'createReimbursement', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function loadLanding(){
	console.log('In loadLanding()');
	
	xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = () => {
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			loadLandingInfo();
			$('#toLogin').hide();
			$('#toRegister').hide();
			
			$('#toLogout').show();
			
			$('#create').click(loadCreateReimbursement);
		}
	};
	
	xhr.open('GET', 'landing.view', true);
	xhr.send();
}

function loadLandingInfo(){
	console.log('In loadLandingInfo()');
	
	xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = () => {
		if(xhr.readyState == 4 && xhr.status == 200){
			let reimbs = JSON.parse(xhr.responseText);
			console.log(reimbs);
			
			let statuses = ['', 'Pending', 'Approved', 'Denied'];
			let types = ['', 'Lodging', 'Travel', 'Food', 'Other'];
			
			reimbs.forEach((r) => {
				let status = r.status;
				let type = r.type;
				let desc = r.description;
				let amount = r.amount;
				let resolver = r.resolver;
				let time = new Date(r.timeSubmitted);
				
				let markup = `
					<tr>
						<td>${statuses[status]}</td>
						<td>${types[type]}</td>
						<td>${desc}</td>
						<td>${time.toString()}</td>
						<td>${amount}</td>
						<td>${resolver}</td>
					</tr>
				`;
				
				$('table tbody').append(markup);
			});
		}
	};
	
	xhr.open('GET', 'landing.loadinfo', true);
	xhr.send();
}























