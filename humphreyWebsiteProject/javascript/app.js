


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
            fetch("https://api.themoviedb.org/3/search/movie?api_key=de645bfacfad1d8fc5c6b13e4d3780ee&query=" + getInputValue).then(function (data) {
                return data.json(); // reading response and looking for just the json
            }).then(function (jsonMovie) {

                jsonMovieResults = jsonMovie;
                
                for(i=0;i<jsonMovieResults.results.length;i++){
               var createPosters = document.createElement("img");
               var divTag = document.getElementById("moviePosters")
               divTag.appendChild(createPosters);
               createPosters.setAttribute("id","posterImages"+i);
               selectPoster=document.getElementById("posterImages"+i);
            //    var selectPosters = document.getElementsByClassName("posterImages")[i];
            if(jsonMovieResults.results[i].poster_path !== null) {
               selectPoster.src= "http://image.tmdb.org/t/p/w185//" + jsonMovieResults.results[i].poster_path;

            }

                }
                
                
            });
        })
    
    };



