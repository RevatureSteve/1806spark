import { Router } from '@angular/router';
import { LoggedInService } from './../../logged-in.service';
import { UpdateUserService } from './../../update-user.service';
import { Users } from './../../models/Users';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  updateUser: Users;
  user: Users;

  constructor(private updateUserService: UpdateUserService, private loggedInService: LoggedInService, private router: Router) { }

  ngOnInit() {
    this.user = this.loggedInService.getLoggedInUser();
  }

  updatingUser(email, password, fname, lname, u_Id): void {
    console.log('service: updatingUser');
    this.updateUserService.updateUser(email, password, fname, lname, u_Id).subscribe(
      update => {
        console.log('updating your information');
        alert('Update submission complete');
        this.router.navigate(['/', 'info']);
      }
    );
  }

}
