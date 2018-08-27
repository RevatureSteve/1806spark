import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StatusRequestComponent } from './status-request.component';

describe('StatusRequestComponent', () => {
  let component: StatusRequestComponent;
  let fixture: ComponentFixture<StatusRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StatusRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StatusRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
