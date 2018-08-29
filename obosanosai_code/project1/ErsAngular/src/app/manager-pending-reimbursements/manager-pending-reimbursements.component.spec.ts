import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerPendingReimbursementsComponent } from './manager-pending-reimbursements.component';

describe('ManagerPendingReimbursementsComponent', () => {
  let component: ManagerPendingReimbursementsComponent;
  let fixture: ComponentFixture<ManagerPendingReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerPendingReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerPendingReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
