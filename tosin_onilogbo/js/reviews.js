var windy = null

window.onload = () => {
    windy = document.getElementById("albums");
    fetch("/reviews").then(response => {
        return response.json()
    }).then(release => {
        let rel = release;
        console.log(rel);
        for (i = 0; i < rel.length; i++) {
            console.log(rel[i]);
            let album = rel[i];
            let albumdiv = document.createElement('div');
            let albumTitle = document.createElement('h1');
            let artist = document.createElement('h2');
            let year = document.createElement('h3');
            let reviews = document.createElement('p');
            // pulling cover from api
            let cover = document.createElement('img');

            fetch('http://ws.audioscrobbler.com/2.0/?method=album.search&album=' + album.title + "&artist=" + album.artist +
                '&api_key=9e10d6306576b0dcbc2321acf1e3652b&format=json').then(function (data) {
                    return data.json();
                }).then(function (albumResults) {
                    let alb = albumResults;
                    console.log(alb);
                    console.log(alb.results.albummatches.album[0].image[3]);

                    cover.src = alb.results.albummatches.album[0].image[3]["#text"];





                });
                windy.appendChild(albumdiv);
                albumdiv.appendChild(albumTitle);
                albumdiv.appendChild(artist);
                albumdiv.appendChild(year);
                albumdiv.appendChild(reviews);
                albumdiv.appendChild(cover);
                albumTitle.innerHTML = album.title;
                artist.innerHTML = album.artist;
                year.innerHTML = album.year;
                reviews.innerHTML = album.review;


        }
    })
}






// let searchb = document.getElementById('searchb')

// searchb.addEventListener ('click', () => {
//    let wantSearch = document.getElementById('searchy').value
//    fetch('/2.0/?method=album.search&album=' + wantSearch + 
//    '&api_key=9e10d6306576b0dcbc2321acf1e3652b&format=json').then(function (data) {
//     return data.json();
//   }).then(function (albumResults) {
//       let alb = albumResults;
//       console.log(alb)


// })
// }
// )
