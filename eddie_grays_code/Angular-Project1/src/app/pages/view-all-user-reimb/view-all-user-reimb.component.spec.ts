import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllUserReimbComponent } from './view-all-user-reimb.component';

describe('ViewAllUserReimbComponent', () => {
  let component: ViewAllUserReimbComponent;
  let fixture: ComponentFixture<ViewAllUserReimbComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAllUserReimbComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllUserReimbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
