var url = 'http://localhost:3000/feedback';
var feedback = null;
callFeedback();

function callFeedback(){
    fetch(url)
    .then((resp) => {
        return resp.json();
    })
    .then((data)=> {
        console.log(data);
        feedback = data;
        setFeedback(feedback);
    })
}

function setFeedback(f){
    console.log('setting feedback to page');
    console.log(f);
    var feedbackSection = document.getElementById('feedback');
    
    for(let x = 0;x < f.length; x++){
        let fDiv = document.createElement('div');
        fDiv.innerHTML = "FB: " + f[x].feedback;
        feedbackSection.appendChild(fDiv);
    }
}

document.getElementById('feedbackBtn').addEventListener('click', newFeedback);
function newFeedback(){
    let newFeedbackStatus = document.getElementById('newFeedbackStatus');
    let feedback= document.getElementById('feedbackInput').value;
    // Post feeb!
    let feeb = {
        "feedback": feedback
    }

    fetch(url, {
        method: 'POST', // or 'PUT'
        body: JSON.stringify(feeb), // feeb can be `string` or {object}! Must be converted to JSON
        headers:{
          'Content-Type': 'application/json'
        }
    }).then(feeb=> feeb.json()).then(f => {
            console.log(f);
        newFeedbackStatus.innerHTML = f.question;
    });
    window.location.reload()
}