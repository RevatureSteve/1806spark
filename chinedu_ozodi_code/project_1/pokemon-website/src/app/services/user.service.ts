import { RequestStatus } from './../models/request_status';
import { Observable } from 'rxjs';
import { Trainer } from './../models/trainer';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
const trainerUrl = 'http://localhost:8080/PokemonWorldAPI/trainer';
const userUrl = 'http://localhost:8080/PokemonWebsiteAPI/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  createUser(user: User): Observable<RequestStatus> {
    this.log('creating user: ' + user.uId);
    return this.http.post<RequestStatus>(userUrl, user, httpOptions);
  }

  createTrainer(trainer: Trainer): Observable<RequestStatus> {
    this.log('creating trainer: ' + trainer.trainerId);
    return this.http.post<RequestStatus>(trainerUrl, trainer, httpOptions);
  }

  getUserById(id: number): Observable<User> {
    this.log('get user by id: ' + id);
    const fullUrl = `${userUrl}?userId=${id}`;
    return this.http.get<User>(fullUrl);
  }

  getUserByEmail(email: String): Observable<User> {
    this.log('get user by email: ' + email);
    const fullUrl = `${userUrl}?email=${email}`;
    return this.http.get<User>(fullUrl);
  }

  getAllUsers(): Observable<User[]> {
    this.log('getting all users ');
    return this.http.get<User[]>(userUrl);
  }

  getAllTrainers(): Observable<Trainer[]> {
    this.log('getting all trainers');
    return this.http.get<Trainer[]>(trainerUrl);
  }

  getTrainerById(id: number): Observable<Trainer> {
    this.log('getting trainer: ' + id);
    const fullUrl = `${trainerUrl}?id=${id}`;
    return this.http.get<Trainer>(fullUrl);
  }

  updateTrainer(trainer: Trainer): Observable<RequestStatus> {
    this.log('updating trainer: ' + trainer.trainerId);
    return this.http.put<RequestStatus>(trainerUrl, trainer, httpOptions);
  }

  updateUser(user: User): Observable<RequestStatus> {
    this.log('updating user: ' + user.uId);
    return this.http.put<RequestStatus>(userUrl, user, httpOptions);
  }

  log(info: string) {
    console.log('[LOG] User Service: ' + info);
  }
}
