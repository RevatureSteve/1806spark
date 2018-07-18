window.onload = () => {
    document.getElementById("searchBtn").addEventListener("click", search);
    document.addEventListener('click', openModal);
}

var storedObject = [];


function search() {
    var getInputValue = document.getElementById("search").value;
    fetch("https://api.themoviedb.org/3/search/movie?api_key=0c204b4eaedfebc5b97ce328217f531b&query=" + getInputValue).then(function (data) {
        return data.json(); // reading response and looking for just the json
    }).then(function (json) {

        jsonMovieList = json;
        var divTag = document.getElementsByClassName("movieRow")[0];
        var h2 = document.getElementsByTagName("h2")[0];
        storedObject = [];

        for (var i = 0; i < jsonMovieList.results.length; i++) {
            h2.innerHTML = "Search results for: " + getInputValue;
            var createPosters = document.createElement("img");
            var createRow = document.createElement("div");
            var createTitle = document.createElement("h5");
            divTag.appendChild(createRow);
            createRow.setAttribute("class", "movieColumn modalInfoBtn");
            createRow.appendChild(createTitle);
            createTitle.setAttribute('class', 'movieTitleHome');
            createRow.appendChild(createPosters);
            createPosters.setAttribute("class", "moviePoster");
            selectTitle = document.getElementsByClassName("movieTitleHome")[i];
            selectPoster = document.getElementsByClassName("moviePoster")[i];
            if (jsonMovieList.results[i].poster_path !== null && jsonMovieList.results[i].title !== null) {
                selectTitle.innerHTML = jsonMovieList.results[i].title;
                selectPoster.src = "http://image.tmdb.org/t/p/w185//" + jsonMovieList.results[i].poster_path;
            }
            storedObject.push({
                id: jsonMovieList.results[i].id,
                title: jsonMovieList.results[i].title,
                overview: jsonMovieList.results[i].overview,
                poster_path: 'http://image.tmdb.org/t/p/w185//' + jsonMovieList.results[i].poster_path
            })
        }
        console.log(storedObject);
    })
}

var modal = document.getElementById('myModal');
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
function openModal() {
    var btnCheck = event.target.currentSrc;
    var btn = document.getElementsByClassName("modalInfoBtn");
    for (let i = 0; i < storedObject.length; i++) {
        // Get the button that opens the modal
        // When the user clicks the button, open the modal  
        if (btnCheck == storedObject[i].poster_path) {
                modal.style.display = "block";
                document.getElementById("modalMovieTitle").innerHTML = storedObject[i].title;
                document.getElementById("modalMoviePoster").src = storedObject[i].poster_path;
                document.getElementById("modalMovieSummary").innerHTML = storedObject[i].overview;
            }
        }
        
        // When the user clicks on <span> (x), close the modal
        span.onclick = function () {
            modal.style.display = "none";
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    }


