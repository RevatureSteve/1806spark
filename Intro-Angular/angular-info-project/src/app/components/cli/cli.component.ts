import { Component } from '@angular/core';

@Component({
  selector: 'app-cli',
  templateUrl: './cli.component.html',
  styleUrls: ['./cli.component.css']
})
export class CliComponent {
  title = 'Angular CLI';
  image = 'assets/images/cli.png';
  documentation = 'https://cli.angular.io/';
}
