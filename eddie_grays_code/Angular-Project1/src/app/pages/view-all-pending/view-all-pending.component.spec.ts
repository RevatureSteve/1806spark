import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllPendingComponent } from './view-all-pending.component';

describe('ViewAllPendingComponent', () => {
  let component: ViewAllPendingComponent;
  let fixture: ComponentFixture<ViewAllPendingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAllPendingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllPendingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
