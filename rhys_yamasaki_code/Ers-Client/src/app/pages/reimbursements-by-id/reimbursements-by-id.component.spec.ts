import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementsByIdComponent } from './reimbursements-by-id.component';

describe('ReimbursementsByIdComponent', () => {
  let component: ReimbursementsByIdComponent;
  let fixture: ComponentFixture<ReimbursementsByIdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbursementsByIdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursementsByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
