// var quotes = [
// "Once a year, go someplace you've never been before -Dalai Lama",
// "I haven't been everywhere, but it's on my list -Susan Sontag",
// "Travel is Rebellion in its purest form",
// "Never get so busy living that you forget to live.",
// "It's better to see something once than to hear about it a thousand times."]

// document.getElementsByTagName("body")[0].onload = quote;

// function quote(){
//     var phrase = quotes[Math.floor(Math.random()*5)];
//     document.getElementById("quote").innerHTML = phrase;
// }

document.getElementById("login").addEventListener("click", login)

function login(){
    window.location = "profile.html"
}