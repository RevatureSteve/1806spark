import { TestBed, inject } from '@angular/core/testing';

import { LoggeduserService } from './loggeduser.service';

describe('LoggeduserService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LoggeduserService]
    });
  });

  it('should be created', inject([LoggeduserService], (service: LoggeduserService) => {
    expect(service).toBeTruthy();
  }));
});
