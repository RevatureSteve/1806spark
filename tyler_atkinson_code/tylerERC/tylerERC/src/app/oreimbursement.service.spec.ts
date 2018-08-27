import { TestBed, inject } from '@angular/core/testing';

import { OReimbursementService } from './oreimbursement.service';

describe('OReimbursementService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OReimbursementService]
    });
  });

  it('should be created', inject([OReimbursementService], (service: OReimbursementService) => {
    expect(service).toBeTruthy();
  }));
});
