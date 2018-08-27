import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageReimbursementsComponent } from './manage-reimbursements.component';

describe('ManageReimbursementsComponent', () => {
  let component: ManageReimbursementsComponent;
  let fixture: ComponentFixture<ManageReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManageReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
