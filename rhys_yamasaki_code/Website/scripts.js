
// loads movie information to the page after all files get read

let newDate = new Date();
newDate.setDate(newDate.getDate());
let currentDateString = ( newDate.getFullYear() + '-'
+ ('0' + (newDate.getMonth() + 1)).slice(-2) + '-'
+    ('0' + newDate.getDate()).slice(-2));
let previousMonthDateString = (newDate.getFullYear() + '-'
+ ('0' + (newDate.getMonth())).slice(-2) + '-'
+    ('0' + newDate.getDate()).slice(-2));


window.onload = () => {
    let movieRow = document.getElementsByClassName('movieColumn');
    fetch('https://api.themoviedb.org/3/discover/movie?api_key=0c204b4eaedfebc5b97ce328217f531b&' +
    'language=en-US&region=US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&primary_release_date.gte=' + 
    previousMonthDateString + '&primary_release_date.lte=' + currentDateString).then(data => {
         return data.json();
     })
     .then(json => {
         console.log(json);
     });
}