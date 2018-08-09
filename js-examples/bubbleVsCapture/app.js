window.onload = function(){
    console.log('document ready!');
    document.getElementById('outter').addEventListener('click', foo, false);
    document.getElementById('inner').addEventListener('click', foo, false);
    document.getElementById('innerMost').addEventListener('click', foo ,false);
}

function foo(){
    console.log(this.id + ' clicked');
    console.log(event);
    event.stopPropagation();
}