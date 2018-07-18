window.onload = function () {
    document.getElementById("registerBtn").addEventListener("click", newRegister);
}

function newRegister() {
    var firstName = document.getElementsByTagName("input")[0].value;
    var lastName = document.getElementsByTagName("input")[1].value;
    var dateBirth = document.getElementsByTagName("input")[2].value;
    var userName = document.getElementsByTagName("input")[3].value;
    var passWord = document.getElementsByTagName("input")[4].value;
    var confirmPass = document.getElementsByTagName("input")[5].value;

    var data = {
        "firstName": firstName,
        "lastName": lastName,
        "dateBirth": dateBirth,
        "userName": userName,
        "passWord": passWord,
        "confirmPass": confirmPass
    }

    // Checks for lengths

    if (firstName.length < 2 || firstName.length > 15) {
        console.log("First name must be between 2 and 15 character.");
        return;
    }

    if (lastName.length < 2 || lastName.length > 15) {
        console.log("Last name must be between 2 and 15 character.");
        return;
    }

    if (dateBirth.length < 1) {
        console.log("PLease fill out date of birth");
        return;
    }

    if (userName.length < 1) {
        console.log("PLease fill out username");
        return;
    }

    if (passWord.length < 8) {
        console.log("Please fill out password");
        return;
    }

    if (passWord !== confirmPass) {
        console.log("Passwords do not match");
        return;
    } else {
        alert("You are now registered.  You will be redirected to the home page.");

        window.location = "../home";
    }
}