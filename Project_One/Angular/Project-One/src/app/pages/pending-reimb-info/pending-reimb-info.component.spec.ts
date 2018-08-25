import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingReimbInfoComponent } from './pending-reimb-info.component';

describe('PendingReimbInfoComponent', () => {
  let component: PendingReimbInfoComponent;
  let fixture: ComponentFixture<PendingReimbInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendingReimbInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingReimbInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
