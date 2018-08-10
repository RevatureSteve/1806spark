window.onload = function(){
    console.log('document is ready');
    document.getElementById('outter').addEventListener('click', foo, false)
    document.getElementById('inner').addEventListener('click', foo)
    document.getElementById('innermost').addEventListener('click', foo, false)
}
function foo(event){
    console.dir(this);
    console.log(event);
    event.stopPropagation();
}