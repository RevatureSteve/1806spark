document.getElementById("edit").addEventListener("click", edit);
document.getElementById("save").addEventListener("click", save);

function edit(){
    var input = document.getElementsByClassName("profile_input");
    for (var i = 0; i < input.length; i++){
        input[i].readOnly = false;
        input[i].style.backgroundColor = "white";
    }
    document.getElementById("edit").style.display = "none";
    document.getElementById("save").style.visibility = "visible";
}

function save(){
    var input = document.getElementsByClassName("profile_input");
    for (var i = 0; i < input.length; i++){
        input[i].readOnly = true;
        input[i].style.backgroundColor = "rgb(228, 228, 228)";
    }
    document.getElementById("edit").style.display = "inline";
    document.getElementById("save").style.visibility = "hidden";
}