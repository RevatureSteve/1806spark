import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clicker',
  templateUrl: './clicker.component.html',
  styleUrls: ['./clicker.component.css']
})
export class ClickerComponent implements OnInit {
  count = 0;
  isEven = true;
  names = ['john', 'sam', 'mary', 'bobbert'];

  constructor() { }

  incrementCount = function() {
    console.log('incrementCount invoked');
    this.count++;
    this.isEven = !this.isEven;
  };
  randomIncrementOneAnd10 = function() {
    const randomNumber = Math.floor(Math.random() * 10) + 1;
    console.log('The random number is: ' + randomNumber);
    this.count += randomNumber;

    if ( !(this.count % 2) ) {
      this.isEven = true;
    } else {
      this.isEven = false;
    }
  };
  ngOnInit() {
  }

}
