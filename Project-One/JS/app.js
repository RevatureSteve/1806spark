window.onload = function(){
    console.log("app.js is loaded in...")
    document.getElementById('profile-info-btn').addEventListener('click', activeBtn);
}

function activeBtn(){
    console.log(event.target)
    event.target.document.getElementById('trending').style.color = "orange";
}