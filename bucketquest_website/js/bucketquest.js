//function loadstuff() {

window.onload = function lol(){
    console.log("lol")
}

function picChange(){
    
    document.getElementById("xpic").src= imgArray[Math.floor(Math.random() * 8)];
}


let imgArray = new Array();

imgArray[0] = new Image();
imgArray[0] = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRvHc-pkn3YszbRKHn5_4jR5RKpW35MdrByJt3pnq8etrdhKAXYJA";

imgArray[1] = new Image();
imgArray[1] = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQi8LF2RmJxVNE4FBz-EzL1vXdnKARJsgxuTH2XYjS_xX4khEK2";

imgArray[2] = new Image();
imgArray[2] = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMwtpHsn9GD-UtBUurczZymip97ni9M48-zYRgYTokIn-mpr3r4A";

imgArray[3] = new Image();
imgArray[3] = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT81zXWnQfpRzW3QyTR3fzrc35C70O1LZ8x38BudYfHCP9qEG-p";

imgArray[4] = new Image();
imgArray[4] = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1PdCEjZu8k0_AhyP3jBwyOA_mn8NfMsxOfYSYWD_aFZvoHZhO";

imgArray[5] = new Image();
imgArray[5] = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmTR1jwtVA6zuPxKc-hRB8EJ6l1pbbh2obz62oe2WeqDp9QKDGfw";

imgArray[6] = new Image();
imgArray[6] = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUE-Gn0eMEE7uF2nXYlOHFbuWcL0B-ADdmbBfB9Hf3T17yJyys9w";

imgArray[7] = new Image();
imgArray[7] = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8CZQVmmBcgPZWq5PEZTdVfSSFu10lptJP_G_z2bodXQlN06u8tA";


document.getElementById("xpic").addEventListener("click",picChange);






