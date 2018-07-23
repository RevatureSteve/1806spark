
    console.log("meals.js is ready")
    document.getElementById("mealBtn").addEventListener('click',getMeal);
    document.getElementById("nextBtn").addEventListener('click',nextMeal);
    document.getElementById("lastBtn").addEventListener('click',lastMeal);
    document.getElementById("moreBtn").addEventListener('click',moreMeal);
    document.getElementById("saveBtn").addEventListener('click',saveMeal);
    
let urla = 'http://localhost:3000/mealsSaved'


let meal = null;
let i = 0


function getMeal() {
    console.log('Get Meal');

    let mealSearch = document.getElementById('mealSearch').value.toLowerCase();

    let searchString = 'https://api.yummly.com/v1/api/recipes?_app_id=d2b08497&_app_key=cb8c1dfb48e25229ddf5e8f768297ada&q=';
    let dietString = "&allowedDiet[]=";
    let cuisineString = "&allowedCuisine[]=cuisine^cuisine-";
    let courseString = "&allowedCourse[]=course^course-";
    let excludeString ="&excludedIngredient[]=";
    let allowString ="&allowedIngredient[]=";

    let getCourse = document.getElementById('mealCourse').value;
    let getDiet = document.getElementById('mealDiet').value;
    let getCuisine = document.getElementById('mealCuisine').value;
    let ingredientsAllow = document.getElementById('ingredientsAllow').value;
    let ingredientsExclude = document.getElementById('ingredientsExclude').value;

    let courseSearch = (courseString+getCourse);
    let dietSearch = (dietString + getDiet);
    let cuisineSearch = (cuisineString + getCuisine);
    let allowSearch = (allowString+ingredientsAllow);
    let excludeSearch = (excludeString+ingredientsExclude);
    let searchSearch = (searchString+ mealSearch +
                        courseSearch + ingredientsAllow +
                        ingredientsExclude + dietSearch + cuisineSearch)
    

    let mealName = document.getElementById('mealName');
    let mealPic = document.getElementById('mealPic');
    let mealIngredients = document.getElementById('mealIngredients');
    let rating = document.getElementById('rating');
    let mealID = document.getElementById('mealID');
    
        console.log('You searched for...' + mealSearch);
        mealName.innerHTML = "Loading Selection"
        mealPic.src = "https://i.stack.imgur.com/ZupHq.gif"


        fetch(searchSearch)
             .then ( function (data){
                 return data.json(); 
        })
        .then( function(jsonMeal){
            meal = jsonMeal;
            let i = 0
            mealName.innerHTML        = meal.matches[i].recipeName;
            rating.innerHTML          = meal.matches[i].rating;
            mealPic.src               = meal.matches[i].imageUrlsBySize[90].replace("s90-c","s250-c");
            mealIngredients.innerHTML = meal.matches[i].ingredients;
            mealID.innerHTML          = meal.matches[i].id;
            
        });

    } 


    function nextMeal(){
        var length = meal.matches.length;
        if(i > length-1){alert("I'm sorry, you must subscribe to see more than 10 recipes!")}
        i=i+1
        mealName.innerHTML        = meal.matches[i].recipeName;
        rating.innerHTML          = meal.matches[i].rating;
        mealPic.src               = meal.matches[i].imageUrlsBySize[90].replace("s90-c","s250-c");
        mealIngredients.innerHTML = meal.matches[i].ingredients;
        mealID.innerHTML          = meal.matches[i].id;
    }
    function lastMeal(){
        var matches = meal.matches[i];
        if(i < length-1){alert("Beginning of recipe search query.")}
        i = i-1;
        mealName.innerHTML        = meal.matches[i].recipeName;
        rating.innerHTML          = meal.matches[i].rating;
        mealPic.src               = meal.matches[i].imageUrlsBySize[90].replace("s90-c","s250-c");
        mealIngredients.innerHTML = meal.matches[i].ingredients;
        mealID.innerHTML          = meal.matches[i].id;

        

    }

function moreMeal (){
    var id = document.getElementById('mealID').innerHTML;
    let mealName = document.getElementById('mealName');
    let mealPic = document.getElementById('mealPic');
    let mealIngredients = document.getElementById('mealIngredients');
    let rating = document.getElementById('rating');
    let URL = document.getElementById('URL');
    let mealID = document.getElementById('mealID');
    let cooktime = document.getElementById('cooktime');
    
fetch('https://api.yummly.com/v1/api/recipe/'+ mealID.innerText +'?_app_id=d2b08497&_app_key=cb8c1dfb48e25229ddf5e8f768297ada').then(function(data){
    return data.json();
})
.then( function(jsonMealMore){
    mealMore = jsonMealMore;
    
    nameDetails.value = mealMore.name;
    mealIngredientsShow.value = mealMore.ingredientLines;
    mealIDShow.innerHTML = mealMore.attribution.url;
    ratingShow.value = mealMore.rating;
    cooktimeShow.value = mealMore.totalTime;
    servingsShow.value = mealMore.numberOfServings;
})
}

function saveMeal(){
    let name = nameDetails.value;
    let url = mealIDShow.innerHTML;
    let rating = ratingShow.value;
    let cooktime = cooktimeShow.value;
    let servings = servingsShow.value;
    let ingredients = mealIngredientsShow.value;

let data = {

    "name": name,
    "url": url,
    "rating": rating,
    "cooktime": cooktime,
    "servings": servings,
    "ingredients": ingredients
}

fetch(urla, {
method: 'POST',
body: JSON.stringify(data),
headers:{
    'Content-Type': 'application/json'
}
}).then(data=> data.json()).then(meals =>{
        console.log(meals);
    mealSaveStatus.innerHTML = meals.name + " has been saved to the database!"
})

}

