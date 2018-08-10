window.onload = function() {
    console.log("Document ready.");

    //Last argument is a boolean for bubble vs. capture 
    //meaning do I want to invoke evenet
   // listners on the way down(capture)? true
   // or on the way down(bubble)? false pefered so 
   //that you can stop propogating when you want.
    document.getElementById("out").addEventListener("click", foo, false); //use Capture
    document.getElementById("in").addEventListener("click", foo,false);
    document.getElementById("om").addEventListener("click", foo,false);

function foo (evenet)
 {

console.log( this.id + " clicked");
console.log(event);
event.stopPropagation();
console.dir( this ); // used to print an object 
 }
}