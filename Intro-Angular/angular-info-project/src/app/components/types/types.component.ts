import { Component } from '@angular/core';

@Component({
  selector: 'app-types',
  templateUrl: './types.component.html',
  styleUrls: ['./types.component.css']
})
export class TypesComponent {
  title = 'Types';
  image = 'assets/images/types.png';
  documentation = 'https://www.typescriptlang.org/docs/handbook/basic-types.html';
}
