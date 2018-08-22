import { Component } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
    title = 'Welcome to Angular';
    image = 'assets/images/angular.png';
    documentation = 'https://angular.io/docs';
}
