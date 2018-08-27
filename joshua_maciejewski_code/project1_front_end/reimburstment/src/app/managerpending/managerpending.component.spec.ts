import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerpendingComponent } from './managerpending.component';

describe('ManagerpendingComponent', () => {
  let component: ManagerpendingComponent;
  let fixture: ComponentFixture<ManagerpendingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerpendingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerpendingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
