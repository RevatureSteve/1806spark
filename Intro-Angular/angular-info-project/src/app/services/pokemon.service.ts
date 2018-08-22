import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
// map() function which maps http responses into our objects
import 'rxjs/Rx';

// Models
import { Pokemon } from '../models/pokemon.model';

@Injectable()
export class PokemonService {

    // Injecting the http object
    constructor(private http: Http) {}

    public fetchPokemonInformation(id: number): Observable<Pokemon> {
        return this.http
                .get(`https://pokeapi.co/api/v2/pokemon/${id}`)
                .map((response: Response) => {
                    return <Pokemon> response.json();
                })
                .catch(this.handleError);
    }

    private handleError(error: Response) {
        return Observable.throw(error.statusText);
    }
}