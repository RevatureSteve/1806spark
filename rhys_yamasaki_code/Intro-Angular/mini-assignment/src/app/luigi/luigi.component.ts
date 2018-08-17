import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-luigi',
  templateUrl: './luigi.component.html',
  styleUrls: ['./luigi.component.css']
})
export class LuigiComponent implements OnInit {

  luigi = 'Its a Luigi';

  constructor() { }

  ngOnInit() {
  }

}
