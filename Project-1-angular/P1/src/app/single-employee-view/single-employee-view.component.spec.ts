import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleEmployeeViewComponent } from './single-employee-view.component';

describe('SingleEmployeeViewComponent', () => {
  let component: SingleEmployeeViewComponent;
  let fixture: ComponentFixture<SingleEmployeeViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SingleEmployeeViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SingleEmployeeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
