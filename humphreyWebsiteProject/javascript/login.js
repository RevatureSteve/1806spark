window.onload = function () {

    image.addEventListener("click", changeSearch)


}

var image = document.getElementById("searchIcon")
var getInputValue = null;
var jsonMovieResults = null;

function changeSearch() {
    var image = document.getElementById("searchIcon")
    var htmlForm = document.getElementsByTagName("form")[0];
    image.parentNode.removeChild(image);
    inputBox = document.createElement("input");
    htmlForm.appendChild(inputBox);
    var inputBoxGet = document.getElementsByTagName("input")[0];
    inputBoxGet.setAttribute("type", "search");
    inputBoxGet.setAttribute("placeholder", "Search...");
    inputBoxGet.setAttribute("id", "inputBoxid");
    inputBoxGet.addEventListener("change", () => {
            getInputValue = inputBoxGet.value;
            alert(getInputValue);
            if(document.contains(document.getElementById("title"))){
            h1 = document.getElementById("title");
            h1.innerHTML= "Search for: " + getInputValue
            h1.style.marginLeft="290px";
            }
            if(document.contains(document.getElementById("login"))){
                loginField = document.getElementById("login");
                loginField.parentNode.removeChild(loginField);
                }
            fetch("https://api.themoviedb.org/3/search/movie?api_key=de645bfacfad1d8fc5c6b13e4d3780ee&query=" + getInputValue).then(function (data) {
                return data.json(); // reading response and looking for just the json
            }).then(function (jsonMovie) {

                jsonMovieResults = jsonMovie;
                
                for(i=0;i<jsonMovieResults.results.length;i++){
               var createPosters = document.createElement("img");
               var divTag = document.getElementById("moviePosters1")
               divTag.appendChild(createPosters);
               createPosters.setAttribute("class","posterImagesCreate");
               selectPoster=document.getElementsByClassName("posterImagesCreate")[i];
            //    var selectPosters = document.getElementsByClassName("posterImages")[i];
            if(jsonMovieResults.results[i].poster_path !== null) {
               selectPoster.src= "http://image.tmdb.org/t/p/w185//" + jsonMovieResults.results[i].poster_path;

            }

                }
                
                
            });
        })
    
    };

    document.getElementById("loginBtn").addEventListener("click",() =>{

        fetch("http://localhost:3001/register").then(function (data) {
            return data.json(); // reading response and looking for just the json
        }).then(function (registrationData) {

            registerList = registrationData;
            console.log(registerList);
            username = document.getElementById("loginUsername").value;
            password = document.getElementById("loginPassword").value;
            for(i=0;i<registerList.length;i++){

                if(registerList[i].username == username && registerList[i].password == password){
                    console.log("Welcome " + registerList.firstname)
                    if(document.contains(document.getElementById("invalidUser"))){
                        deleteError=document.getElementById("invalidUser");
                        deleteError.parentNode.removeChild(deleteError);}
                    usernameBox = document.getElementById("loginUsername")
                        usernameBox.parentNode.removeChild(usernameBox);
                    passwordBox = document.getElementById("loginPassword")
                        passwordBox.parentNode.removeChild(passwordBox);
                    signinTitle = document.getElementById("loginSignin")
                        signinTitle.parentNode.removeChild(signinTitle);
                    loginButton = document.getElementById("loginBtn")
                        loginButton.parentNode.removeChild(loginButton);
                    bottomLink = document.getElementById("link")
                        bottomLink.parentNode.removeChild(bottomLink);
                    loginConfirmation = document.createElement("h3");
                    loginConfirmation.setAttribute("id","loginConfirm")
                    theDiv = document.getElementById("login");
                    theDiv.appendChild(loginConfirmation);
                    loginConfirmation.innerHTML = "Welcome Back, " + registerList[i].firstName + " " + registerList[i].lastName;
                } 
                
                else if(document.contains(document.getElementById("invalidUser"))){
                    deleteError=document.getElementById("invalidUser");
                    deleteError.parentNode.removeChild(deleteError);
                    error = document.createElement("h4");
                    error.setAttribute("id","invalidUser")
                    error.innerHTML = "Invalid Username or Password"
                    parDiv = document.getElementById("login");
                    parDiv.appendChild(error);
                    } else{
                        error = document.createElement("h4");
                    error.setAttribute("id","invalidUser")
                    error.innerHTML = "Invalid Username or Password"
                    parDiv = document.getElementById("login");
                    parDiv.appendChild(error);

                    }
                

                

            }
        })



    })



