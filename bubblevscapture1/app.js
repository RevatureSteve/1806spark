window.onload = function(){
    console.log("document is ready")
                                                                    // last argument is a boolean
                                                                    // for bubble vs capture
                                                                    // meaning do i want to invoke
                                                                    // event listener on the way down(capture)
                                                                    // or on the way up (bubble) 
                                                                    // if true or false isnt there still work but undefine
                                                                    // isCapture for true, and calse for bubble
    document.querySelector("#outter").addEventListener('click', foo, false );
    document.querySelector("#inner").addEventListener('click', foo, false);
    document.querySelector("#innerMost").addEventListener('click', foo, false );
}

function foo(event){
    // console.log( "outer");//
    console.dir(this); // to print a object that isnt working nicely with console.log like keyword
    console.log(event);
    event.stopPropagation();

}