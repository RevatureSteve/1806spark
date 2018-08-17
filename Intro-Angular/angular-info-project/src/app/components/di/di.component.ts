import { Component } from '@angular/core';

@Component({
  selector: 'app-di',
  templateUrl: './di.component.html',
  styleUrls: ['./di.component.css']
})
export class DiComponent {
  title = 'Dependency Injection';
  subTitleInjectable = '@Injectable'
  image = 'assets/images/di.png';
  subTitleImageInjectable = 'assets/images/injectable.png';
  subTitleImageInjected = 'assets/images/injected.png';
  documentation = 'https://angular.io/guide/architecture#dependency-injection';
}