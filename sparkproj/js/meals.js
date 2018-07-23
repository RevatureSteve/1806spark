var url = 'http://localhost:3000/mealsSaved';
var meals = null;
callMeals();

function callMeals(){
    fetch(url)
    .then((resp) => {
        return resp.json();
    })
    .then((data)=> {
        console.log(data);
        meals = data;
        setMeals(meals);
    })
}


function setMeals(meal){
    console.log('Sending Recipe to Page');
    console.log(meal);
    var meals = document.getElementById('meals');
    
    for(let x = 0;x < meal.length; x++){
        let mealDiv = document.createElement('li');
        
        mealDiv.innerHTML = "Name: " + meal[x].name+ "<br>"
                            +" URL: " + meal[x].url+ "<br>"
                            + "Rating: " + meal[x].rating+ "<br>"
                            + " Cooktime: " + meal[x].cooktime+ "<br>"
                            + " Servings: " + meal[x].servings+ "<br>"
                            + " Ingredients: " + meal[x].ingredients+ "<hr>";
        meals.appendChild(mealDiv);
        
    }
    
}
