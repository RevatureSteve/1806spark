import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-show-exit',
  templateUrl: './show-exit.component.html',
  styleUrls: ['./show-exit.component.css']
})
export class ShowExitComponent implements OnInit {

  exitMessage = 'There is no exit';

  constructor() { }

  ngOnInit() {
  }

}
