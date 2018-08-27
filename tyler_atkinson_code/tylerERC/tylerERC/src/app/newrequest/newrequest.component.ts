import { Component, OnInit } from '@angular/core';
import { CreateService } from '../services/create.service';

@Component({
  selector: 'app-newrequest',
  templateUrl: './newrequest.component.html',
  styleUrls: ['./newrequest.component.css']
})
export class NewrequestComponent implements OnInit {

  success: number;
  constructor(private submit: CreateService) { }

  clickMessage = ''

 

  ngOnInit() {
  }

  submitNewReimbursement(empuid, mgruid, amt, description, img, rqtypeid) {
     
      const eid = Number.parseInt(empuid);
      const mid = Number.parseInt(mgruid);
      const at  = Number.parseInt(amt);
      const nosense = Number.parseInt(rqtypeid)
      console.log(rqtypeid)
      console.log(nosense)
      this.submit.submit(eid, mid, at, description, img, nosense).subscribe( r => this.success = r);

      this.clickMessage = 'Request Successfully Submitted';
  }
  
  successClear(){
    this.success = -1;
  }

  clickSubmit(){

  

}

}
