
// loads movie information to the page after all files get read

let newDate = new Date();
newDate.setDate(newDate.getDate());
let currentDateString = (newDate.getFullYear() + '-'
    + ('0' + (newDate.getMonth() + 1)).slice(-2) + '-'
    + ('0' + newDate.getDate()).slice(-2));
let previousMonthDateString = (newDate.getFullYear() + '-'
    + ('0' + (newDate.getMonth())).slice(-2) + '-'
    + ('0' + newDate.getDate()).slice(-2));


window.onload = () => {
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

    // Validation for password
    document.getElementById("password").addEventListener("input", passwordValidation);
    document.getElementById("password").addEventListener("focus", passwordPopupCheck);
    document.getElementById("password").addEventListener("blur", toggleCheck);

    function passwordPopupCheck() {
        var popup = document.getElementById("myPopup");
        popup.classList.toggle("show");
        passwordValidation();
    }

    function toggleCheck() {
        var checkmarks = document.getElementsByClassName("checkmark");
        var popup = document.getElementById("myPopup");
        if (popup.classList.contains("show")) {
            for (let i = 0; i < checkmarks.length; i++) {
                checkmarks[i].classList.remove("show");
            }
        }
        popup.classList.toggle("show");
    }

    function passwordValidation() {
        let value = document.getElementById("password").value;
        let visibility = document.getElementById("myPopup");
        let length = value.length;
        let checkUpper = /[A-Z]/.test(value);
        let checkLower = /[a-z]/.test(value);
        let checkSpecial = /[!?@#$&*.]/.test(value);
        let checkNum = /\d/.test(value);
        //let checkSpace = /[^/S]/.test(value);
        let checked;
        console.log("check for length: " + length);
        // if (visibility.classList.contains("show")) {
        if (length > 7 && length < 21) {
            console.log("You have a good length of: " + length);
            checked = document.getElementsByClassName("checkmark")[0];
            checked.classList.add("show");
        } else {
            checked = document.getElementsByClassName("checkmark")[0];
            checked.classList.remove("show");
        }
        if (checkUpper) {
            console.log("check for uppercase: " + checkUpper);
            checked = document.getElementsByClassName("checkmark")[1];
            checked.classList.add("show");
        } else {
            checked = document.getElementsByClassName("checkmark")[1];
            checked.classList.remove("show");
        }

        if (checkLower) {
            console.log("check for lowercase: " + checkLower);
            checked = document.getElementsByClassName("checkmark")[2];
            checked.classList.add("show");
        } else {
            checked = document.getElementsByClassName("checkmark")[2];
            checked.classList.remove("show");
        }
        if (checkNum) {
            console.log("check for number: " + checkNum);
            checked = document.getElementsByClassName("checkmark")[3];
            checked.classList.add("show");
        } else {
            checked = document.getElementsByClassName("checkmark")[3];
            checked.classList.remove("show");
        }
        if (checkSpecial) {
            console.log("check for special character: " + checkSpecial);
            checked = document.getElementsByClassName("checkmark")[4];
            checked.classList.add("show");
        } else {
            checked = document.getElementsByClassName("checkmark")[4];
            checked.classList.remove("show");
        }
        if (checkLower && checkUpper && checkSpecial && checkNum && length > 7 && length < 21) {
            document.getElementById("password").classList.remove("is-invalid");
            document.getElementById("password").classList.add("is-valid");
            // document.getElementById("signup").classList.toggle("disabled");
            // document.getElementById("signup").removeAttribute("disabled");
        }
        else {
            document.getElementById("password").classList.remove("is-valid");
            document.getElementById("password").classList.add("is-invalid");
            // document.getElementById("signup").classList.toggle("disabled");
            // document.getElementById("signup").setAttribute("disabled");
        }
    }
    document.getElementById("passwordCheck").addEventListener("input", matchPassword);

    function matchPassword() {
        let passwordInput = document.getElementById("password").value;
        let compareValue = document.getElementById("passwordCheck").value;
        let checkPassword = document.getElementById("passwordCheck");
        if (passwordInput === compareValue) {
            checkPassword.classList.remove("is-invalid");
            checkPassword.classList.add("is-valid");
            console.log("passwords match");
        }
        else {
            checkPassword.classList.remove("is-valid");
            checkPassword.classList.add("is-invalid");
            console.log("passwords don't match");
        }
    }

}
// to turn on pop up for password validation