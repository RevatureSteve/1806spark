import { UserService } from './../../services/user.service';
import { LoginService } from './../../services/login.service';
import { Reimbursement } from './../../models/reimbursement';
import { Component, OnInit, Input } from '@angular/core';
import { ReimbursementService } from '../../services/reimbursement.service';

@Component({
  selector: 'app-reimbursement-card',
  templateUrl: './reimbursement-card.component.html',
  styleUrls: ['./reimbursement-card.component.css']
})
export class ReimbursementCardComponent implements OnInit {

  @Input()
  reimb: Reimbursement;

  constructor(
    private reimbursementService: ReimbursementService,
    private login: LoginService,
    private userService: UserService
  ) { }

  ngOnInit() {
    if (this.reimb && this.reimb.mgrUId) {
      this.reimb.mfname = '';
      this.reimb.mlname = '';
      this.userService.getUserById(this.reimb.mgrUId).subscribe(user => {
        this.reimb.mfname = user.fname;
        this.reimb.mlname = user.lname;
      });
    }
  }

  accept() {
    this.userService.getTrainerById(this.reimb.empUId).subscribe(trainer => {
      trainer.candyCount += this.reimb.amt;
      console.log('trainer should now have more candy: ' + trainer.candyCount);
      this.userService.updateTrainer(trainer).subscribe(done => {
        this.reimb.rqStatusId = 4;
        this.reimb.mgrUId = this.login.currentUser.uId;
        this.reimbursementService.updateReimbursement(this.reimb).subscribe();
      });
    });
  }

  decline() {
    this.reimb.rqStatusId = 3;
    this.reimb.mgrUId = this.login.currentUser.uId;
    this.reimbursementService.updateReimbursement(this.reimb).subscribe();
  }
}
