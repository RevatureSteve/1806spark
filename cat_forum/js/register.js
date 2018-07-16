var pw = document.getElementById("pw");
var pw2 = document.getElementById("pw2");
function pwMatch() {
    if (pw === pw2) {
        // text="passwords match"
        console.log("match")
    } else {
        // text="passwords don't match"
        console.log("don't match")
    }
}

function minReq() {
    if (pw.length<8) {
        console.log("needs to be at least 8 characters long")
    } else {
        console.log("good enough")
    }
}

function specCharac() {
    if (
}

