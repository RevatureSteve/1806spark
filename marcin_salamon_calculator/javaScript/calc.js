console.log("javaScript js");
var keys = document.querySelectorAll(".btn");

var equation = "";
var number = "";

for(var i=0; i<keys.length; i++){
    keys[i].onclick = function(e){
        var input = document.querySelector("#output-box");
        var inputVal = input.innerHTML;
        var buttonVal = this.value;

        if(buttonVal == 'c'){
            input.innerHTML = "";
            equation = "";
            return;
        }

        if(buttonVal == "="){
            if (equation.length == 0){
                input.innerHTML = 0;
                return;
            }
            input.innerHTML = eval(equation);
            equation ="";
            number = "";
            return;
        }

        if(buttonVal == "+"||buttonVal == "-"||buttonVal=="/"||buttonVal=="*"){
            input.innerHTML = number;
            if (equation.length == 0){
                equation = 0;
            } 
            equation = equation+buttonVal;
            number = "";
            return;
        }

        
        number = number+buttonVal;
        equation = equation+buttonVal;
        input.innerHTML = number;
    }
}