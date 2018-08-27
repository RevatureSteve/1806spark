import { TestBed, inject } from '@angular/core/testing';

import { UpdateReimbService } from './update-reimb.service';

describe('UpdateReimbService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UpdateReimbService]
    });
  });

  it('should be created', inject([UpdateReimbService], (service: UpdateReimbService) => {
    expect(service).toBeTruthy();
  }));
});
