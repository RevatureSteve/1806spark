import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerReimbursementsComponent } from './manager-reimbursements.component';

describe('ManagerReimbursementsComponent', () => {
  let component: ManagerReimbursementsComponent;
  let fixture: ComponentFixture<ManagerReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
