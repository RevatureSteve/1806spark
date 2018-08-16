import { Injectable } from '@angular/core';
 
import { Observable, of } from 'rxjs';
 
import { Hero } from './hero';
import { HEROES } from './mock-heros';
import { MessageService } from './message.service';
 
@Injectable({
  providedIn: 'root',
})
export class HeroService {
 
  constructor(private messageService: MessageService) { }
  
  getHero(id: number): Observable<Hero> {
    // TODO: send the message _after_ fetching the hero
    this.messageService.add(`HeroService: fetched hero id=${id}`);
    return of(HEROES.find(hero => hero.id === id));
  }
  getHeroes(): Observable<Hero[]> {
    // TODO: send the message _after_ fetching the heroes
    this.messageService.add('HeroService: fetched heroes');
    return of(HEROES);
  }
}