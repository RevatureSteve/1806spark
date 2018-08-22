import { TestBed, inject } from '@angular/core/testing';

import { ReimbursementListService } from './reimbursement-list.service';

describe('ReimbursementListService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReimbursementListService]
    });
  });

  it('should be created', inject([ReimbursementListService], (service: ReimbursementListService) => {
    expect(service).toBeTruthy();
  }));
});
