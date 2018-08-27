import { TestBed, inject } from '@angular/core/testing';

import { HttpTestService } from './http-test.service';

describe('HttpTestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HttpTestService]
    });
  });

  it('should be created', inject([HttpTestService], (service: HttpTestService) => {
    expect(service).toBeTruthy();
  }));
});
