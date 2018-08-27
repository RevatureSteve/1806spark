import { TestBed, inject } from '@angular/core/testing';

import { CreateReimbService } from './create-reimb.service';

describe('CreateReimbService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CreateReimbService]
    });
  });

  it('should be created', inject([CreateReimbService], (service: CreateReimbService) => {
    expect(service).toBeTruthy();
  }));
});
