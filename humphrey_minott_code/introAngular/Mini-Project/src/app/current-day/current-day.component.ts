import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-current-day',
  templateUrl: './current-day.component.html',
  styleUrls: ['./current-day.component.css']
})
export class CurrentDayComponent implements OnInit {

  currentDay = "Today is Thursday :)"
  constructor() { }

  ngOnInit() {
  }

}
