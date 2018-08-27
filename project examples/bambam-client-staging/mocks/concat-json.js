var jsonConcat = require('json-concat');

jsonConcat({
    src: "mocks/data",
    dest: "mocks/data.json",
    }, function(json){
        console.log(json);
    });

    