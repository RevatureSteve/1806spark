import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clicker',
  templateUrl: './clicker.component.html',
  styleUrls: ['./clicker.component.css']
})
export class ClickerComponent implements OnInit {

  count = 0;
  isEven = true;

  constructor() { }

  incrementCount = function() {
    console.log('incrementCount invoked');
    this.count++;
    this.isEven = !this.isEven;
  }
  
  randomIncrementOneAnd10 = function() {
    let randomNumber = Math.floor((Math.random() * 10)) + 1;
    console.log('The random number is: ' + randomNumber);
    this.isEven = (this.count % 2 == 0) ? true : false;
  }

  ngOnInit() {
  }

}
