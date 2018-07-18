var url = "http://localhost:3000/Back"
var fitness = null;
callFitness();

function callFitness(){
    fetch(url)
    .then((resp) => {
        return resp.json();
    })
    .then((data) => {
        console.log(data);
        fitness = data;
        setFitness(fitness);
    })
}

function setFitness(f){
    console.log('setting submission review onto the page');
    console.log(f);
    var submissionSection = document.getElementById('post');

    for(let x = 0; x < f.length; x++){
        let fDiv = document.createElement('li');
        fDiv.innerHTML = "Pros: " + f[x].pro + "<br>" + " Cons: " + f[x].con + "<br>"
                    + " Rating: " + f[x].rating + "<br>" +
                    "--------------------------------------";
        submissionSection.appendChild(fDiv);
    }
}