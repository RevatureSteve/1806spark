import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-world',
  templateUrl: './world.component.html',
  styleUrls: ['./world.component.css']
})
export class WorldComponent implements OnInit {

  _2 = 'world!';

  constructor() { }

  ngOnInit() {
  }

}
