export class User {
    uId: number;
    email: string;
    password: String;
    firstname: String;
    lastname: String;
    posId: number;

    constructor(uId: number, email: string, password: String, fname: String, lname: String, posId: number) {
        this.uId = uId;
        this.email = email;
        this.password = password;
        this.firstname = fname;
        this.lastname = lname;
        this.posId = posId;
    }

}
