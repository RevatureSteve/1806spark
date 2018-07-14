window.onload = function () {

    var inputFirstName = document.getElementById("registerFirstName");

    image.addEventListener("click", changeSearch);

    inputFirstName.addEventListener("change", clientValidation1);

    
}

var image = document.getElementById("searchIcon");
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
            if(document.contains(document.getElementById("registerTitle"))){
            h1 = document.getElementById("registerTitle");
            h1.innerHTML= "Search for: " + getInputValue
            h1.style.marginLeft="290px";
            }
            if(document.contains(document.getElementById("register"))){
                loginField = document.getElementById("register");
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

function clientValidation1(){

 var inputFirstName = document.getElementById("registerFirstName").value;

 var arrayFirstName = inputFirstName.split("");

 for (i=0; i < arrayFirstName.length;i++){

    var x = parseInt(arrayFirstName[i]);
   if(x === 0 ||x === 1 ||x === 2 ||x === 3 ||x === 4 ||x === 5 ||x === 6 ||x === 7 ||x === 8 ||x === 9){

        var firstNameText = document.getElementById("registerText1");
        firstNameText.innerHTML = "Must not contain a number";
        firstNameText.style.color = "red";

        
    }
    else{
        var firstNameText = document.getElementById("registerText1");
        document.getElementById("registerText1").innerHTML = "Yay";
        firstNameText.style.color = "black";
    }
 }


    
}

