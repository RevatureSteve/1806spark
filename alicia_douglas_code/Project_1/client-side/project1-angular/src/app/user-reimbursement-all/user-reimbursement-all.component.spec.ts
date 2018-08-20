import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserReimbursementAllComponent } from './user-reimbursement-all.component';

describe('UserReimbursementAllComponent', () => {
  let component: UserReimbursementAllComponent;
  let fixture: ComponentFixture<UserReimbursementAllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserReimbursementAllComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserReimbursementAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
