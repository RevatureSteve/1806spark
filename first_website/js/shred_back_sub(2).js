//Clientside Javascript for Shredding back submission pag

function delayRedirect(){
    document.getElementById('delayMsg').innerHTML =
     'Thank you for your submission! You\ll be redirected to the previous page in <span id="countDown">3</span> seconds...';
    var count = 3;
    setInterval(function(){
        count--;
        document.getElementById('countDown').innerHTML = count;
        if (count == 0) {
            window.location.href = "/pages/Back.html"; 
        }
    },1000);
}


// once the form has been submitted, the user shall be 
// redirected to a new page!
