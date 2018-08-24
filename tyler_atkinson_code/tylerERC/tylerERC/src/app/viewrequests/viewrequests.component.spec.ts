import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewrequestsComponent } from './viewrequests.component';

describe('ViewrequestsComponent', () => {
  let component: ViewrequestsComponent;
  let fixture: ComponentFixture<ViewrequestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewrequestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewrequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
