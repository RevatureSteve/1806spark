/*
let testReview = {
    header: "This is a test review",
    author: "John Doe",
    movieTitle: "Jurassic Park",
    reviewBody: "Great movie",
    commentsArr: [{ commentAuthor: "Marcin Salamon", comment: "terrible review" },
    { commentAuthor: "John Doe", comment: "great review" }]
}
db.users.insertOne(
{
    header: "Definitely worth seeing",
    author: "Marcin Salamon",
    movieTitle: "Ant Man and the Wasp",
    reviewBody: "A comedic masterpiece with solid plot and great action sequences",
    commentsArr: [{ commentAuthor: "John Doe", comment: "Great moview" },
    { commentAuthor: "destroyer", comment: "10/10 movie" }]
}
)

let testReview2 = {
    header: "Definitely worth seeing",
    author: "Marcin Salamon",
    movieTitle: "Ant Man and the Wasp",
    reviewBody: "A comedic masterpiece with solid plot and great action sequences",
    commentsArr: [{ commentAuthor: "John Doe", comment: "Great moview" },
    { commentAuthor: "destroyer", comment: "10/10 movie" }]
}

let reviews = [testReview, testReview2];
*/

var url = 'http://localhost:3000/reviews';
var reviews = null;

window.onload = function () {
    //console.log(window.parent.accountLogged);

    callReviews();
}

function callReviews(){
    fetch(url)
    .then((resp) => {
        return resp.json();
    })
    .then((data)=> {
        console.log(data);
        reviews = data;
        displayReviews(reviews);
    })
}

// dynamically creates elements based on reviews in the reviews array
function displayReviews(reviews) {
    for (
        // creates a div in which the review is contained
        let i = 0; i < reviews.length; i++) {
        let review = reviews[i];
        let newDiv = document.createElement('div');
        document.body.appendChild(newDiv);
        newDiv.className = 'review';

        // displays a movie poster by searching OMDb for movie based on title
        let str = review.movieTitle;
        let replaced = str.split(' ').join('+');

        let moviePoster = document.createElement('img');
        newDiv.appendChild(moviePoster);

        fetch('http://www.omdbapi.com/?t=' + replaced + '&apikey=2bffe9df')
            .then(function (data) {
                return data.json();
            })
            .then(function (movieData) {
                moviePoster.src = movieData.Poster;
            });

        // displays review title
        let reviewTitle = document.createElement('h1');
        newDiv.appendChild(reviewTitle);
        reviewTitle.innerHTML = review.header;
        reviewTitle.className = 'reviewTitle';

        //displays review author
        let reviewAuthor = document.createElement('h3');
        newDiv.appendChild(reviewAuthor);
        reviewAuthor.innerHTML = 'By ' + review.author;
        reviewAuthor.className = 'author';

        //displays movie title
        let movieTitle = document.createElement('h2');
        newDiv.appendChild(movieTitle);
        movieTitle.innerHTML = review.movieTitle;

        //displays the body of a review
        let reviewBody = this.document.createElement('p');
        newDiv.appendChild(reviewBody);
        reviewBody.innerHTML = review.reviewBody;

        // creates a div containing the comment section
        let commentSection = this.document.createElement('div');
        newDiv.appendChild(commentSection);
        commentSection.className = 'comments';

        // displays title of the comment section
        let commentsTitle = this.document.createElement('h2');
        commentSection.appendChild(commentsTitle);
        commentsTitle.innerHTML = 'Comment section';

        //populates the comment section with names of authors and actual comments
        for (let j = 0; j < review.commentsArr.length; j++) {
            let commentAuthor = this.document.createElement('div');
            commentSection.appendChild(commentAuthor);
            commentAuthor.innerHTML = review.commentsArr[j].commentAuthor;
            commentAuthor.className = 'author';
            let sampleComment = this.document.createElement('p');
            sampleComment.className = 'comment';
            commentSection.appendChild(sampleComment);
            sampleComment.innerHTML = review.commentsArr[j].comment;
        }

        // comment submittal form
        let form = this.document.createElement('form');
        let commentInputBox = this.document.createElement('textarea');
        let commentButton = this.document.createElement('input');
        commentButton.type = 'submit';
        commentInputBox.placeholder = "Insert comment here";
        form.appendChild(commentInputBox);
        form.appendChild(commentButton);
        commentSection.appendChild(form);
    }
}