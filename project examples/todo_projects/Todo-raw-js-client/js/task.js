/*
    CRUD for user's task
*/
function getTasks(userId){
    console.log('fetching user tasks');
    let url = `http://localhost:8085/TodoList-Restful-API/task/id?userId=${userId}`;
    fetch(url).then(data=> data ? data.json() : null).then(json => console.log(json));
}