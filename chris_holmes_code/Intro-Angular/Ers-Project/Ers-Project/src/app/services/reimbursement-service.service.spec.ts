import { TestBed, inject } from '@angular/core/testing';

import { ReimbursementServiceService } from './reimbursement-service.service';

describe('ReimbursementServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReimbursementServiceService]
    });
  });

  it('should be created', inject([ReimbursementServiceService], (service: ReimbursementServiceService) => {
    expect(service).toBeTruthy();
  }));
});
