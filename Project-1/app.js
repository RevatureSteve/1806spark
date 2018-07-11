

 var pageImg;
window.onload = function(){
  console.log("app.js is loaded");
  var coll = document.getElementsByClassName("collapsible");
  var i;
  if(document.getElementById('index')){
    document.getElementById('tableImages').addEventListener('click', addPageContents);
  }
  
  if(document.getElementById("searchBtn")){
    document.getElementById("searchBtn").addEventListener("click", dataBase);
    
  }
  
  for (i = 0; i < coll.length; i++) {
    coll[i].addEventListener("click", function() {
      this.classList.toggle("active");
      var content = this.nextElementSibling;
      if (content.style.display === "block") {
        content.style.display = "none";
      } else {
        content.style.display = "block";
      }
    });
  }
}
function dataBase(){
  let api_key = '0eb1509b588973f865ac18529f73b70807505ccc';
  let request = document.getElementById('number').value;
  let appName = 'Beck\'s App'
  fetch('http://www.giantbomb.com/api/game/3030-4725/?api_key=0eb1509b588973f865ac18529f73b70807505ccc').then(function (data){
    return data.json();
  })
  .then(function(jsonResults){
    game = jsonResults;
    console.log(game);
  })
}

function addPageContents(){
  pageImg = event.target.src;
  console.log('pageImg = ' + pageImg);
}
