import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OneReimbursementComponent } from './one-reimbursement.component';

describe('OneReimbursementComponent', () => {
  let component: OneReimbursementComponent;
  let fixture: ComponentFixture<OneReimbursementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OneReimbursementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OneReimbursementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
