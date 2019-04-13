import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingPageComponent } from './pending-page.component';

describe('PendingPageComponent', () => {
  let component: PendingPageComponent;
  let fixture: ComponentFixture<PendingPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendingPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
