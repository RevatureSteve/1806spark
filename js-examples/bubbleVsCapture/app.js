<<<<<<< HEAD
<<<<<<< HEAD
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
=======
window.onload =function(){
    console.log('document ready!');
                                                                    // last argument is a boolean
                                                                    // for  bubble vs capture
                                                                    // meaning do I want to invoke
                                                                    // event listeners on the way down (capture)
                                                                    // or on the way up (bubble)
    document.getElementById('outter').addEventListener('click', foo); // isCapture for true, false for bubble
    document.getElementById('inner').addEventListener('click', foo, false);
    document.getElementById('innerMost').addEventListener('click', foo, false);
}

function foo(event){
    console.dir( this ); // to print a object that isn't working nicely with console.log like this keyword
    console.log(event);
    event.stopPropagation();

>>>>>>> 96a3cef7a318d158b57fa6b631d5de2e88dffb70
=======
window.onload = function(){
    console.log("document ready!");
    //last argument is a boolean for bubble vs capture, meaning do I want to invoke event listeners on the way down (capture) or on the way up (bubble)
    document.getElementById("outter").addEventListener("click", foo, false); //isCapture for true, false for bubble
    document.getElementById("inner").addEventListener("click", foo,false);
    document.getElementById("innerMost").addEventListener("click", foo,true);
}

function foo(event){
    console.dir(this); //to print a object that isn't working nicely with console.log like this keyword
    console.log(this.id + " clicked");
    event.stopPropagation();
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
}