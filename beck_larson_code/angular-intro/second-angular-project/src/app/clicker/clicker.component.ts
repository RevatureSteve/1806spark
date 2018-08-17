import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clicker',
  templateUrl: './clicker.component.html',
  styleUrls: ['./clicker.component.css']
})
export class ClickerComponent implements OnInit {
  count = 0;
  isEven = true;

  names = ['john', 'sam', 'mary', 'johnson', 'bobbert'] 
  constructor() { }

  incrementCount = function(){
    console.log('we are counting');
    this.count++;
    this.isEven = !this.isEven;
  }
  randomOnetoTen = function(){
    let randy = Math.floor(Math.random() *10)+1;
    console.log('the rand num is ' + randy);
    this.count += randy
    if(!(this.count % 2)){
      this.isEven = true; 
    }else{
      this.isEven =false;
    }
  }
  ngOnInit() {
  }

}
