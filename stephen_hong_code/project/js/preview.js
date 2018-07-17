var url = 'http://localhost:3001/preview';
var codes = null;
callCode();

function callCode(){
    fetch(url)
    .then((resp) => {
        return resp.json();
    })
    .then((data)=> {
        console.log(data);
        codes = data;
        setCode(codes);
    })
}

function setCode(q){
    console.log('setting code to page');
    console.log(q);
    var preview = document.getElementById('previewcode');''
    
    for(let x = 0;x < q.length; x++){
        let a = document.createElement("body");
        a.innerHTML = q[x].html + "<style>" + q[x].css + "</style>" + "<script>" + q[x].js + "</script>";
        preview.innerHTML = a.innerHTML;
    }

    // Execute script
    var arr = preview.getElementsByTagName('script');
    for (var n = 0; n < arr.length; n++){
        eval(arr[n].innerHTML);
    }
}