import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerviewemployeesComponent } from './managerviewemployees.component';

describe('ManagerviewemployeesComponent', () => {
  let component: ManagerviewemployeesComponent;
  let fixture: ComponentFixture<ManagerviewemployeesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerviewemployeesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerviewemployeesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
