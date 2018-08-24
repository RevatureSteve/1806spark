

    function login(){
        let email;
        let password;
        email = document.getElementById('loginBox').value;
        password = document.getElementById('passwordBox').value;
        
        let data = {"email": email, 
        "password": password};
     fetch('http://localhost:8080/my-app/login', {
         method: 'POST',
         body: JSON.stringify(data),
         headers: {'Content-Type': 'application/json'}
     }).then(response => { 
       return response.json(); 
     }).then(data => { 
       newUser = data;
       userLogged();
     }).catch(err => {
            alert("Invalid login....");
            console.log("[LOG]---------" + err );
     });
    }
    
    
    
    

    


