let localhostURL = "http://localhost:3000/submit"
//"http://localhost:3000/travel";

window.onload = function(){

    
    //this to put comment from data base
var allComments = null;
callComments();}


function callComments() {
    fetch(localhostURL)
    .then((resp) => {
        return resp.json();
    }) 
    .then((data) => {
    console.log(data);
    allComments = data;
    printComment(allComments)
    })
}


function printComment(modalModal) {
    console.log('setting question to page');
    console.log(modalModal);
    var commentSection = document.getElementById('modalModal');

    for( x=0; modalModal.length; x++) {
        let modalModalDiv = document.createElement('div');
        modalModalDiv.innerHTML = modalModal[x].author + ":" + modalModal[x].comment
        commentSection.appendChild(modalModalDiv);
    }

}
