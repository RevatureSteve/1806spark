window.onload = () => {
    document.getElementById("searchBtn").addEventListener("click", changeSearch);
    
}



function changeSearch() {
    var getInputValue = document.getElementById("search").value;
    fetch("https://api.themoviedb.org/3/search/movie?api_key=0c204b4eaedfebc5b97ce328217f531b&query=" + getInputValue).then(function (data) {
        return data.json(); // reading response and looking for just the json
    }).then(function(json) {

        jsonMovieResults = json;
        var divTag = document.getElementsByClassName("movieRow")[0];
        var h2 = document.getElementsByTagName("h2")[0];

        for (var i = 0; i < jsonMovieResults.results.length; i++) {
            h2.innerHTML = "Search results for: " + getInputValue;
            var createPosters = document.createElement("img");
            var createRow = document.createElement("div");
            var createTitle = document.createElement("h5");
            divTag.appendChild(createRow);
            createRow.setAttribute("class", "movieColumn");
            createRow.appendChild(createTitle);
            createTitle.setAttribute('class', 'movieTitleHome');
            createRow.appendChild(createPosters);
            createPosters.setAttribute("class", "moviePoster");
            selectTitle = document.getElementsByClassName("movieTitleHome")[i];
            selectPoster = document.getElementsByClassName("moviePoster")[i];
            if (jsonMovieResults.results[i].poster_path !== null && jsonMovieResults.results[i].title !== null) {
                selectTitle.innerHTML = jsonMovieResults.results[i].title;
                selectPoster.src = "http://image.tmdb.org/t/p/w185//" + jsonMovieResults.results[i].poster_path;
            }
        }
    })
}