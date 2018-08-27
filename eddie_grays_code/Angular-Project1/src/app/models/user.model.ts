export class User {
    uId: number;
    email: string;
    password: String;
    fname: String;
    lname: String;
    posId: number;

    constructor(uId: number, email: string, password: String, fname: String, lname: String, posId: number) {
        this.uId = uId;
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.posId = posId;
    }

}
