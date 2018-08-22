import { Component } from '@angular/core';

@Component({
  selector: 'app-package',
  templateUrl: './package.component.html',
  styleUrls: ['./package.component.css']
})
export class PackageComponent {
  title = 'package.json';
  image = 'assets/images/package.jpg';
  documentation = 'https://docs.npmjs.com/files/package.json';
}
