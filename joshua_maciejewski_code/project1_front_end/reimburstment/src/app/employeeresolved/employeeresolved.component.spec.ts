import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeresolvedComponent } from './employeeresolved.component';

describe('EmployeeresolvedComponent', () => {
  let component: EmployeeresolvedComponent;
  let fixture: ComponentFixture<EmployeeresolvedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeresolvedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeresolvedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
