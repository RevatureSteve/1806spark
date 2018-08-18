import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clicker',
  templateUrl: './clicker.component.html',
  styleUrls: ['./clicker.component.css']
})
export class ClickerComponent implements OnInit {

  count = 0;

  constructor() { }

  ngOnInit() {
  }

  public incrementCount(): void {
    const div = document.createElement('div');
    div.setAttribute('_ngcontent-c1', undefined);
    // div.innerHTML = 'bullet';
    div.classList.add('bullet');
    document.getElementById('field').appendChild(div);
    this.count++;
  }

}
