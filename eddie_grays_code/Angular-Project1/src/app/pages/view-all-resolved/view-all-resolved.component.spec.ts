import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllResolvedComponent } from './view-all-resolved.component';

describe('ViewAllResolvedComponent', () => {
  let component: ViewAllResolvedComponent;
  let fixture: ComponentFixture<ViewAllResolvedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAllResolvedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllResolvedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
