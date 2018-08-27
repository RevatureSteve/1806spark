import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitReimbursementsComponent } from './submit-reimbursements.component';

describe('SubmitReimbursementsComponent', () => {
  let component: SubmitReimbursementsComponent;
  let fixture: ComponentFixture<SubmitReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubmitReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubmitReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
