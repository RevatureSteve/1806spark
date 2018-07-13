//defining all of the starting game objects
let games = [{
  name: "Anthem", 
  description: "Anthem is an upcoming online multiplayer action role-playing video game being developed by BioWare " +
    "and published by Electronic Arts. The game is slated for a worldwide release on February 22, 2019, for Microsoft Windows, PlayStation 4 and Xbox One. ",
  rating: 5
},
{
  name: "Fallout 76",
   description: "Fallout 76 is an upcoming online multiplayer action role-playing video game developed by Bethesda Game Studios and published by Bethesda Softworks. "
    + "It is the ninth game in the Fallout series and serves as a narrative prequel to the series.", 
    rating: 10
},
{ name: "Gears 5", 
description: "Called Gears 5 rather than Gears 'of War' 5" + 
"(for no other significant reason than that it's more streamlined and in line with what " + 
"fans are calling it) this new game in the series will have a female protagonist, Kait. " +
"Marcus Phoenix will still appear, but Kait will take the starring role as she takes her team " +
 "on a personal mission which will continue on from the emotional ending of Gears of War 4. ",
  rating: 8 },
{ name: "The Elder Scrolls VI", 
description: "The Elder Scrolls is an action role-playing open world video game series developed " + 
"by Bethesda Game Studios and published by Bethesda Softworks. " + 
"The Elder Scrolls games take place in the fictional world of Nirn, on the continent of Tamriel.", 
rating: 5 }];
//variables for DOM manipulation
let title;
let description;
let rating;
let img;
let pageImg;
let targetId;
let x;
let tables;
let headerRows;


window.onload = function () {
  title = [document.getElementById('displayTitle'), document.getElementById('displayTitle2'),
  document.getElementById('displayTitle3')];
  description = [document.getElementById('displayDescription'), document.getElementById('displayDescription2'),
  document.getElementById('displayDescription3')];
  img = [document.getElementById('displayContent'), document.getElementById('displayContent2'),
  document.getElementById('displayContent3')];
  tables = [document.getElementsByTagName('table')[1], document.getElementsByTagName('table')[2], 
  document.getElementsByTagName('table')[3]];
  headerRows = [document.getElementsByTagName('hr')[0], document.getElementsByTagName('hr')[2], document.getElementsByTagName('hr')[4]]
  console.log("app.js is loaded");
  var coll = document.getElementsByClassName("collapsible");
  var i;
  if (document.getElementById('index')) {
    tables[1].addEventListener('click', addPageContents);
    tables[2].addEventListener('click', addPageContents);
    tables[0].addEventListener('click', addPageContents);
  }

  if (document.getElementById("searchBtn")) {// checking to see if user is on database
    document.getElementById("searchBtn").addEventListener("click", dataBase);

  }

  for (i = 0; i < coll.length; i++) { //for loop for collapsing tabs
    coll[i].addEventListener("click", function () {
      this.classList.toggle("active");
      var content = this.nextElementSibling;
      if (content.style.display === "block") {
        content.style.display = "none";
      } else {
        content.style.display = "block";
      }
    });
  }
}//window.omload end
function dataBase() {
  let api_key = '0eb1509b588973f865ac18529f73b70807505ccc';
  let request = document.getElementById('number').value;
  let appName = 'Beck\'s App'
  //un-used vars for quick referance 
  fetch('http://www.giantbomb.com/api/game/3030-4725/?api_key=0eb1509b588973f865ac18529f73b70807505ccc').then(function (data) {
    return data.json();
  })
    .then(function (jsonResults) {
      game = jsonResults;
      console.log(game);
    })
}

function addPageContents() {
  pageImg = event.target.src;
  targetId = event.target.id;
  console.log('pageImg = ' + pageImg);
  x = parseInt(targetId);
  if (pageImg == undefined) {//if the user clicks on somthing that is not a image
    img[0].src = "";
    img[1].src = "";
    img[2].src = "";
    description[0].innerHTML = "";
    title[0].innerHTML = "";
    description[1].innerHTML = "";
    title[1].innerHTML = "";
    description[2].innerHTML = "";
    title[2].innerHTML = "";
  }
  //which table is the user clicking on
  else if(targetId < 4) {
    headerRows[0].scrollIntoView(true);
    img[0].src = pageImg;
    description[0].innerHTML = games[x].description;
    title[0].innerHTML = games[x].name;
  }
  else if(targetId > 3 && targetId < 8){
    headerRows[1].scrollIntoView(true);
    img[1].src = pageImg;
    description[1].innerHTML = games[x].description;
    title[1].innerHTML = games[x].name;
  }
  else if(targetId > 7){
    headerRows[2].scrollIntoView(true);
    img[2].src = pageImg;
    description[2].innerHTML = games[x].description;
    title[2].innerHTML = games[x].name;
  }
}
