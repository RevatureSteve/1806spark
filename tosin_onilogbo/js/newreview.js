let url = '/reviews';
document.getElementById('add').addEventListener('click', newReview);
function newReview(){
    let artist = document.getElementById('artistInput').value;
    let album = document.getElementById('albumInput').value;
    let year = document.getElementById('yearInput').value;
    let review = document.getElementById('reviewInput').value;
    
    // Post data!
    let data = {
        "title": album,
        "artist": artist,
        "year": year,
        "review": review
    }

    fetch(url, {
        method: 'POST', //
        body: JSON.stringify(data), // converts to JSON
        headers: {
            "Content-Type": "application/json; charset=utf-8",
            "Accept": "application/json"
        }
    }).then(data=> data.json()).then(q => {
            console.log(q);
    });
}
