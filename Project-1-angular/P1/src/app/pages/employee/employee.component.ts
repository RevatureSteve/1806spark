import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  fname = 'bob';
  lname = 'ross';

  constructor() { }

  ngOnInit() {
  }

}
