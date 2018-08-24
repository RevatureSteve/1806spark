import { TestBed, inject } from '@angular/core/testing';

import { LoggedonService } from './loggedon.service';

describe('LoggedonService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LoggedonService]
    });
  });

  it('should be created', inject([LoggedonService], (service: LoggedonService) => {
    expect(service).toBeTruthy();
  }));
});
