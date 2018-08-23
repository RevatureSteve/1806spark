import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pokemon } from './pokemon';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

const URL = 'https://pokeapi.co/api/v2/pokemon/';
const websiteURL = 'http://localhost:8080/PokemonWorldAPI/PokemonData';
const pokeImageURL = 'http://www.pokestadium.com/sprites/xy/';
@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor(private http: HttpClient) { }

  scrapePokemon(i: number, ids: number[]) {
    // let pokemon = [];
    if (i < ids.length) {
      const fullUrl = URL + ids[i];
      console.log('getting pokemon id: ' + i);
      this.http.get(fullUrl).subscribe(json => {
        const dbPoke = new Pokemon();
        dbPoke.pokeId = ids[i];
        dbPoke.name = json.name;
        dbPoke.height = json.height;
        dbPoke.experience = json.base_experience;
        dbPoke.imageUrl = pokeImageURL + dbPoke.name + '.gif';
        console.log(dbPoke.name);
        console.log('sending to private db');
        this.http.post(websiteURL, dbPoke, httpOptions).subscribe(resp => {
          console.log('Request complete, move to next pokemon');
          this.scrapePokemon(i + 1, ids);
        });
      });
    } else {
      console.log('done');
    }
  }
}
