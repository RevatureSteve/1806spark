import { Flashcardz } from './../../models/flashcardz.model';
import { FlashcardzService } from './../../services/flashcardz.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-flashcardz',
  templateUrl: './flashcardz.component.html',
  styleUrls: ['./flashcardz.component.css']
})
export class FlashcardzComponent implements OnInit {

  public flashCardz1: Flashcardz[] = [];
  // For injecting
  constructor(private flashcardzService: FlashcardzService) { }

  getFcs() {
    // logic for the service
    this.flashcardzService
          .getAllFlashcardz()
          .subscribe(
            flashcardz => this.flashCardz1 = flashcardz
          );
  }
  // For initializing
  ngOnInit() {
    this.getFcs();
  }

}
