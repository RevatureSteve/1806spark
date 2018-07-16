var url = 'http://localhost:3000/reviews';
window.onload = function () {
    document.getElementById("submitNewReview").onclick = function () {
        let head = document.getElementById('header').value;
        let author = document.getElementById('author').value;
        let movieTitle = document.getElementById('title').value;
        let revBody = document.getElementById('revBody').value;

        let data = {
            "header": head,
            "author": author,
            "movieTitle": movieTitle,
            "reviewBody": revBody,
            "commentsArr": [],
            "commentsAuthors": []
        }

        console.log(data);

        fetch(url, {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(data => data.json()).then(q => {
            console.log('post');

        });
    }
}

