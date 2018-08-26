import { Component, OnInit } from '@angular/core';
import { SubmitService } from '../../services/submit.service';

@Component({
  selector: 'app-submit',
  templateUrl: './submit.component.html',
  styleUrls: ['./submit.component.css']
})
export class SubmitComponent implements OnInit {
  success: number;
  constructor(private submit: SubmitService) { }

  ngOnInit() {
  }

  submitNewReimbursement(amount, description, id) {
    const amt = Number.parseFloat(amount);
    const rqId = Number.parseInt(id);
    this.submit.submit(amt, description, rqId).subscribe(r => this.success = r);
  }

  successClear() {
    this.success = -1;
  }
}
