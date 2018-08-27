import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateReimbursementComponent } from './update-reimbursement.component';

describe('UpdateReimbursementComponent', () => {
  let component: UpdateReimbursementComponent;
  let fixture: ComponentFixture<UpdateReimbursementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateReimbursementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateReimbursementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
