
window.onload = function(){
    console.log("document ready")
                                                                //Last argument is a boolean for bubble vs. Capture
                                                                //meaning do I want to invoke event listeners, on the way done (capture)
                                                                // or on the way up (bubble)
    document.getElementById("outter").addEventListener("click",foo,false); //last argument is useCapture for true, false for bubble
    document.getElementById("inner").addEventListener("click",foo,false);
    document.getElementById("innerMost").addEventListener("click",foo,false);
}


function foo(event){
    console.dir(this); // to print a object that isn't workng niclely with the console.log like 'this' keyword
    console.log(event);
    event.stopPropagation();
}
