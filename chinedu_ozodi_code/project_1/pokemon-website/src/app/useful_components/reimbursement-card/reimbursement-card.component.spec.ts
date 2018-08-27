import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementCardComponent } from './reimbursement-card.component';

describe('ReimbursementCardComponent', () => {
  let component: ReimbursementCardComponent;
  let fixture: ComponentFixture<ReimbursementCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbursementCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursementCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
