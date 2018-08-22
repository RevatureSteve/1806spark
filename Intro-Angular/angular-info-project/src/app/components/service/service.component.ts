import { Component } from '@angular/core';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent {
  title = 'Service';
  image = 'assets/images/service.png';
  documentation = 'https://angular.io/guide/architecture#services';
}