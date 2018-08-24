export class Reimbursement {
    rId : number;
	amount : number;
	rDescription : string;
	timeSubmitted : string;
    rStatus : string;
    f_name : string;
    l_name : string;
    
    constructor(rId: number, amount: number, rDescription: string, 
        timeSubmitted: string, rStatus: string, f_name: string, l_name:string) { }
}