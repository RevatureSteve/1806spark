import { TestBed, inject } from '@angular/core/testing';

import { EmployeeListService } from './employee-list.service';

describe('EmployeeListService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EmployeeListService]
    });
  });

  it('should be created', inject([EmployeeListService], (service: EmployeeListService) => {
    expect(service).toBeTruthy();
  }));
});
