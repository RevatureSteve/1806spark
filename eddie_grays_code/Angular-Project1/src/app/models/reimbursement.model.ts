export class Reimbursement {
    reimbursementId: number;
    empId: number;
    mgrId: number;
    amount: number;
    description: string;
    imageUrl: string;
    timeStamp: string;
    reqTypeId: number;
    reqStatusId: number;

    constructor(reimbursementId: number, empId: number, mgrId: number, amount: number, description: string,
        imageUrl: string, timeStamp: string, reqTypeId: number, reqStatusId: number) {

        this.reimbursementId = reimbursementId;
        this.empId = empId;
        this.mgrId = mgrId;
        this.amount = amount;
        this.description = description;
        this.imageUrl = imageUrl;
        this.timeStamp = timeStamp;
        this.reqTypeId = reqTypeId;
        this.reqStatusId = reqStatusId;
    }

}
