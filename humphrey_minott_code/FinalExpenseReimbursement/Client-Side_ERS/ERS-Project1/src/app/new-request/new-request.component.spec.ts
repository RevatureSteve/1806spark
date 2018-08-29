import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewRequestComponent } from './new-request.component';

describe('NewRequestComponent', () => {
  let component: NewRequestComponent;
  let fixture: ComponentFixture<NewRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
