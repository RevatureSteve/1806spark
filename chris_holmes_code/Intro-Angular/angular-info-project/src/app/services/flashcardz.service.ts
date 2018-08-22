import { Flashcardz } from './../models/flashcardz.model';
import { Observable } from 'rxjs/Observable';
import { Http, Response } from '@angular/http';
import { Injectable } from '@angular/core';

@Injectable()
export class FlashcardzService {
  url = `http://localhost:8085/FlashCardAPI/api/v1/flashcard/all`;

  // injecting
  constructor(private http: Http) { }

  getAllFlashcardz(): Observable<Flashcardz[]> {
    return this.http
        .get(this.url)
        // must import Response datatype
        .map( (response: Response) => {
          return <Flashcardz[]> response.json();
        });
  }

}
