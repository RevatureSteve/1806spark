import { Component, OnInit } from '@angular/core';



@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  clicked = false;

  constructor() { }

  ngOnInit() {
  }

  boxClicked(): void{
    this.clicked = !this.clicked;
    console.log('Box clicked ' + this.clicked);
  }
}
