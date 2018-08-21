import { Component, OnInit } from '@angular/core';
import { Users } from '../Users';

@Component({
  selector: 'app-emp',
  templateUrl: './emp.component.html',
  styleUrls: ['./emp.component.css']
})
export class EmpComponent implements OnInit {
links = [
  'Home',
  'Agent Profile',
  'Missions',
  'Agent Status'
];
// Harcoded agent for testing
agent: Users = {
  id:  1,
  first: 'James',
  last: 'Bond',
   email: 'jb@bss.com',
  password: '007',
  position:  2,
 };

  constructor() { }

  ngOnInit() {
  }















}
