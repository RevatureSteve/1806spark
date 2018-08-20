import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';




@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  clicked = false;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  boxClicked(): void{
    this.clicked = !this.clicked;
    console.log('Box clicked ' + this.clicked);
  }

  enterClicked(): void {
    // Logic for when enter button clicked
    console.log("Welcome Component: -enter clicked");
    this.router.navigateByUrl('/login');
  }
}
