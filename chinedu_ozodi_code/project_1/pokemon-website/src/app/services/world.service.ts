import { World } from './../models/world';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

const websiteURL = 'http://localhost:8080/PokemonWorldAPI/world';

@Injectable({
  providedIn: 'root'
})
export class WorldService {

  functions = [];
  world: World;

  constructor(private http: HttpClient) {
    // Get world map from db
    console.log('[LOG] world.service - getting world');
    this.getWorld().subscribe( world => {
      console.log('[LOG] world.service done getting world: ' + world);
      this.world = world;

      this.functions.forEach( func => func());

    });
    // console.log(this.map);
   }

  getWorld(): Observable<World> {
    return this.http.get<World>(websiteURL, httpOptions);
  }
}
