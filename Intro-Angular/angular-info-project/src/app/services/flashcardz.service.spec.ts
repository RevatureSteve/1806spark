import { TestBed, inject } from '@angular/core/testing';

import { FlashcardzService } from './flashcardz.service';

describe('FlashcardzService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FlashcardzService]
    });
  });

  it('should be created', inject([FlashcardzService], (service: FlashcardzService) => {
    expect(service).toBeTruthy();
  }));
});
