import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementInformationComponent } from './reimbursement-information.component';

describe('ReimbursementInformationComponent', () => {
  let component: ReimbursementInformationComponent;
  let fixture: ComponentFixture<ReimbursementInformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbursementInformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursementInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
