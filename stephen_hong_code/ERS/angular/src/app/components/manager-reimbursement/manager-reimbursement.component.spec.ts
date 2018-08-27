import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerReimbursementComponent } from './manager-reimbursement.component';

describe('ManagerReimbursementComponent', () => {
  let component: ManagerReimbursementComponent;
  let fixture: ComponentFixture<ManagerReimbursementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerReimbursementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerReimbursementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
