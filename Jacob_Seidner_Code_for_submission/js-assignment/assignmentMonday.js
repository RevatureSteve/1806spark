console.log("Part 1")
console.log("1. Create a function named createRandomList that")
console.log("uses a for loop to create an array containing 10 random")
console.log("numbers from 1 to 100 (use the JavaScript Math object to get a random number.)")
console.log("The function should return that array.")
function createRandomList() {
    RandomList = [];
    for (let i =0; i<10; i++)
        {RandomList[i] = Math.floor((Math.random() * 100) + 1)};
    return RandomList};

console.log(" ")
console.log("2. Call the createRandomList function and store")
console.log("the results in a variable named myRandomList.")

let myRandomList = createRandomList()

console.log(" ")
console.log("3. Use a for loop to access each element in the loop. Each ")
console.log("time through the loop log a message to the console that looks something like this:")
console.log("Item 0 in the array is 48")
console.log("When you're done you should have output 10 lines to the console -- one for each element. ")

for (let i =0; i<10; i++)
        {console.log(myRandomList[i])};