import { TestBed, inject } from '@angular/core/testing';

import { ReimbursementsListService } from './reimbursements-list.service';

describe('ReimbursementsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReimbursementsListService]
    });
  });

  it('should be created', inject([ReimbursementsListService], (service: ReimbursementsListService) => {
    expect(service).toBeTruthy();
  }));
});
