var previewUrl = 'http://localhost:3001/preview';
var codes = null;
callCode();

function callCode(){
    fetch(previewUrl)
    .then((resp) => {
        return resp.json();
    })
    .then((previewData)=> {
        console.log(previewData);
        codes = previewData;
        setCode(codes);
    })
}

function setCode(c){
    console.log('setting code to page');
    console.log(c);
    var preview = document.getElementById('previewcode');''
    
    for(let x = 0;x < c.length; x++){
        let a = document.createElement("body");
        a.innerHTML = c[x].html + "<style>" + c[x].css + "</style>" + "<script>" + c[x].js + "</script>";
        preview.innerHTML = a.innerHTML;
    }

    // Execute script
    var arr = preview.getElementsByTagName('script');
    for (var n = 0; n < arr.length; n++){
        eval(arr[n].innerHTML);
    }
}