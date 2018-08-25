

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

    function pendingReqs(){
      
      fetch('http://localhost:8080/my-app/pending?req_type='+ newUser.u_id +'&u_id=1', {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
    }).then(response => { 
      return response.json(); 
    }).then(data => { 
      newPendingReqs = data;
      console.log(newPendingReqs[0]);
    }).catch(err => {
           console.log("[LOG]---------" + err );
    });
   }
    
    
    
    
    

    


