import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeReimbursementsComponent } from './employee-reimbursements.component';

describe('EmployeeReimbursementsComponent', () => {
  let component: EmployeeReimbursementsComponent;
  let fixture: ComponentFixture<EmployeeReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
