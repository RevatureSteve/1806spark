import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllReimbursementsComponent } from './all-reimbursements.component';

describe('AllReimbursementsComponent', () => {
  let component: AllReimbursementsComponent;
  let fixture: ComponentFixture<AllReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
