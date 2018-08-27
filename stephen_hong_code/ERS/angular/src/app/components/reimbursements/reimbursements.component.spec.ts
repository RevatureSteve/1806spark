import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementsComponent } from './reimbursements.component';

describe('ReimbursementsComponent', () => {
  let component: ReimbursementsComponent;
  let fixture: ComponentFixture<ReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
