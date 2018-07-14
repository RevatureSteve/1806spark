function myFunction() {
    var popup = document.getElementById("myPopup");
    popup.classList.toggle("show");
    
    if (popup.paused){ 
        popup.play(); 
        }
      else{ 
        popup.pause();
        }
     
    }