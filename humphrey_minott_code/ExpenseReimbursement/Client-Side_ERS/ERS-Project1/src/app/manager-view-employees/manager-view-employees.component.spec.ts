import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerViewEmployeesComponent } from './manager-view-employees.component';

describe('ManagerViewEmployeesComponent', () => {
  let component: ManagerViewEmployeesComponent;
  let fixture: ComponentFixture<ManagerViewEmployeesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerViewEmployeesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerViewEmployeesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
