import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewReimbursementsComponent } from './view-reimbursements.component';

describe('ViewReimbursementsComponent', () => {
  let component: ViewReimbursementsComponent;
  let fixture: ComponentFixture<ViewReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
