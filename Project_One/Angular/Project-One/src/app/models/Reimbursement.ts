export class Reimbursement {
r_Id: number;
amt: number;
emp_U_Id: number;
mgr_U_Id: number;
rq_Type_Id: number;
rq_Status_Id: number;
description: string;
timeSubmission: string;

constructor(rId: number, amount: number, employeeId: number, managerId: number,
requestType: number, statusId: number, description: string, timesubmission: string) {}
}
