import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpResolvedReimbursementsComponent } from './emp-resolved-reimbursements.component';

describe('EmpResolvedReimbursementsComponent', () => {
  let component: EmpResolvedReimbursementsComponent;
  let fixture: ComponentFixture<EmpResolvedReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpResolvedReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpResolvedReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
