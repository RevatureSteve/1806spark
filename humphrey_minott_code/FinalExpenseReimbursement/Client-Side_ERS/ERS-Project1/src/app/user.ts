
export class User{
    uId: number;
	email: string;
	password: string;
	fname: string;
	lname: string;
    positionId: number;
    employeeReimbursements: object;
    
    constructor(uId: number, email: string, password: string,
        fname: string, lname: string, positionId: number,
        employeeReimbursements: object){
 
        this.uId = uId;
        this.email = email;
        this.password = password;
        this.fname = fname;
        this. lname = lname;
        this.positionId = positionId;
        this.employeeReimbursements = employeeReimbursements;
        }
}