let url = 'http://localhost:3003/homePath';

window.onload = function(){
    document.getElementById('uploadSub').addEventListener('click', load)
    document.getElementById('urlText').addEventListener('change', upload)

}
    function load() {
        let src = document.getElementById('urlText').value;
        let fileName = document.getElementById('fileName').value;
        let data = {"fileName": fileName,
                    "url": src,
    };
    fetch(url, {
        method:'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(data => data.json()).then(() => {
        alert('nice pic!');
    });
    }
    function upload(){
        let src = document.getElementById('urlText').value;
        document.getElementById('pic').src = src;
    }

var suggest = null
    suggestion();
function suggestion(){
    fetch(url).then((resp) => {
        return resp.json();
    }).then((data) => {
        console.log(data);
        suggest = data;
        display(suggest);
    })
}

function display(L){
    let posted = document.getElementById('posted')
    for (let i=0; i < L.length; i++){
        var img = document.createElement("img");
        img.src = L [i].url
        posted.appendChild(img)
    }
}