import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-chuck-norris',
  templateUrl: './chuck-norris.component.html',
  styleUrls: ['./chuck-norris.component.css']
})
export class ChuckNorrisComponent implements OnInit {

  joke = '';

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.getJoke();
  }

  getJoke() {
    this.httpClient.get("http://api.icndb.com/jokes/random")
    .subscribe((resp: any) => {
      this.joke = resp.value.joke;
    });
  }

}
