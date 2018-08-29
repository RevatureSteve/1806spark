import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeViewRequestsComponent } from './employee-view-requests.component';

describe('EmployeeViewRequestsComponent', () => {
  let component: EmployeeViewRequestsComponent;
  let fixture: ComponentFixture<EmployeeViewRequestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeViewRequestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeViewRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
