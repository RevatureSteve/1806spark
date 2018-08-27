import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewUserResolvedComponent } from './view-user-resolved.component';

describe('ViewUserResolvedComponent', () => {
  let component: ViewUserResolvedComponent;
  let fixture: ComponentFixture<ViewUserResolvedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewUserResolvedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewUserResolvedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
