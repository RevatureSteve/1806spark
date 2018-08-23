import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementListComponent } from './reimbursement-list.component';

describe('ReimbursementListComponent', () => {
  let component: ReimbursementListComponent;
  let fixture: ComponentFixture<ReimbursementListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbursementListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursementListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
