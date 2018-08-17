import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mario',
  templateUrl: './mario.component.html',
  styleUrls: ['./mario.component.css']
})
export class MarioComponent implements OnInit {

  mario = 'Its a me, Mario';
  constructor() { }

  ngOnInit() {
  }

}
