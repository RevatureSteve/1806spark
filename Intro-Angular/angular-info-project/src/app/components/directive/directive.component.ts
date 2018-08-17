import { Component } from '@angular/core';

@Component({
  selector: 'app-directive',
  templateUrl: './directive.component.html',
  styleUrls: ['./directive.component.css']
})
export class DirectiveComponent {
  title = 'Directive';
  subTitleStructural = 'Structural';
  subTitleAttribute = 'Attribute';
  image = 'assets/images/directive.png';
  documentation = 'https://angular.io/guide/architecture#directives';
}