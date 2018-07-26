window.onload = function () {

    image.addEventListener("click", changeSearch)

    document.getElementById("addSubmit").addEventListener("click", () =>{
       var fetchURL = "http://localhost:3001/addMovies";
       var titleValue = document.getElementById("addTitleInput").value
       var releaseValue = document.getElementById("addReleaseInput").value
       var plotValue = document.getElementById("addPlotInput").value
       var genreValue = document.getElementById("addGenreSelect").value
       var urlValue = document.getElementById("addCoverArtInput").value


       var data = {
        "movieTitle": titleValue,
        "releaseDate": releaseValue,
        "plot": plotValue,
        "genre": genreValue,
        "moviePoster": urlValue
       }

       fetch(fetchURL, {
        method: 'POST', // or 'PUT'
        body: JSON.stringify(data), // data can be `string` or {object}! Must be converted to JSON
        headers:{
          'Content-Type': 'application/json'
        }
    }).then(function (data){ return data.json();}).then(function (newMovie) {
            console.log(newMovie);
        // newQuestionStatus.innerHTML = q.question + " " + q.answer;
    });

    gif = document.getElementById("addGif");
    inputTitle = document.getElementById("addTitleInput");
    inputRelease = document.getElementById("addReleaseInput");
    inputPlot = document.getElementById("addPlotInput");
    inputGenre = document.getElementById("addGenreSelect");
    inputCoverArt = document.getElementById("addCoverArtInput");
    submitBtn = document.getElementById("addSubmit");
    gif.parentNode.removeChild(gif);
    inputTitle.parentNode.removeChild(inputTitle);
    inputRelease.parentNode.removeChild(inputRelease);
    inputPlot.parentNode.removeChild(inputPlot);
    inputGenre.parentNode.removeChild(inputGenre);
    inputCoverArt.parentNode.removeChild(inputCoverArt);
    submitBtn.parentNode.removeChild(submitBtn);
    confirmation = document.createElement("h3");
    confirmation.setAttribute("id","confirmAddition")
    theDiv = document.getElementById("addDiv");
    theDiv.appendChild(confirmation);
    confirmation.innerHTML = "Thank you! \n You've Succesfully Added Movie";

    })



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
            if(document.contains(document.getElementById("addTitle"))){
            h1 = document.getElementById("addTitle");
            h1.innerHTML= "Search for: " + getInputValue
            h1.style.marginLeft="290px";
            }
            if(document.contains(document.getElementById("addDiv"))){
                loginField = document.getElementById("addDiv");
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

