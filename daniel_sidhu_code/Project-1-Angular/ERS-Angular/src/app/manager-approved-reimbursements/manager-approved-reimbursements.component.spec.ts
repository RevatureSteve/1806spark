import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerApprovedReimbursementsComponent } from './manager-approved-reimbursements.component';

describe('ManagerApprovedReimbursementsComponent', () => {
  let component: ManagerApprovedReimbursementsComponent;
  let fixture: ComponentFixture<ManagerApprovedReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerApprovedReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerApprovedReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
