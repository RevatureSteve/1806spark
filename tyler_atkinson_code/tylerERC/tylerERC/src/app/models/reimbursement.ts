export class Reimbursement {
    // rid: number;
    // empuid: number;
    // mgruid: number;
    // rqtypeid: number;
    // rqstatusid: number;
    // amt: number;
    // description: string;
    // timesubmission: string;
    // img:string;
    // reimbursementrequests: string;

    constructor(
        public rid: number,
        public empuid: number,
        public mgruid: number,
        public rqtypeid: number,
        public rq_status_id: number,
        public amt: number,
        public description: string,
        public timesubmission: string,
        public reimbursementrequests: string,
        public img?:string
    ){}
}