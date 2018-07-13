// contains the main functions for the website
window.onload = () => {
    
}

// Changes page color theme to green
var changeToGreen = function(){
    changeClasses("color-main","color-green");
    changeClasses("color-main-dark", 'color-green-dark');
    changeClasses("color-main-light", 'color-green-light');
    changeClasses("color-red", 'color-green');
    changeClasses("color-red-dark", 'color-green-dark');
    changeClasses("color-red-light", 'color-green-light');
}

var changeToRed = function(){
    changeClasses("color-main","color-red");
    changeClasses("color-main-dark", 'color-red-dark');
    changeClasses("color-main-light", 'color-red-light');
    changeClasses("color-green", 'color-red');
    changeClasses("color-green-dark", 'color-red-dark');
    changeClasses("color-green-light", 'color-red-light');
}

// Changes all elements with initClass to endClass
var changeClasses = function(initClass, endClass){
    let initClassList = document.getElementsByClassName(initClass);
    for (let i = initClassList.length-1; i >= 0; i--){
        let node = initClassList[i];
        node.classList.remove(initClass);
        node.classList.add(endClass);
    }
}