import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementDetailsComponent } from './reimbursement-details.component';

describe('ReimbursementDetailsComponent', () => {
  let component: ReimbursementDetailsComponent;
  let fixture: ComponentFixture<ReimbursementDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbursementDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursementDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
