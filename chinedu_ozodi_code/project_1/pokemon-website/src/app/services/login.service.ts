import { Router } from '@angular/router';
import { Pokemon } from './../models/pokemon';
import { RequestStatus } from '../request_status';
import { User } from '../models/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { getOrCreateContainerRef } from '@angular/core/src/render3/di';
import { Trainer } from '../models/trainer';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
const pokemonUrl = 'http://localhost:8080/PokemonWorldAPI/pokemon';
const trainerUrl = 'http://localhost:8080/PokemonWorldAPI/trainer';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private url = 'http://localhost:8080/PokemonWebsiteAPI/User';

  currentUser: User;
  currentTrainer: Trainer;
  trainerPokemon: Pokemon[];
  constructor(private http: HttpClient, public router: Router) {
    this.log('Login Service started');
  }

  login(user: User): Observable<User> {
    this.log(' login service started');
    return this.http.post<User>(this.url, user, httpOptions).pipe(
      catchError(this.handleError<User>('login', new User()))
    );
  }

  logout() {
    this.currentUser = null;
    this.currentTrainer = null;
    this.trainerPokemon = null;
    this.clearCookie();
    this.router.navigate(['login']);
  }

  getTrainer() {
    this.log('getting trainer: ' + this.currentUser.uId);
    const fullUrl = `${trainerUrl}?id=${this.currentUser.uId}`;
    this.http.get<Trainer>(fullUrl).subscribe(trainer => {
      this.currentTrainer = trainer;
      this.log('trainer: ' + trainer);
      this.getTrainerPokemon();
    });
  }

  getTrainerPokemon() {
    this.log('getting trainer pokemon: ' + this.currentTrainer.trainerId);
    const fullUrl = `${pokemonUrl}?trainerId=${this.currentTrainer.trainerId}`;
    this.http.get<Pokemon[]>(fullUrl).subscribe(pokemon => {
      this.trainerPokemon = pokemon;
      this.log('done fetching pokemon: ' + pokemon);
    });
  }

  checkSession(): void {
    this.log(' checking login session');
    if (!this.currentUser) {
      this.currentUser = this.getUserCookie();
      if (this.currentUser) {
        this.getTrainer();
      } else {
        this.log('no logged in user');
        this.router.navigate(['login']);
      }
    }
  }

  clearCookie() {
    this.setCookie('id', '', 1);
    this.setCookie('pId', '', 1);
    this.setCookie('fname', '', 1);
    this.setCookie('lname', '', 1);
    this.setCookie('email', '', 1);
  }
  saveUserCookie(user: User) {
    this.setCookie('id', user.uId, 1);
    this.setCookie('pId', user.posId, 1);
    this.setCookie('fname', user.fname, 1);
    this.setCookie('lname', user.lname, 1);
    this.setCookie('email', user.email, 1);
  }

  getUserCookie(): User {
    let user: User;
    if (this.getCookie('id')) {
      user = new User();
      user.uId = Number.parseInt(this.getCookie('id'));
      user.posId = Number.parseInt(this.getCookie('pId'));
      user.fname = this.getCookie('fname');
      user.lname = this.getCookie('lname');
      user.email = this.getCookie('email');
    }
    return user;
  }

  setCookie(cname, cvalue, exdays) {
    const d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    const expires = 'expires=' + d.toUTCString();
    document.cookie = cname + '=' + cvalue + ';' + expires + ';path=/';
  }

  getCookie(cname) {
    const name = cname + '=';
    const decodedCookie = decodeURIComponent(document.cookie);
    const ca = decodedCookie.split(';');
    for (let i = 0; i < ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) === ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) === 0) {
        return c.substring(name.length, c.length);
      }
    }
    return '';
  }

  /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
  handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  log(info: string) {
    console.log('Login Service: ' + info);
  }
}

