import { Component } from '@angular/core';

@Component({
  selector: 'app-npm',
  templateUrl: './npm.component.html',
  styleUrls: ['./npm.component.css']
})
export class NpmComponent {
  title = 'NPM';
  image = 'assets/images/npm.png';
  documentation = 'https://docs.npmjs.com/getting-started/what-is-npm';
}
