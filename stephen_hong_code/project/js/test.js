// document.getElementById("ok").addEventListener("click", preview);

// function preview() {
//     window.open("test2.html", "_blank");
// }

document.getElementById("ok").addEventListener("click", okay);

function okay() {
    var html = document.getElementById("html");
    var css = document.getElementById("css");
    var js = document.getElementById("js");
    var code = document.getElementById("code").contentWindow.document;

    // Store
    // localStorage.setItem(html1, html.value);
    // Retrieve
    // document.getElementById("result").innerHTML = localStorage.getItem("lastname");

    code.open();
    code.writeln(
        html.value +
        "<style>" +
        css.value +
        "</style>" +
        "<script>" +
        js.value +
        "</script>"
    );
    code.close();

    document.getElementById("code").style.display = "block";
};

// To dynamically see changes to the code
/*
function compile() {

    var html = document.getElementById("html");
    var css = document.getElementById("css");
    var js = document.getElementById("js");
    var code = document.getElementById("code").contentWindow.document;

    document.body.onkeyup = function() {
      code.open();
      code.writeln(
        html.value +
          "<style>" +
          css.value +
          "</style>" +
          "<script>" +
          js.value +
          "</script>"
      );
      code.close();
    };
  }

  compile();
*/