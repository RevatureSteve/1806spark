import { Component } from '@angular/core';

@Component({
  selector: 'app-routing',
  templateUrl: './routing.component.html',
  styleUrls: ['./routing.component.css']
})
export class RoutingComponent {
  title = 'Routing';
  subTitleDeclaration = 'Declaration';
  image = 'assets/images/routing.png';
  subtitleImageDeclaration = 'assets/images/routingDeclaration.png';
  documentation = 'https://angular.io/guide/router';
}