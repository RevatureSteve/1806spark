window.onload = () => {
    console.log('document ready!');
    // Last argument is a boolean for bubble vs capture
    document.getElementById('outer').addEventListener('click',foo);
    document.getElementById('inner').addEventListener('click',foo);
    document.getElementById('innerMost').addEventListener('click',foo);
}

function foo(event){
    console.dir(event);
    console.log(event);
    event.stopPropagation();
}