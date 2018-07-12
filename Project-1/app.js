
 let games = [{name: "Anthem", description: "Anthem is an upcoming online multiplayer action role-playing video game being developed by BioWare " + 
 "and published by Electronic Arts. The game is slated for a worldwide release on February 22, 2019, for Microsoft Windows, PlayStation 4 and Xbox One.",
  rating:5}, 
 {name: "Fallout 76", description: "Fallout 76 is an upcoming online multiplayer action role-playing video game developed by Bethesda Game Studios and published by Bethesda Softworks." 
 + "It is the ninth game in the Fallout series and serves as a narrative prequel to the series.", rating:10},
 {name:"Gears of War 5", description: "gears", rating:8},
  {name:"The Elder Scrolls VI", description:"esv", rating:5}];
  let title;
  let description;
  let rating;
  let img;
  let pageImg;
  let targetId;
  let x;
window.onload = function(){
  title = document.getElementById('displayTitle');
  description = document.getElementById('displayDescription');
  img = document.getElementById('displayContent');
  console.log("app.js is loaded");
  var coll = document.getElementsByClassName("collapsible");
  var i;
  if(document.getElementById('index')){
    document.getElementById('tableImages1').addEventListener('click', addPageContents);
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
  targetId = event.target.id;
  console.log('pageImg = ' + pageImg);
  img.src = pageImg;
  x = parseInt(targetId);
  if(pageImg == undefined){
    description.innerHTML = "";
    title.innerHTML = "";
  }
  else{
    description.innerHTML = games[x].description;
    title.innerHTML = games[x].name;
  }
}
