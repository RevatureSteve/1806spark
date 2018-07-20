let adminUrl = "http://localhost:3000/login";
var nameList = null;
setUp();

function setUp() {
    fetch(adminUrl)
    .then(function(res) {
        res.json()
    })
    .then(function(names) {
        console.log(names);
        nameList = names;
        setNames(nameList);
    })

    }

    function setNames(nl) {
        console.log(nl);
        var nameSpace = document.getElementById('registered');
        for (let i = 0; i < nl.length; i++) {
            let newDiv = document.createElement('div');
            newDiv.innerHTML = nl.first_name + " " + nl.last_name;
            nameSpace.appendChild(newDiv);
        }
    }
