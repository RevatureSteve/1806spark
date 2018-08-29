import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpPendingReimbursementsComponent } from './emp-pending-reimbursements.component';

describe('EmpPendingReimbursementsComponent', () => {
  let component: EmpPendingReimbursementsComponent;
  let fixture: ComponentFixture<EmpPendingReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpPendingReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpPendingReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
