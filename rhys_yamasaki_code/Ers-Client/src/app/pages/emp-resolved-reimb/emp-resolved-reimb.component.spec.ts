import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpResolvedReimbComponent } from './emp-resolved-reimb.component';

describe('EmpResolvedReimbComponent', () => {
  let component: EmpResolvedReimbComponent;
  let fixture: ComponentFixture<EmpResolvedReimbComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpResolvedReimbComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpResolvedReimbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
