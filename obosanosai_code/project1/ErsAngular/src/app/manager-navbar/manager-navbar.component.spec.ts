import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerNavbarComponent } from './manager-navbar.component';

describe('ManagerNavbarComponent', () => {
  let component: ManagerNavbarComponent;
  let fixture: ComponentFixture<ManagerNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
