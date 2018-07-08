// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);

var john = new Person("John", 30);

function Person(name, age){
    return (name + " " + age);
}

