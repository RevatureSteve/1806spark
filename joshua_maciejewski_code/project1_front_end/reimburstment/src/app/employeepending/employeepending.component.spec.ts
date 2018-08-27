import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeependingComponent } from './employeepending.component';

describe('EmployeependingComponent', () => {
  let component: EmployeependingComponent;
  let fixture: ComponentFixture<EmployeependingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeependingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeependingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
