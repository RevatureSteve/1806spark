
export class Reimbursement {
  rb_id: number;
  rb_resolved_id: number;
  rb_submission_id: number;
  amount: number;
  description: string;
  image: Blob;
  time_submission: string;
  rq_type_id: number;
  rq_status_id: number;
  rb_resolved_fname: string;
  rb_resolved_lname: string;
  rb_submission_fname: string;
  rb_submission_lname: string;
  rq_type: string;
  rq_status: string;
}
