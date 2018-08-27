import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogouthpComponent } from './logouthp.component';

describe('LogouthpComponent', () => {
  let component: LogouthpComponent;
  let fixture: ComponentFixture<LogouthpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogouthpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogouthpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
