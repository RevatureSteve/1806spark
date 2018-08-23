export class User {
    userId: number;
    username: string;
    password: string;
    userTasks: [];

    constructor (userId: number, username: string, password: string, userTasks: []) { }
}