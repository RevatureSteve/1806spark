import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeApprovedReimbursementsComponent } from './employee-approved-reimbursements.component';

describe('EmployeeApprovedReimbursementsComponent', () => {
  let component: EmployeeApprovedReimbursementsComponent;
  let fixture: ComponentFixture<EmployeeApprovedReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeApprovedReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeApprovedReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
