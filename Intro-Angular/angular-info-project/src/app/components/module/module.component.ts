import { Component } from '@angular/core';

@Component({
  selector: 'app-module',
  templateUrl: './module.component.html',
  styleUrls: ['./module.component.css']
})
export class ModuleComponent {
  title = 'Module';
  subTitleNgModule = '@NgModule';
  image = 'assets/images/module.png';
  subTitleImageNgModule = 'assets/images/ngmodule.png';
  documentation = 'https://angular.io/guide/architecture#modules';
}
