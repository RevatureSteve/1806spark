import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprovedReimbInfoComponent } from './approved-reimb-info.component';

describe('ApprovedReimbInfoComponent', () => {
  let component: ApprovedReimbInfoComponent;
  let fixture: ComponentFixture<ApprovedReimbInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApprovedReimbInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApprovedReimbInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
