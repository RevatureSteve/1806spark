import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clicker',
  templateUrl: './clicker.component.html',
  styleUrls: ['./clicker.component.css']
})
export class ClickerComponent implements OnInit {

  coin1 = '( )';
  coin2 = ' [ ]'

  count = 0;
  isEven = true;
  names = ['john','sam', 'mary', 'bobbert'];

  constructor() { }

  incrementCount = function() {
    console.log('incrementCount invoked');
    this.count++;
    this.isEven = !this.isEven;
  }
  
  randomIncrementOneAnd10 = function() {
    let randomNumber = Math.floor((Math.random() * 10)) + 1;
    console.log('The random number is: ' + randomNumber);
    this.count += randomNumber;
    this.isEven = (this.count % 2 == 0) ? true : false;
    this.coin1 = (this.count % 2 == 0) ? '( )' : '---';
    this.coin2 = (this.count % 2 == 0) ? ' [ ]' : ' ---';
  }

  ngOnInit() {
  }

}
