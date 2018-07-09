var testReview = {
    header: "This is a test review",
    movieTitle: "Jurassic Park",
    reviewBody: "Great movie",
    commentsArr: ["terrible review", "great review"]
}

var testReview2 = {
    header: "Definitely worth seeing",
    movieTitle: "Ant-Man and the Wasp",
    reviewBody: "A comedic masterpiece with solid plot and great action sequences",
    commentsArr: ["I agree", "I fully agree"]
}

var reviews = [testReview, testReview2];

window.onload = function () {

    for (var i = 0; i < reviews.length; i++) {
        var review = reviews[i];
        var newDiv = document.createElement('div');
        document.body.appendChild(newDiv);
        newDiv.className = 'review';

        var reviewTitle = document.createElement('h1');
        newDiv.appendChild(reviewTitle);
        reviewTitle.innerHTML = review.header;

        var movieTitle = document.createElement('h2');
        newDiv.appendChild(movieTitle);
        movieTitle.innerHTML = review.movieTitle;

        var reviewBody = this.document.createElement('p');
        newDiv.appendChild(reviewBody);
        reviewBody.innerHTML = review.reviewBody;

        var sampleComment = this.document.createElement('p');
        sampleComment.className = 'comment';
        newDiv.appendChild(sampleComment);
        sampleComment.innerHTML = review.commentsArr[0];

        var form = this.document.createElement('form');
        var commentInputBox = this.document.createElement('textarea');
        //commentInputBox.type = 'text';
        var commentButton = this.document.createElement('input');
        commentButton.type = 'submit';
        form.appendChild(commentInputBox);
        form.appendChild(commentButton);

        newDiv.appendChild(form);
    }

}