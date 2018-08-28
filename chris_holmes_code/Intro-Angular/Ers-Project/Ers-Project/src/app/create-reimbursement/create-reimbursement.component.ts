import { RetrievalService } from './../services/retrieval.service';
import { LoggeduserService } from './../services/loggeduser.service';
import { User } from './../models/users';
import { Reimbursements } from './../models/Reimbursements';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-reimbursement',
  templateUrl: './create-reimbursement.component.html',
  styleUrls: ['./create-reimbursement.component.css']
})
export class CreateReimbursementComponent implements OnInit {

 reimbursement: Reimbursements;
user: User; // create user
w;
  constructor(private http: HttpClient,
  private logged: LoggeduserService,
private retrieve: RetrievalService) { }

  ngOnInit() {
    this.user = this.logged.getloggeduser();
  }


      view (x, y , z) {
        console.log(x + '' + y + '' + z );
      }
        SubmitReimbursement(w, x, y, z) {
          console.log('sending request!' + w + '' + x + '' + y + '' + z + '');
          this.retrieve.sendReimbursement(w, x, y, z).subscribe( a => {});

        }


}
