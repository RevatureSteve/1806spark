
// loads movie information to the page after all files get read

let newDate = new Date();
newDate.setDate(newDate.getDate());
let currentDateString = (newDate.getFullYear() + '-'
    + ('0' + (newDate.getMonth() + 1)).slice(-2) + '-'
    + ('0' + newDate.getDate()).slice(-2));
let previousMonthDateString = (newDate.getFullYear() + '-'
    + ('0' + (newDate.getMonth())).slice(-2) + '-'
    + ('0' + newDate.getDate()).slice(-2));

    let movieObject = [];
    let jsonObject = null;
    let movieTitle = document.getElementsByClassName('movieTitleHome');
    let moviePoster = document.getElementsByClassName('moviePoster');
fetch('https://api.themoviedb.org/3/discover/movie?api_key=0c204b4eaedfebc5b97ce328217f531b&' +
        'language=en-US&region=US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&primary_release_date.gte=' +
        previousMonthDateString + '&primary_release_date.lte=' + currentDateString).then(data => {
            return data.json();
        })
        .then(json => {
            console.log(json);
            jsonObject = json;
            for (let i = 0; i < movieTitle.length; i++) {
                movieTitle[i].innerHTML = jsonObject.results[i].title;
                moviePoster[i].src = 'https://image.tmdb.org/t/p/w185//' + jsonObject.results[i].poster_path;
                movieObject.push({
                    id: jsonObject.results[i].id,
                    title: jsonObject.results[i].title,
                    poster_path: 'https://image.tmdb.org/t/p/w185//' + jsonObject.results[i].poster_path,
                    overview: jsonObject.results[i].overview
                })
            }
        });

document.addEventListener('click', openModal);

// Get the modal
var modal = document.getElementById('myModal');
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
function openModal() {
    var btnCheck = event.target.currentSrc;
    var btn = document.getElementsByClassName("modalInfoBtn");
    for (let i = 0; i < movieObject.length; i++) {
        if (btnCheck == movieObject[i].poster_path) {
                modal.style.display = "block";
                document.getElementById("modalMovieTitle").innerHTML = movieObject[i].title;
                document.getElementById("modalMoviePoster").src = movieObject[i].poster_path;
                document.getElementById("modalMovieSummary").innerHTML = movieObject[i].overview;
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
