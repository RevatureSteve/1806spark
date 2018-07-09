

function getPeopleInSales() {
    var classp = document.getElementsByClassName('empName')[0];
    var classb = document.getElementsByClassName('empName')[2];
    var classc = document.getElementsByClassName('empName')[4];
    var classd = document.getElementsByClassName('empName')[5];
    var classes = [classp.textContent, classb.textContent, classc.textContent, classd.textContent]
    console.log(classes);
}



function getAnchorChildren() {
    var anchorChildren = document.getElementsByTagName("a");
    for (i = 0; i < anchorChildren.length; i++) {
        var ap = anchorChildren[i].childNodes;
        for (x = 0; x< ap.length; x++){
            if (ap[x].tagName == "SPAN"){
                console.log(ap[x].textContent);
            }
        }
        
    }
}








function getUSA() {
    var USA = document.getElementsByTagName("h1")[0];
    var spanUSA = USA.getElementsByTagName("span")[1];
    var finalvar = spanUSA.textContent;
    console.log(finalvar);

}

function ShowSkillsEvent() {
    var skill = document.getElementsByName("skills")[0];
    for (i = 0; i < skill.children.length; i++) {
        skill.children[i].addEventListener("click", alert("are you sure this is one of your skills?"));
        console.log(ShowSkillsEvent)
    }
}

