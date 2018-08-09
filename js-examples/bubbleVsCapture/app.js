window.onload = function(){
    console.log('document ready')                                   // last argument is a boolean
                                                                    // for bubble vs capture
                                                                    // meaning do I want to invoke
                                                                    // event listeners on the way down (capture)
                                                                    // or on the way up (bubble)
    document.getElementById('outter').addEventListener('click', foo, false); //isCapture for true, false for bubble
    document.getElementById('inner').addEventListener('click', foo), false;
    document.getElementById('innerMost').addEventListener('click', foo, false);
}

function foo(){
    console.dir(this); // to print an object that isn't working nicely with console.log like this keyworded
    console.log(event);
    event.stopPropagation();
}