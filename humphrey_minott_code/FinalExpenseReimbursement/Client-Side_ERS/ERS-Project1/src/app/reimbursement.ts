import { EmployeeNavComponent } from './employee-nav/employee-nav.component';


export class Reimbursement{

    rId: number;
	requestTypeId: number; 
	submissionUId: number; //Aka the person who submitted it 
	resolvedUId: number; //Aka the person who resolved it
	requestStatusId: number;
	amount: number;
	description: string;
	image: Blob;
	timeSubmission: string;
	fname: string;
	lname: string;
	rq_type: string;
    requestStatus: string;
	email:string;
	password:string;
	position_Id:number;

    constructor(rId: number, requestTypeId: number,submissionUId: number,
        resolvedUId: number, requestStatusId: number, amount: number,
        description: string, image: Blob, timeSubmission: string,uId:number, email:string, password:string,
        fname: string, lname: string, rq_type: string,requestStatus: string,position_Id:number){

        this.rId = rId;
        this.requestTypeId = requestTypeId;
        this.submissionUId = submissionUId;
        this.resolvedUId = resolvedUId;
        this.requestStatusId = requestStatusId;
        this.amount = amount;
        this.description = description;
        this.image = image;
        this.timeSubmission = timeSubmission;
        this.fname = fname;
        this.lname = lname;
        this.rq_type = rq_type;
        this.requestStatus = requestStatus
        this.position_Id=position_Id
        this.password=password
        this.email=email;
    }






}