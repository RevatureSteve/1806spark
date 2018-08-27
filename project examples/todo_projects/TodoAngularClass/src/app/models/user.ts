export class User {
    userId: number;
    username: string;
    password: string;
    userTasks: object;

    constructor(userId: number, username: string,
        password: string, userTasks: []) { }
 }
