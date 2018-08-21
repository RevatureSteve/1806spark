import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpComponent } from './emp.component';

describe('EmpComponent', () => {
  let component: EmpComponent;
  let fixture: ComponentFixture<EmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
