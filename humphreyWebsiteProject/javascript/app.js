


window.onload = function () {

    image.addEventListener("click", changeSearch)

    var i;
}

var image = document.getElementById("searchIcon")
var getInputValue = null;
var jsonMovieResults = null;
var i;
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
            fetch("https://api.themoviedb.org/3/search/movie?api_key=de645bfacfad1d8fc5c6b13e4d3780ee&query=" + getInputValue).then(function (data) {
                return data.json(); // reading response and looking for just the json
            }).then(function (jsonMovie) {

                jsonMovieResults = jsonMovie;
                
                for(i=0;i<jsonMovieResults.results.length;i++){
               var createPosters = document.createElement("img");
               var divTag = document.getElementById("moviePosters");
               divTag.appendChild(createPosters);
               createPosters.setAttribute("class","posterImagesCreate");
               selectPoster=document.getElementsByClassName("posterImagesCreate")[i];
            //    var selectPosters = document.getElementsByClassName("posterImages")[i];
            if(jsonMovieResults.results[i].poster_path !== null) {
               selectPoster.src= "http://image.tmdb.org/t/p/w185//" + jsonMovieResults.results[i].poster_path;
               
            }
            document.getElementsByClassName("posterImagesCreate")[i].addEventListener("click",() =>{
                fetch("https://api.themoviedb.org/3/search/movie?api_key=de645bfacfad1d8fc5c6b13e4d3780ee&query=" + getInputValue).then(function (data) {
                    return data.json(); // reading response and looking for just the json
                    }).then(function (jsonMovie) {
                        
                    jsonMovieResults = jsonMovie;
                // for(i=0;i<jsonMovieResults.results.length;i++){
                var modalDiv = document.createElement("div");
                modalDiv.setAttribute("class","modal");
                modalDiv.setAttribute("id","myModal");
                document.getElementById("moviePosters").appendChild(modalDiv);
                var modalContent = document.createElement("div");
                modalContent.setAttribute("class","modal-content");
                modalDiv.appendChild(modalContent);
                var modalSpan = document.createElement("span");
                modalSpan.setAttribute("class","close");
                modalDiv.appendChild(modalSpan);
                modalDiv.style.display = "block";
                window.onclick = function(event) {
                    if (event.target == modalDiv) {
                        modalDiv.style.display = "none";
                    }
                }
                var title = document.createElement("h1");
                title.setAttribute("id","modalTitle");
                modalContent.appendChild(title);
                document.getElementById("modalTitle").innerHTML = "Write Review"
            })  


            })
        }
                
                
            });
        })
    
    };

    // function modals() {
    //     fetch("https://api.themoviedb.org/3/search/movie?api_key=de645bfacfad1d8fc5c6b13e4d3780ee&query=" + getInputValue).then(function (data) {
    //         return data.json(); // reading response and looking for just the json
    //         }).then(function (jsonMovie) {
                
    //         jsonMovieResults = jsonMovie;
    //     for(i=0;i<jsonMovieResults.results.length;i++){
    //     var modalDiv = document.createElement("div");
    //     modalDiv.setAttribute("class","modal");
    //     modalDiv.setAttribute("id","myModal");
    //     document.getElementById("moviePosters").appendChild(modalDiv);
    //     var modalContent = document.createElement("div");
    //     modalContent.setAttribute("class","modal-content");
    //     modalDiv.appendChild(modalContent);
    //     var modalSpan = document.createElement("span");
    //     modalSpan.setAttribute("class","close");
    //     modalDiv.appendChild(modalSpan);
    //     modalDiv.style.display = "block";
    //     window.onclick = function(event) {
    //         if (event.target == modalDiv) {
    //             modalDiv.style.display = "none";
    //         }
    //     }
    //     var title = document.createElement("h1");
    //     title.setAttribute("id","modalTitle");
    //     modalContent.appendChild(title);
    //     document.getElementById("modalTitle").innerHTML = "http://image.tmdb.org/t/p/w185//" + jsonMovieResults.results[i].original_title;
    // }})
    //     }