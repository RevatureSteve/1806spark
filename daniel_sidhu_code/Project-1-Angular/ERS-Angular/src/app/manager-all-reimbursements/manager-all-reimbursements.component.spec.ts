import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerAllReimbursementsComponent } from './manager-all-reimbursements.component';

describe('ManagerAllReimbursementsComponent', () => {
  let component: ManagerAllReimbursementsComponent;
  let fixture: ComponentFixture<ManagerAllReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerAllReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerAllReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
