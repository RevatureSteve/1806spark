import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeePendingReimbursementsComponent } from './employee-pending-reimbursements.component';

describe('EmployeePendingReimbursementsComponent', () => {
  let component: EmployeePendingReimbursementsComponent;
  let fixture: ComponentFixture<EmployeePendingReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeePendingReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeePendingReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
