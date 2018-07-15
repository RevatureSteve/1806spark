window.onload = function () {

    var inputFirstName = document.getElementById("registerFirstName");
    var inputLastName = document.getElementById("registerLastName");
    var inputEmail = document.getElementById("registerEmail");
    var inputUsername = document.getElementById("registerUsername");
    var inputPassword = document.getElementById("registerPassword");
    var confirmPassword = document.getElementById("confirmPassword");
    var confirmPasswordVal;

    image.addEventListener("click", changeSearch);

    inputFirstName.addEventListener("change", clientValidation1);
    inputLastName.addEventListener("change", clientValidation2);
    inputEmail.addEventListener("change", clientValidation3);
    inputUsername.addEventListener("change", clientValidation4);
    inputPassword.addEventListener("change", clientValidation5);
    confirmPassword.addEventListener("change", clientValidation6);

    
}
confirmPasswordVal = null;
var image = document.getElementById("searchIcon");
var getInputValue = null;
var jsonMovieResults = null;

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
            if(document.contains(document.getElementById("registerTitle"))){
            h1 = document.getElementById("registerTitle");
            h1.innerHTML= "Search for: " + getInputValue
            h1.style.marginLeft="290px";
            }
            if(document.contains(document.getElementById("register"))){
                loginField = document.getElementById("register");
                loginField.parentNode.removeChild(loginField);
                }
            fetch("https://api.themoviedb.org/3/search/movie?api_key=de645bfacfad1d8fc5c6b13e4d3780ee&query=" + getInputValue).then(function (data) {
                return data.json(); // reading response and looking for just the json
            }).then(function (jsonMovie) {

                jsonMovieResults = jsonMovie;
                
                for(i=0;i<jsonMovieResults.results.length;i++){
               var createPosters = document.createElement("img");
               var divTag = document.getElementById("moviePosters1")
               divTag.appendChild(createPosters);
               createPosters.setAttribute("class","posterImagesCreate");
               selectPoster=document.getElementsByClassName("posterImagesCreate")[i];
            //    var selectPosters = document.getElementsByClassName("posterImages")[i];
            if(jsonMovieResults.results[i].poster_path !== null) {
               selectPoster.src= "http://image.tmdb.org/t/p/w185//" + jsonMovieResults.results[i].poster_path;

            }

                }
                
                
            });
        })
    
    };

function clientValidation1(){

 var inputFirstName = document.getElementById("registerFirstName").value;

 var arrayFirstName = inputFirstName.split("");

 for (i=0; i < arrayFirstName.length;i++){

    var x = parseInt(arrayFirstName[i]);
   if(x === 0 ||x === 1 ||x === 2 ||x === 3 ||x === 4 ||x === 5 ||x === 6 ||x === 7 ||x === 8 ||x === 9){
        if(document.contains(document.getElementById("gifCheck1"))){
        var deletegif1 = document.getElementById("gifCheck1");
        deletegif1.parentNode.removeChild(deletegif1);
        }
        if(document.getElementById("registerText1") == null){
        var firstNameText = document.createElement("h4");
        var parent1 = document.getElementById("replaceText1");
        parent1.appendChild(firstNameText);
        firstNameText.setAttribute("id","registerText1")
        firstNameText.innerHTML = "Must not contain a number";
        firstNameText.style.color = "red";
    }
        
    }
    else{
       if(document.contains(document.getElementById("registerText1"))){
       var text = document.getElementById("registerText1");
       text.parentNode.removeChild(text);
       }
       else if(document.getElementById("gifCheck1") == null){
       var gifCheck = document.createElement("img");
       gifCheck.setAttribute("id","gifCheck1");
       var divRegister1 = document.getElementById("replaceText1");
       divRegister1.appendChild(gifCheck);
       gifCheck.src = "/images/check1.gif";
       }

    }
 }


    
}

function clientValidation2(){

    var inputFirstName = document.getElementById("registerLastName").value;
   
    var arrayFirstName = inputFirstName.split("");
   
    for (i=0; i < arrayFirstName.length;i++){
   
       var x = parseInt(arrayFirstName[i]);
      if(x === 0 ||x === 1 ||x === 2 ||x === 3 ||x === 4 ||x === 5 ||x === 6 ||x === 7 ||x === 8 ||x === 9){
           if(document.contains(document.getElementById("gifCheck2"))){
           var deletegif1 = document.getElementById("gifCheck2");
           deletegif1.parentNode.removeChild(deletegif1);
           }
           if(document.getElementById("registerText2") == null){
           var firstNameText = document.createElement("h4");
           var parent1 = document.getElementById("replaceText2");
           parent1.appendChild(firstNameText);
           firstNameText.setAttribute("id","registerText2")
           firstNameText.innerHTML = "Must not contain a number";
           firstNameText.style.color = "red";
       }
           
       }
       else{
          if(document.contains(document.getElementById("registerText2"))){
          var text = document.getElementById("registerText2");
          text.parentNode.removeChild(text);
          }
          else if(document.getElementById("gifCheck2") == null){
          var gifCheck = document.createElement("img");
          gifCheck.setAttribute("id","gifCheck2");
          var divRegister1 = document.getElementById("replaceText2");
          divRegister1.appendChild(gifCheck);
          gifCheck.src = "/images/check1.gif";
          }
   
       }
    }
   
   
       
   }

   function clientValidation3(){

    var inputEmail = document.getElementById("registerEmail").value;
    
    for (i=0; i < inputEmail.length;i++){
       
      if(inputEmail.indexOf("@") == -1 || inputEmail.indexOf(".") == -1){
           if(document.contains(document.getElementById("gifCheck3"))){
           var deletegif1 = document.getElementById("gifCheck3");
           deletegif1.parentNode.removeChild(deletegif1);
           }
           var x = document.getElementById("registerText3");
           x.parentNode.removeChild(x);
           if(document.getElementById("registerText3") == null){
           var firstNameText = document.createElement("h4");
           var parent1 = document.getElementById("replaceText3");
           parent1.appendChild(firstNameText);
           firstNameText.setAttribute("id","registerText3")
           firstNameText.innerHTML = "Not a Valid Email Address";
           firstNameText.style.color = "red";
       }
           
       }
       else{
          if(document.contains(document.getElementById("registerText3"))){
          var text = document.getElementById("registerText3");
          text.parentNode.removeChild(text);
          }
          else if(document.getElementById("gifCheck3") == null){
          var gifCheck = document.createElement("img");
          gifCheck.setAttribute("id","gifCheck3");
          var divRegister1 = document.getElementById("replaceText3");
          divRegister1.appendChild(gifCheck);
          gifCheck.src = "/images/check1.gif";
          }
   
       }
    
   
    }
       
   }

   function clientValidation4(){

    var inputUsername = document.getElementById("registerUsername").value;
    
    for (i=0; i < inputUsername.length;i++){
       
      if(inputUsername.length<5 || inputUsername.length>12){
           if(document.contains(document.getElementById("gifCheck4"))){
           var deletegif1 = document.getElementById("gifCheck4");
           deletegif1.parentNode.removeChild(deletegif1);
           }
           var x = document.getElementById("registerText4");
           x.parentNode.removeChild(x);
           if(document.getElementById("registerText4") == null){
           var firstNameText = document.createElement("h4");
           var parent1 = document.getElementById("replaceText4");
           parent1.appendChild(firstNameText);
           firstNameText.setAttribute("id","registerText4")
           firstNameText.innerHTML = "Min: 5 chars | Max: 12 chars";
           firstNameText.style.color = "red";
       }
           
       }
       else{
          if(document.contains(document.getElementById("registerText4"))){
          var text = document.getElementById("registerText4");
          text.parentNode.removeChild(text);
          }
          else if(document.getElementById("gifCheck4") == null){
          var gifCheck = document.createElement("img");
          gifCheck.setAttribute("id","gifCheck4");
          var divRegister1 = document.getElementById("replaceText4");
          divRegister1.appendChild(gifCheck);
          gifCheck.src = "/images/check1.gif";
          }
   
       }
    
   
    }
       
   }

   function clientValidation5(){

    var inputUsername = document.getElementById("registerPassword").value;
    confirmPasswordVal = inputUsername;
    
    for (i=0; i < inputUsername.length;i++){
       
      if(inputUsername.length<5 || inputUsername.length>12){
           if(document.contains(document.getElementById("gifCheck5"))){
           var deletegif1 = document.getElementById("gifCheck5");
           deletegif1.parentNode.removeChild(deletegif1);
           }
           var x = document.getElementById("registerText5");
           x.parentNode.removeChild(x);
           if(document.getElementById("registerText5") == null){
           var firstNameText = document.createElement("h4");
           var parent1 = document.getElementById("replaceText5");
           parent1.appendChild(firstNameText);
           firstNameText.setAttribute("id","registerText5")
           firstNameText.innerHTML = "Min: 5 chars | Max: 12 chars";
           firstNameText.style.color = "red";
       }
           
       }
       else{
          if(document.contains(document.getElementById("registerText5"))){
          var text = document.getElementById("registerText5");
          text.parentNode.removeChild(text);
          }
          else if(document.getElementById("gifCheck5") == null){
          var gifCheck = document.createElement("img");
          gifCheck.setAttribute("id","gifCheck5");
          var divRegister1 = document.getElementById("replaceText5");
          divRegister1.appendChild(gifCheck);
          gifCheck.src = "/images/check1.gif";
          }
   
       }
    
   
    }
       
   }

   function clientValidation6(){

    var inputUsername = document.getElementById("confirmPassword").value;
    
    for (i=0; i < inputUsername.length;i++){
       
      if(confirmPasswordVal != inputUsername){
           if(document.contains(document.getElementById("gifCheck6"))){
           var deletegif1 = document.getElementById("gifCheck6");
           deletegif1.parentNode.removeChild(deletegif1);
           }
           var x = document.getElementById("registerText6");
           x.parentNode.removeChild(x);
           if(document.getElementById("registerText6") == null){
           var firstNameText = document.createElement("h4");
           var parent1 = document.getElementById("replaceText6");
           parent1.appendChild(firstNameText);
           firstNameText.setAttribute("id","registerText6")
           firstNameText.innerHTML = "Passwords do not match";
           firstNameText.style.color = "red";
       }
           
       }
       else{
          if(document.contains(document.getElementById("registerText6"))){
          var text = document.getElementById("registerText6");
          text.parentNode.removeChild(text);
          }
          else if(document.getElementById("gifCheck6") == null){
          var gifCheck = document.createElement("img");
          gifCheck.setAttribute("id","gifCheck6");
          var divRegister1 = document.getElementById("replaceText6");
          divRegister1.appendChild(gifCheck);
          gifCheck.src = "/images/check1.gif";
          }
   
       }
    
   
    }
       
   }
