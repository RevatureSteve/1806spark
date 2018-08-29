import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerViewSpecificComponent } from './manager-view-specific.component';

describe('ManagerViewSpecificComponent', () => {
  let component: ManagerViewSpecificComponent;
  let fixture: ComponentFixture<ManagerViewSpecificComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerViewSpecificComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerViewSpecificComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
