import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-small-box',
  templateUrl: './small-box.component.html',
  styleUrls: ['./small-box.component.css']
})
export class SmallBoxComponent implements OnInit {
  smallBox = 'Small Box';
  constructor() { }

  ngOnInit() {
  }

}
