import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewReimbursementComponent } from './new-reimbursement.component';

describe('NewReimbursementComponent', () => {
  let component: NewReimbursementComponent;
  let fixture: ComponentFixture<NewReimbursementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewReimbursementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewReimbursementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
