import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementComponent } from './reimbursement.component';

describe('ReimbursementComponent', () => {
  let component: ReimbursementComponent;
  let fixture: ComponentFixture<ReimbursementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbursementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
