import { Trainer } from './../../models/trainer';
import { User } from './../../models/user';
import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../../login/login.component';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  employeeType = ['trainer', 'manager'];
  createNew = false;
  users: User[];
  trainers: Trainer[];
  newTrainer = new Trainer();
  newUser = new User();

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getEmployees();
  }

  newEmployeeToggle() {
    this.createNew = !this.createNew;
  }

  createUser() {
    this.newTrainer.pokeballCount = 10;
    this.newTrainer.candyCount = 10;
    console.log('[LOG] Employees component, new user. Pos id: ' + this.newUser.posId);
    this.userService.createUser(this.newUser).subscribe(done => {
      this.userService.getUserByEmail(this.newUser.email).subscribe(user => {
        this.newUser = user;
        this.newTrainer.trainerId = user.uId;
        this.userService.createTrainer(this.newTrainer).subscribe( complete => {
          this.getEmployees();
        });
      });
    });
  }

  getEmployees() {
    this.trainers = [];
    this.userService.getAllUsers().subscribe(users => {
      this.userService.getAllTrainers().subscribe( trainers => {
        this.users = users;
        for (let i = 0; i < users.length; i++) {
          this.trainers.push(trainers.find(trainer => trainer.trainerId === users[i].uId));
        }
      });
    });
  }
}
