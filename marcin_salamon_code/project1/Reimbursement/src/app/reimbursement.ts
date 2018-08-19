import { User } from './user';

export class Reimbursement {
    rId: number;
    employee: User;
    manager: User;
    amount: number;
    description: string;
    img: Object;
    timesubmission: string;
    rq_type: string;
    rq_status: string;
    rq_typeId: number;
    rq_statusId: number;
}
