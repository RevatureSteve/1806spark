window.onload = function() {
    console.log('document ready!');
    document.getElementById('outter').addEventListener('click', foo, false ); 
    // last argument is a boolean for bubble vs capture
    // meaning, do i want to invoke event listeners on the way down(capture), or on the way up(bubble)
    //isCapture for true, false for bubble 
    document.getElementById('inner').addEventListener('click', foo, false);
    document.getElementById('innerMost').addEventListener('click', foo, false);
}

function foo(event){  // event object will always be passed
    console.dir( this);//this is the current object   //dir is for printing out the object that doesn't work nicely with log. like this keyword
    console.log(event)
    event.stopPropagation();
}