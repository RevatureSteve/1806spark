import { TestBed, inject } from '@angular/core/testing';

import { LoggedUserService } from './logged-user.service';

describe('LoggedUserService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LoggedUserService]
    });
  });

  it('should be created', inject([LoggedUserService], (service: LoggedUserService) => {
    expect(service).toBeTruthy();
  }));
});
