import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-world-tile',
  templateUrl: './world-tile.component.html',
  styleUrls: ['./world-tile.component.css']
})
export class WorldTileComponent implements OnInit {

  @Input()
  x: number;
  @Input()
  y: number;

  constructor() { }

  ngOnInit() {
  }

}
