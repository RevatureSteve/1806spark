import { TestBed, inject } from '@angular/core/testing';

import { UpdateEmployeeService } from './update-employee.service';

describe('UpdateEmployeeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UpdateEmployeeService]
    });
  });

  it('should be created', inject([UpdateEmployeeService], (service: UpdateEmployeeService) => {
    expect(service).toBeTruthy();
  }));
});
