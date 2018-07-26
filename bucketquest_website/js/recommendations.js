var url = 'http://localhost:3001/recommendations'; // the url of the database?
var submissions = null; //declaring and initializing the variable (submissions)
callSubmissions();

function callSubmissions(){ //getting all submissions I have from the database
    fetch(url) //fetching the submissions from the URL
    .then((resp)=> { //after the fetch, do this...
        return resp.json(); // returning the json response
    })
    .then((data)=>{
        console.log(data);
        submissions = data;
        setSubmissions(submissions);
    })
} // data will print to screen, passed to submissions

function setSubmissions(s){
    console.log('setting submissions to page');
    console.log(s);
    var submissionsSection = document.getElementById('submissions');
    
    for(let x = 0;x < s.length; x++){
        let sDiv = document.createElement('div');
        sDiv.innerHTML = s[x].type + ": "+ s[x].submission; // s is the array of objects, x is an index
        // s[x]is the object in the array at the index: type
        // objects are key value pairs, so: objectname.keyname = value
        submissionsSection.appendChild(sDiv);
    }
}

document.getElementById("recommendationBtn").addEventListener("click",collectData)

function collectData(){ //collecting user data and putting it inside of the database
    let submission = document.getElementById("recsubmit").value; //the value of whatever is in the text box
    let selection = document.getElementsByName("type"); // represents an array of all the types
    let type = "" // initializing type to an empty string instead of undefined if no input
    
    for (var i = 0; i<selection.length; i++){ //going through the array of selections to find out
        if (selection[i].checked){// which selection was checked
            type = selection[i].value // type is defined as the value of the selection
        }
    }

    var data2 = { //initializing an object based off of recommendations-model
        "submission" : submission, // key value pairs from recommendations-model
        "type" : type
    }

    fetch(url,{ //fetching my database
        method: 'POST', // setting the method to POST in order to POST it inside of my database
        body: JSON.stringify(data2),// turns the data into JSON
        headers:{
            'Content-Type' : 'application/json'
        }
    }).then(data2 => data2.json()).then(q =>{
        console.log(q);
        alert('Thank you for your recommendation!');
    })

}