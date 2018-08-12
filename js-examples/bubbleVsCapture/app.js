window.onload = function(){
    console.log('document ready!');

    document.getElementById('outer').addEventListener('click', foo, false); //last argument is a bolean for bubble vs capture
    document.getElementById('inner').addEventListener('click', foo, false);        //meaning do I want to ivoke event listeners on the way 
        document.getElementById('innermost').addEventListener('click', foo, false); //down (capture) or the way up (bubble)
    //useCapture for true, false for bubble, this always reads all the way down, then back up the difference is when it activates the function
    //this.event.stop can stop from reading on the way up


}

function foo(event){
    console.log(this.id +' clicked');
    console.dir( this ); //to print a object that isn't working with console.log like this keyword
    console.log(event);
    event.stopPropagation();
}