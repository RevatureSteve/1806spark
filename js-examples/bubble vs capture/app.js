window.onload = function(){
    console.log('document read');
                                                                    //last argument is a boolean
                                                                    //for bubble vs capture
                                                                    //meaning do I want to invoke
                                                                    //event listeners on the way down (capture)
                                                                    //or on the way up(bubble)
    document.getElementById('outter').addEventListener('click', foo, false); //isCapture for true, false, for bubble
    document.getElementById('Inner').addEventListener('click', foo, false);
    document.getElementById('Innermost').addEventListener('click', foo, false);
}

function foo(event){
    console.dir(this); //to print a object that isn't working nicely with console.log like this keyword
    console.log(event);
    event.stopPropagation();
}