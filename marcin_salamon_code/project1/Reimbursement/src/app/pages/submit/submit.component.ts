import { Component, OnInit } from '@angular/core';
import { SubmitService } from '../../services/submit.service';
import { toUnicode } from 'punycode';

@Component({
  selector: 'app-submit',
  templateUrl: './submit.component.html',
  styleUrls: ['./submit.component.css']
})
export class SubmitComponent implements OnInit {
  success: number;
  file: File;
  filename;
  url: any = null;
  byteFile = null;
  constructor(private submit: SubmitService) { }

  ngOnInit() {
  }

  submitNewReimbursement(amount, description, id) {
    const amt = Number.parseFloat(amount);
    const rqId = Number.parseInt(id);
    if (!amt) {
      this.success = 0;
    } else {
      this.submit.submit(amt, description, rqId, this.byteFile).subscribe(r => this.success = r);
    }
  }

  successClear() {
    this.success = -1;
  }

  onFileChanged(event) {
    this.file = event.target.files[0];
    this.filename = this.file.name;
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();

      reader.readAsDataURL(event.target.files[0]); // read file as data url

      reader.onload = (ev) => { // called once readAsDataURL is completed
        this.url = reader.result;
        this.byteFile = this.url.substring(23);
      };
    }
  }
}

