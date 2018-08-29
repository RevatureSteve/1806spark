import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeReimbursementComponent } from './employee-reimbursement.component';

describe('EmployeeReimbursementComponent', () => {
  let component: EmployeeReimbursementComponent;
  let fixture: ComponentFixture<EmployeeReimbursementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeReimbursementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeReimbursementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
