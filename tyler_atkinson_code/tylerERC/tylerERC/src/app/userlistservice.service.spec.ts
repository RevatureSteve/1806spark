import { TestBed, inject } from '@angular/core/testing';

import { UserlistserviceService } from './userlistservice.service';

describe('UserlistserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserlistserviceService]
    });
  });

  it('should be created', inject([UserlistserviceService], (service: UserlistserviceService) => {
    expect(service).toBeTruthy();
  }));
});
