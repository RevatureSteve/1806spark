import { Component } from '@angular/core';

@Component({
  selector: 'app-class',
  templateUrl: './class.component.html',
  styleUrls: ['./class.component.css']
})
export class ClassComponent {
  title = 'Class';
  image = 'assets/images/class.png';
  documentation = 'https://www.typescriptlang.org/docs/handbook/classes.html';
}
