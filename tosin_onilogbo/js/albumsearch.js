
window.onload = () => {
    let page = document.getElementById("albumSearch")
    let pageUrl = new URL(window.location.href);
    let wantSearch = pageUrl.searchParams.get("search");
    console.log(wantSearch);
    fetch('http://ws.audioscrobbler.com/2.0/?method=album.search&album=' + wantSearch +
        '&api_key=9e10d6306576b0dcbc2321acf1e3652b&format=json').then(function (data) {
            return data.json();
        }).then(function (albumResults) {
            let alb = albumResults;
            console.log(alb)
            console.log(alb.results.albummatches.album[0].image[0])
            for (i = 0; i < alb.results.albummatches.album.length; i++) {
                document.createElement('img');
                let picture = document.createElement('img')  
                picture.src = alb.results.albummatches.album[i].image[3]["#text"];
                page.appendChild (picture);   

        }


        })
}

