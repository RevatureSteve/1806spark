
// loads movie information to the page after all files get read

let newDate = new Date();
newDate.setDate(newDate.getDate());
let currentDateString = (newDate.getFullYear() + '-'
    + ('0' + (newDate.getMonth() + 1)).slice(-2) + '-'
    + ('0' + newDate.getDate()).slice(-2));
let previousMonthDateString = (newDate.getFullYear() + '-'
    + ('0' + (newDate.getMonth())).slice(-2) + '-'
    + ('0' + newDate.getDate()).slice(-2));


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
                moviePoster[i].src = 'https://image.tmdb.org/t/p/w185' + jsonObject.results[i].poster_path;
            }
        });

function searchFunction() {
    let jsonObject = null;
    let searchUrl = document.getElementById("search").value;
    window.sessionStorage.setItem('query')
    fetch("https://api.themoviedb.org/3/search/movie?api_key=0c204b4eaedfebc5b97ce328217f531b&language=en-US&query=" + searchUrl + "&page=1&include_adult=false")
    .then(data => {
        return data.json();
    }).then(json => {
        jsonObject = json
        for (i=0;i<jsonObject.results.length;i++){
            var createPosters = document.createElement("img");
            var divTag = document.getElementById("moviePosters")
            divTag.appendChild(createPosters);
            createPosters.setAttribute("class","posterImagesCreate");
            let selectPoster = document.getElementsByClassName("posterImagesCreate")[i];
        }
    })
}


