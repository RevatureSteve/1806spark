window.onload = () => {
    console.log('document ready!');
    // Last argument is a boolean for bubble vs capture
    document.getElementById('outer').addEventListener('click',foo,true);
    document.getElementById('inner').addEventListener('click',foo, true);
    document.getElementById('innerMost').addEventListener('click',foo, true);
}

function foo(){
    console.log(this.id + ' clicked');
}