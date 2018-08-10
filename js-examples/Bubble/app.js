window.onload = function() {
    console.log('document ready');
    document.getElementById('outter').addEventListener('click', foo, false);
    document.getElementById('inner').addEventListener('click', foo, false);
    document.getElementById('innerMost').addEventListener('click', foo, false);
    //the last arguement is a boolean for bubble vs capture
    //meaning do I want to invoke event listeners on the way down (capture)
    //or on the way up (bubble)
    //useCapture for true, false for bubble
    //THIS IS IQ!!
}

function foo() {
    console.dir(this);//'dir' is to print an object that is not working nicely with console.log like 'this' keyword
    console.log(event);
    event.stopPropagation();

}