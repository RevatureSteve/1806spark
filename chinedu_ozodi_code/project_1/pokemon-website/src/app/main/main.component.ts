import { Component, OnInit } from '@angular/core';
import { WorldTile } from './world_tile';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  height = 10;
  width = 15;
  map: WorldTile[][] = [];

  constructor() {

    for (let y = 0; y < this.height; y++) {
      this.map.push([]);
      for (let x = 0; x < this.width; x++) {
      // generate a tile object
      this.map[y].push(new WorldTile());
      }
    }
    // console.log(this.map);
  }

  ngOnInit() {
  }

}
