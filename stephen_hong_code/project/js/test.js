function compile() {

    var html = document.getElementById("html");
    var css = document.getElementById("css");
    var js = document.getElementById("js");
    var code = document.getElementById("code");

    document.body.onkeyup = function() {
      code.innerHTML = 
        html.value +
          "<style>" +
          css.value +
          "</style>" +
          "<script>" +
          js.value +
          "</script>"
      ;
    };
  }

  compile();