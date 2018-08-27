

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
      fetch('http://localhost:8080/my-app/pending?req_type=1&u_id='+ newUser.u_id, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
    }).then(response => { 
      return response.json(); 
    }).then(data => { 
      newPendingReqs = data;
      console.log(newPendingReqs[0]);
      createTable();
    }).catch(err => {
           console.log("[LOG]---------" + err );
    });
   }
    function updateReqs(){
      console.log("Update " + newUser.u_id);
      for(let i = list.length - 1; i > -1; i--){
        
        fetch('http://localhost:8080/my-app/updatereq?req_id='+ list[i] + '&req_status='+ reqStatus + '&mgr_id=' + newUser.u_id, {
          method: 'GET',
          headers: {'Content-Type': 'application/json'}
      }).then(response => { 
        return response.json(); 
      }).then(data => { 
        resultSet = data;
        console.log(resultSet);
      }).catch(err => {
             console.log("[LOG]---------" + err );
      });
     }
     clearArray();
      }
      

   function resolvedReqs(){
    fetch('http://localhost:8080/my-app/resolved?u_id='+ newUser.u_id, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
    }).then(response => { 
      return response.json(); 
    }).then(data => { 
      newResolvedReqs = data;
      console.log(newResolvedReqs[0]);
      createResolvedTable();
    }).catch(err => {
           console.log("[LOG]---------" + err );
    });
   }
   function createReq(){
    console.log("Reaching out");
    amount = parseInt(document.getElementById('amount').value);
    reqType =  parseInt(document.getElementById('r_type').value);
    desc = document.getElementById('desc').value;
    let data = {"amt": amount, 
        "req_type": reqType,
        "desc": desc,
        "u_id": newUser.u_id};

        console.log(data);
    fetch('http://localhost:8080/my-app/newreq', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {'Content-Type': 'application/json'}
    }).then(response => { 
      return response.json(); 
    }).then(data => { 
      resultSet = data;
      console.log('Submitted!? ' + resultSet);
      reqSent();
    }).catch(err => {
           console.log("[LOG]---------" + err );
           reqSent();
    });
   }

   function allReqs(){
   
    fetch('http://localhost:8080/my-app/all', {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
    }).then(response => { 
      return response.json(); 
    }).then(data => { 
      newAllReqs = data;
      console.log(newAllReqs[0]);
      createAllPendingTable();
    }).catch(err => {
           console.log("[LOG]---------" + err );
    });
    tableOn = 0;
   }

   
   function allEmps(){
   
    fetch('http://localhost:8080/my-app/emp', {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
    }).then(response => { 
      return response.json(); 
    }).then(data => { 
      empList = data;
      console.log(empList[0]);
      populateEmpTable();
    }).catch(err => {
           console.log("[LOG]---------" + err );
    });

   }
   function searchEmp(){

    let userId = document.getElementById('userId').value;
    let req = document.getElementById('r_type').value;
    console.log(userId + " " + req );
    fetch('http://localhost:8080/my-app/pending?req_type='+ req +'&u_id='+ userId, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
    }).then(response => { 
      return response.json(); 
    }).then(data => { 
      searchData = data;
      console.log(searchData[0]);
      populateSearchTable();
    }).catch(err => {
           console.log("[LOG]---------" + err );
    });

   }
   function getAllResolvedReqs(){

    fetch(' http://localhost:8080/my-app/resolvedreqs', {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
    }).then(response => { 
      return response.json(); 
    }).then(data => { 
      newAllResolvedReqs = data;
      console.log(newAllResolvedReqs);
      populateReqTable();
    }).catch(err => {
           console.log("[LOG]---------" + err );
    });

   }
  
    
    
    
    
    

    


