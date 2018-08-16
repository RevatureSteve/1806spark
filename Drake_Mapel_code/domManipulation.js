/* function getUSA() {
    document.getElementsByName("")
} */

function getPeopleInSales() {
    var td = document.getElementsByTagName("TD");
    var i = 0;
    while ( i < td.length ) {
        if ( td[i].innerHTML == "Sales") {
            console.log( td[i-1].innerHTML );
            i++;
        } else i++;
    }
}

// **********************************************

function getAnchorChildren() {
    var anchor = document.getElementsByTagName("A");
    var i = 0;
    while ( i < anchor.length ) {
        if ( anchor[i].children.length > 0 && anchor[i].firstElementChild.tagName == "SPAN") {
            console.log( anchor[i].firstElementChild.innerHTML );
            i++;
        } else i++;
    }
}

// *********************************************

function getCustomAttribute() {
    var query = document.querySelectorAll("[data-customAttr]");
    var i = 0;
    while ( i < query.length ) {
        console.log( query[i].getAttribute("data-customAttr") + " : " + query[i].tagName );
        i++;
    }
}

// *********************************************

var emp = document.getElementsByClassName("empName");

for ( let i = 0; i < emp.length; i++ ) {
    emp[i].addEventListener("mouseenter", function() { toggleVis(i); });
}

function toggleVis(N) {
    if ( emp[N].style.color == "transparent" ) {
        emp[N].style.color = "initial";
    } else emp[N].style.color = "transparent";
}