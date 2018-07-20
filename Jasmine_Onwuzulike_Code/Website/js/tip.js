
ocument.getElementById('submit-tip').addEventListener("click", displayTip);



function displayTip() {
    let space = document.getElementById('tip');
    let tip = document.getElementById('advice').value;
    let author = document.getElementById('submitter').value;
    let oldTitle = document.getElementById('old').innerHTML = author + "submitted: "
    space.innerHTML = tip

}