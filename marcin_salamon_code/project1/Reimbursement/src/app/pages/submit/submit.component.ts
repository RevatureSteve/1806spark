import { Component, OnInit } from '@angular/core';
import { SubmitService } from '../../services/submit.service';

@Component({
  selector: 'app-submit',
  templateUrl: './submit.component.html',
  styleUrls: ['./submit.component.css']
})
export class SubmitComponent implements OnInit {
  constructor(private submit: SubmitService) { }

  ngOnInit() {
  }

  submitNewReimbursement(amount, description, id) {
    this.submit.submit(amount, description, id);
  }

}
