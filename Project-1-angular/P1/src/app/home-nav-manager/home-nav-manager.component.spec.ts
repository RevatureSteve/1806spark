import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeNavManagerComponent } from './home-nav-manager.component';

describe('HomeNavManagerComponent', () => {
  let component: HomeNavManagerComponent;
  let fixture: ComponentFixture<HomeNavManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeNavManagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeNavManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
