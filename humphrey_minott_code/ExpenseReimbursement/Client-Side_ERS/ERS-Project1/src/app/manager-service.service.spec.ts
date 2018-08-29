import { TestBed, inject } from '@angular/core/testing';

import { ManagerServiceService } from './manager-service.service';

describe('ManagerServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ManagerServiceService]
    });
  });

  it('should be created', inject([ManagerServiceService], (service: ManagerServiceService) => {
    expect(service).toBeTruthy();
  }));
});
