/********************************************** 
    User authentication and navbar control
        -initNavbar: No user session, set Eventlisteners -> hide links, show login link
        -userAuthentication -> fetch request to api to validate user
        -validUser -> display links, show logout link
*/

/**
 *  fetch to Java API
 *      -valid -> validUserNavbar, 
 */
function userAuthentication(){
    const url = 'http://localhost:8085/TodoList-Restful-API/login'
    let user = {}
    //user object must match the java class!!
    user.username = document.getElementById('username').value;
    user.password = document.getElementById('password').value;
    console.log('userAuthentication called');
    console.dir(user);
    
    fetch(url,{
        body: JSON.stringify(user),
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
          }
    }).then( data => {
        if(data){
            return data.json();
        }else{
            return null;
        }})
    .then(json => {
        if(json){
            validUser = json;
            validUserNavbar();
            updateRoute(null,'dashboardLink');
        }
        console.log(json)} );
}

/**
 *  once user is authenticated update navbar
 *      -login to logout
 *      -display links to navbar
 */
function validUserNavbar(){
    if(validUser){
    // change login to logout since user is 
    document.getElementById('loginLink').innerHTML = "logout";
    // display navbar links
    document.getElementById('user-navbar').style.display = "";;
    }
}

/*
*******************end of user authentication
*/