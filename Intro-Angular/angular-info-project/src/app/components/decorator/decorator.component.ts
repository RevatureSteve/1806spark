import { Component } from '@angular/core';

@Component({
  selector: 'app-decorator',
  templateUrl: './decorator.component.html',
  styleUrls: ['./decorator.component.css']
})
export class DecoratorComponent {
  title = 'Decorator';
  image = 'assets/images/decorator.png';
  documentation = 'https://www.typescriptlang.org/docs/handbook/decorators.html';
}