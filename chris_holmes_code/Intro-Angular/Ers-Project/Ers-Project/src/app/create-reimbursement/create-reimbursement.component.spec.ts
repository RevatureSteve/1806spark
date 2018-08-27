import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateReimbursementComponent } from './create-reimbursement.component';

describe('CreateReimbursementComponent', () => {
  let component: CreateReimbursementComponent;
  let fixture: ComponentFixture<CreateReimbursementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateReimbursementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateReimbursementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
