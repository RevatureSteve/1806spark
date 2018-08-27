import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
//import {UserService} from 'c:\Users\Joshua\my_git_repos\1806spark\joshua_maciejewski_code\project1_front_end\reimburstment\src\app\user.service';
//import { User } from 'C:\Users\Joshua\my_git_repos\1806spark\joshua_maciejewski_code\project1_front_end\reimburstment\src\app\models\user';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent implements OnInit {

  user : User;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.user=JSON.parse(localStorage.getItem('user'));
    //this.user.email = 'emai44';

    console.log(this.user.email + "edit profile")

  }

  updateUser(email, password, fname, lname) {
    const u_id = this.user.u_id;
    console.log(u_id);
    console.log(email);
    console.log(password);
    console.log(fname);
    console.log(lname);

    this.userService.updateUser(u_id, email, password, fname, lname)
    .subscribe(user => this.user = user);
    // this.currentUser.setCurrentUser(this.user);
  }

}

// updateUser(email, fname, lname) {
//   const id = this.user.u_id;
//   this.userService.updateUser(id, email, fname, lname)
//     .subscribe(user => this.user = user);
//   this.currentUser.setCurrentUser(this.user);
// }
