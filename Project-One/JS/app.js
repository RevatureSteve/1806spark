


window.onload = function(){
    console.log("app.js is loaded in...")
    
    let pro = document.getElementById('profile-info-btn');
    let sub = document.getElementById('submit-reim-btn');
    let pend = document.getElementById('pending-reim-btn');
    let resolved = document.getElementById('resolved-riem-btn');


    pro.addEventListener('click', activeBtn);
   
    sub.addEventListener('click', activeBtn);
   
    pend.addEventListener('click', activeBtn);
   
    resolved.addEventListener('click', activeBtn);
}

function activeBtn(){
    let pro = document.getElementById('profile-info-btn');
    let sub = document.getElementById('submit-reim-btn');
    let pend = document.getElementById('pending-reim-btn');
    let resolved = document.getElementById('resolved-riem-btn');
    
    switch (event.target.id) {
        case "profile-info-btn":
        event.target.style.backgroundColor = "yellow";
        event.target.style.fontSize = "97%";
        sub.style.backgroundColor = "aliceblue";
        sub.style.fontSize = "90%";
        pend.style.backgroundColor = "aliceblue";
        pend.style.fontSize = "90%";;
        resolved.style.backgroundColor = "aliceblue";
        resolved.style.fontSize = "90%";
       
            break;
        case "submit-reim-btn":
        event.target.style.backgroundColor = "yellow";
        event.target.style.fontSize = "97%";
        pro.style.backgroundColor = "aliceblue";
        pro.style.fontSize = "90%";
        pend.style.backgroundColor = "aliceblue";
        pend.style.fontSize = "90%";
        resolved.style.backgroundColor = "aliceblue";
        resolved.style.fontSize = "90%";
            break;
        case "pending-reim-btn":
        event.target.style.backgroundColor = "yellow";
        event.target.style.fontSize = "97%";
        sub.style.backgroundColor = "aliceblue";
        sub.style.fontSize = "90%";
        pro.style.backgroundColor = "aliceblue";
        pro.style.fontSize = "90%";
        resolved.style.backgroundColor = "aliceblue";
        resolved.style.fontSize = "90%";
            break;
        case "resolved-riem-btn":
        event.target.style.backgroundColor = "yellow";
        event.target.style.fontSize = "97%";
        sub.style.backgroundColor = "aliceblue";
        sub.style.fontSize = "90%";
        pend.style.backgroundColor = "aliceblue";
        pend.style.fontSize = "90%";
        pro.style.backgroundColor = "aliceblue";
        pro.style.fontSize = "90%";
            break;
    
        default:
            break;
    }
}