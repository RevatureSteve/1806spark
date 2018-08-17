window.onload = function () {
   var username = document.querySelector('').value;
   var password = document.querySelector('').value;

    function verify() {
        while (username != null & password != null) {
            //get input from the input fields!!!
            //compare username to database 
            //compare password to database
            //also as user type let them knwo the password requirement met or unmet
            //what am i waiting for create the login page already
            // on successful login pop up a welcome screen 
            //(create another function call it welcome with a good message)
            // on incorrect password play a negative sound and try adding animation so that the password tab move left and right then turn red
            // make sure usernme and password arent the same!!!
            if (username == null) {
                document.querySelector('').innerHTML = "Please Type In your UserName!";

            } if (username.value > 6) { // this should be the password
                document.querySelector('').innerHTML = "think of something"
            } if (useername.value < 6) {// this should be the password
                    //prompt the user to and more number wtc
            }
        }
    }

}
