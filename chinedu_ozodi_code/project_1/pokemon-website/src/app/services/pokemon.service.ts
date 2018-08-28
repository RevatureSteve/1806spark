import { RequestStatus } from '../models/request_status';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pokemon } from '../models/pokemon';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

const URL = 'https://pokeapi.co/api/v2/pokemon/';
const pokemonDataUrl = 'http://localhost:8080/PokemonWorldAPI/PokemonData';
const pokemonUrl = 'http://localhost:8080/PokemonWorldAPI/pokemon';
const pokeImageURL = 'http://www.pokestadium.com/sprites/xy/';
@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  pokemonBattle: Pokemon;

  constructor(private http: HttpClient) { }

  scrapePokemon(i: number, ids: number[]): void {
    // let pokemon = [];
    if (i < ids.length) {
      const fullUrl = URL + ids[i];
      console.log('getting pokemon id: ' + i);
      this.http.get(fullUrl).subscribe(json => {
        const dbPoke = new Pokemon();
        dbPoke.pokeId = ids[i];
        // dbPoke.name = json.name;
        // dbPoke.height = json.height;
        // dbPoke.experience = json.base_experience;
        dbPoke.imageUrl = pokeImageURL + dbPoke.name + '.gif';
        console.log(dbPoke.name);
        console.log('sending to private db');
        this.http.post(pokemonDataUrl, dbPoke, httpOptions).subscribe(resp => {
          console.log('Request complete, move to next pokemon');
          this.scrapePokemon(i + 1, ids);
        });
      });
    } else {
      console.log('done');
    }
  }

  getPokemonByLocalTilePosition(worldTileId: number, local_x: number, local_y: number): Observable<Pokemon[]> {
    const fullUrl = `${pokemonUrl}?worldTileId=${worldTileId}&x=${local_x}&y=${local_y}`;
    return this.http.get<Pokemon[]>(fullUrl);
  }

  updatePokemon(pokemon: Pokemon): Observable<RequestStatus> {
    console.log('[LOG] pokemon.service updating pokemon, id: ' + pokemon.ltId);
    return this.http.put<RequestStatus>(pokemonUrl, pokemon, httpOptions);
  }
}
