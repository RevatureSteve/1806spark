    window.onload = function(){
        console.log('loading the header nav bar page has loaded')
        
    }
    
    function loadNavBar(){
        console.log('loading nav bar')
    let navbar=document.getElementById('headernavDiv');
        fetch('pages/header.html').then((resp)=>{
            console.log(resp + "hahahah");
            nav = resp;
            return resp.text(); //getting html not json
          })  .then((text)=>{;
            navbar.innerHTML = text;
          })
    }
