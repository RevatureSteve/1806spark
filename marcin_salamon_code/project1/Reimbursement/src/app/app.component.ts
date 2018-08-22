import { Component } from '@angular/core';
import { User } from './user';
import { LoggedUserService } from './logged-user.service';
import { logging } from 'protractor';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Reimbursement';

  constructor(private logged: LoggedUserService) { }
}
