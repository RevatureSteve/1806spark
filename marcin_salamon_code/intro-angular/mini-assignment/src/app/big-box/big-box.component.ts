import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-big-box',
  templateUrl: './big-box.component.html',
  styleUrls: ['./big-box.component.css']
})
export class BigBoxComponent implements OnInit {
  bigBox = 'Big Box';
  constructor() { }

  ngOnInit() {
  }

}
