import { Component } from '@angular/core';

@Component({
  selector: 'app-component',
  templateUrl: './component.component.html',
  styleUrls: ['./component.component.css']
})
export class ComponentComponent {
  title = 'Component';
  subTitleDeclaration = 'Declaration';
  subTitleLifecycle = "Lifecycle";
  subTitleHooks = "Hooks";
  image = 'assets/images/component.png';
  subTitleImageDeclaration = 'assets/images/componentDeclaration.png';
  subTitleImageLifecycle = 'assets/images/componentLifecycle.png';
  documentation = 'https://angular.io/guide/architecture#components';
}