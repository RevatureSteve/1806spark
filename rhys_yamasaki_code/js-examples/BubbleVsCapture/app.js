
window.onload = function() {

    console.log('document ready!');
                                                                    // last argument is a boolean
                                                                    // for bubble vs capture
                                                                    // meaning do I want to invoke
                                                                    // event listeners on the way down (capture)
                                                                    // or on the way up (bubble)
    document.getElementById("outer").addEventListener('click', foo, false); // useCapture for true, false for bubbling
    document.getElementById("inner").addEventListener('click', foo, false);
    document.getElementById("innerMost").addEventListener('click', foo, false);

    function foo(event) {
        console.dir(this);
        console.log(event);
        event.stopPropagation();
    }


}