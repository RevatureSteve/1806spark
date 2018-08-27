import { TestBed, inject } from '@angular/core/testing';

import { ReimbursementService } from './reimbursement.service';

describe('ReimbursementService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReimbursementService]
    });
  });

  it('should be created', inject([ReimbursementService], (service: ReimbursementService) => {
    expect(service).toBeTruthy();
  }));
});
